package lee;

import java.util.*;
import java.io.*;

import javax.mail.*;
import javax.mail.internet.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class ReceiveMail
{
	private final static String SSL_FACTORY 
		= "javax.net.ssl.SSLSocketFactory";
	//�û��ʺ�
	private String account;
	//����
	private String password;
	//pop3�ʼ�������
	private String pop3Host;
	//pop3�Ķ˿�
	private int pop3Port;
	//account���Ե�setter��getter����
	public void setAccount(String account)
	{
		this.account = account;
	}
	public String getAccount()
	{
		return this.account;
	}
	//password���Ե�setter��getter����
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}
	//pop3Host���Ե�setter��getter����
	public void setPop3Host(String pop3Host)
	{
		this.pop3Host = pop3Host;
	}
	public String getPop3Host()
	{
		return this.pop3Host;
	}
	//pop3Port���Ե�setter��getter����
	public void setPop3Port(int pop3Port)
	{
		this.pop3Port = pop3Port;
	}
	public int getPop3Port()
	{
		return this.pop3Port;
	}
	private Store store;
	public ReceiveMail()
	{
	}	
	public ReceiveMail(String account , String password
		, String pop3Host , int pop3Port)
	{
		this.account = account;
		this.password = password;
		this.pop3Host = pop3Host;
		this.pop3Port = pop3Port;
	}	
	public Store getStore() 
	{
		if (this.store == null 
			|| !this.store.isConnected()) 
		{
			try 
			{
				Properties props = new Properties();
				if (isGmail()) 
				{
					props.setProperty("mail.pop3.socketFactory.class"
						, SSL_FACTORY);
				}
				//����mail��Session
				Session session = Session.getDefaultInstance(props);
				//ʹ��pop3Э������ʼ�
				URLName url = new URLName("pop3", getPop3Host()
					, getPop3Port(), null ,  getAccount(), getPassword());
				//�õ�����Ĵ洢����
				Store store = session.getStore(url);
				store.connect();
				this.store = store;
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("���������쳣������������Ϣ");
			}
		}
		return this.store;
	}
	//����Gmail����ϵͳ��Ҫ�ر���	
	private boolean isGmail() 
	{
		if (this.account == null 
			|| this.account.trim().equals("")) 
			return false;
		if (this.account.lastIndexOf("@gmail.com") != -1)
		{
			return true;
		}
		return false;
	}
	public void getMessages()
	{
		//��ȡ�ռ���
		try 
		{
			Folder inbox = getStore().getFolder("INBOX");
			inbox.open(Folder.READ_WRITE);
			//�õ�INBOX���������Ϣ
			Message[] messages = inbox.getMessages();
			for (int i = 0 ; i < messages.length ; i++)
			{
				System.out.println("----��" + (i + 1) + "���ʼ�����Ϣ---");
				printMessage(messages[i]);
			}

		} 
		catch (Exception e) 
		{
			System.out.println("��ȡ�ʼ���Ϣ����");
			e.printStackTrace();
		}
	}	
	//�õ����յ�����, ���ȷ��ط�������, ��η�����������
	public Date getReceivedDate(Message m)
		throws Exception 
	{
		if (m.getSentDate() != null) 
			return m.getSentDate();
		if (m.getReceivedDate() != null)
			return m.getReceivedDate();
		return new Date();
	}
	//�õ����͵ĵ�ַ
	public List<String> getCC(Message m) 
		throws Exception 
	{
		Address[] addresses = m.getRecipients(
			Message.RecipientType.CC);
		return getAddresses(addresses);
	}
	//�õ��ļ����ĺ�׺
	private String getFileSuffix(String fileName)
	{
		if (fileName == null || fileName.trim().equals(""))
			return "";
		int dotPos = fileName.lastIndexOf(".");
		if (dotPos != -1)
		{
			return fileName.substring(dotPos);
		}
		return "";
	}
	//����ʼ��ĸ���
	public List<FileObject> getFiles(Message m)
		throws Exception 
	{
		List<FileObject> files = new ArrayList<FileObject>();
		//�ǻ������, �ͽ��д���
		if (m.isMimeType("multipart/mixed"))
		{
			Multipart mp = (Multipart)m.getContent();
			//�õ��ʼ����ݵ�Multipart���󲢵õ�������Part������
			int count = mp.getCount();
			for (int i = 1; i < count; i++)
			{
				//��ȡ����
				Part part = mp.getBodyPart(i);
				//��ȡ�ʼ�������
				String serverFileName = MimeUtility
					.decodeText(part.getFileName());
				//����UUID��Ϊ�ڱ���ϵͳ��Ψһ���ļ���ʶ
				String fileName = UUID.randomUUID().toString();
				File file = new File(fileName 
					+ getFileSuffix(serverFileName));
				//��д�ļ�
				FileOutputStream fos = new FileOutputStream(file);
				InputStream is = part.getInputStream();
				BufferedOutputStream outs = new BufferedOutputStream(fos);
				//ʹ��IO����ȡ�ʼ�����
				byte[] b = new byte[1024];
				int hasRead = 0;
				while((hasRead = is.read(b)) > 0)
				{
					outs.write(b , 0 , hasRead);
				}				
				outs.close();
				is.close();
				fos.close();
				//��װ����
				FileObject fileObject = new FileObject(serverFileName, file);
				files.add(fileObject);
			}
		}
		return files;
	}
	//�����ʼ����ĵĹ��߷���
	private StringBuffer getContent(Part part
		, StringBuffer result) throws Exception
	{
		if (part.isMimeType("multipart/*"))
		{
			Multipart p = (Multipart)part.getContent();
			int count = p.getCount();
			//Multipart�ĵ�һ������text/plain, 
			//�ڶ�������text/html�ĸ�ʽ, ֻ������һ���ּ���
			if (count > 1) count = 1; 
			for(int i = 0; i < count; i++) 
			{
				BodyPart bp = p.getBodyPart(i);
				//�ݹ����
				getContent(bp, result);
			}
		} 
		else if (part.isMimeType("text/*"))
		{
			//�����ı���ʽ����html��ʽ, ֱ�ӵõ�����
			result.append(part.getContent());
		}
		return result;
	}
	//�����ʼ���������
	public String getContent(Message m) 
		throws Exception
	{
		StringBuffer sb = new StringBuffer("");
		return getContent(m , sb).toString();
	}
	//�ж�һ���ʼ��Ƿ��Ѷ�, true��ʾ�Ѷ�ȡ, false��ʾû�ж�ȡ
	public boolean hasRead(Message m) 
		throws Exception
	{
		Flags flags = m.getFlags();
		return flags.contains(Flags.Flag.SEEN);
	}
	//�õ�һ���ʼ��������ռ���
	public List<String> getAllRecipients(Message m)
		throws Exception 
	{
		Address[] addresses = m.getAllRecipients();
		return getAddresses(addresses);
	}
	//���߷���, �������ĵ�ַ�ַ�����װ�ɼ���
	public List<String> getAddresses(Address[] addresses)
	{
		List<String> result = new ArrayList<String>();
		if (addresses == null) return result;
		//����Address[]���飬��ÿ��Ԫ��ת��Ϊ�ַ������ռ�����
		for (Address a : addresses)
		{
			result.add(a.toString());
		}
		return result;
	}
	//�õ������˵ĵ�ַ
	public String getSender(Message m) 
		throws Exception 
	{
		Address[] addresses = m.getFrom();
		return MimeUtility.decodeText(addresses[0].toString());
	}
	//��ӡMessage����Ϣ
	public void printMessage(Message m)
		throws Exception
	{
		System.out.println(m.toString());
		System.out.println("�������ڣ�" + getReceivedDate(m));
		System.out.println("���͵�ַ��" + getReceivedDate(m));
		System.out.println("�Ƿ��Ѷ���" + hasRead(m));
		System.out.println("�����ռ��ˣ�" + getAllRecipients(m));
		System.out.println("�����˵�ַ��" + getSender(m));
		System.out.println("==�ʼ�����==\n" + getContent(m));
		System.out.println("������Ϣ" + getFiles(m));

	}
	public static void main(String[] args)
		throws Exception
	{
		ReceiveMail receiveMail = new ReceiveMail();
		receiveMail.setPop3Host("pop3.sina.com");
		receiveMail.setPop3Port(110);
		receiveMail.setAccount("spring_test");
		receiveMail.setPassword("123abc");
		receiveMail.getMessages();
	}
}