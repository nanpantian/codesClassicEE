package lee;

import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
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
public class SendMail
{
	//�ռ��������ַ
	private String to; 
	//�����������ַ
	private String from; 
	//SMTP��������ַ
	private String smtpServer; 
	//��¼SMTP���������û�����
	private String username ;
	//��¼SMTP������������
	private String password ;
	//�ʼ�����
	private String subject; 
	//�ʼ�����
	private String content; 
	//��¼���и����ļ��ļ���
	List<String> attachments 
		= new ArrayList<String>();
	//�޲����Ĺ�����
	public SendMail()
	{
	}
	/**
	 * ��ʼ�������ԵĹ�����
	 * @param to ָ���ռ��˵�ַ.
	 * @param from ָ�������˵�ַ.
	 * @param stmpServer ָ��SMTP��������ַ
	 * @param username ָ����¼SMTP���������û���
	 * @param password ָ����¼SMTP������������
	 * @param subject �ʼ�����
	 * @param content �ʼ�����
	 */
	public SendMail(String to , String from , String smtpServer 
		, String username , String password 
		, String subject , String content)
	{ 
		this.to = to;
		this.from = from;
		this.smtpServer = smtpServer;
		this.username = username;
		this.password = password;
		this.subject = subject;
		this.content = content;
	}
	//to���Ե�setter����
	public void setTo(String to)
	{
		this.to = to;
	}
	//from���Ե�setter����
	public void setFrom(String from)
	{
		this.from = from;
	}
	//smtpServer���Ե�setter����
	public void setSmtpServer(String smtpServer)
	{
		this.smtpServer = smtpServer;
	}
	//username���Ե�setter����
	public void setUsername(String username)
	{
		this.username = username;
	}
	//password���Ե�setter����
	public void setPassword(String password)
	{
		this.password = password;
	}
	//subject���Ե�setter����
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	//content���Ե�setter����
	public void setContent(String content)
	{
		this.content = content;
	}
	//���ʼ�����ת��Ϊ����
	public String transferChinese(String strText)
	{
		try
		{
			strText = MimeUtility.encodeText(
				new String(strText.getBytes()
				, "GB2312"), "GB2312", "B");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return strText;
	}
	//���Ӹ������������ļ�����ӵ�List������
	public void attachfile(String fname)
	{
		attachments.add(fname);
	}
	//�����ʼ�
	public boolean send()
	{
		//�����ʼ�Session�����Properties����
		Properties props = System.getProperties();
		props.put("mail.smtp.host" , smtpServer);
		props.put("mail.smtp.auth" , "true");
		//����Session����
		Session session=Session.getDefaultInstance(props
			//�������ڲ������ʽ������¼����������֤����
			, new Authenticator()
			{
				public PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(username,password); 
				}
			});
		try
		{
			//����MimeMessage ���趨������ֵ
			MimeMessage msg = new MimeMessage(session);
			//���÷�����
			msg.setFrom(new InternetAddress(from));
			//�����ռ���
			InternetAddress[] address={new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO,address);
			//�����ʼ�����
			subject = transferChinese(subject);
			msg.setSubject(subject);	
			//����Multipart
			Multipart mp = new MimeMultipart();
			//��Multipart�������
			MimeBodyPart mbpContent = new MimeBodyPart();
			mbpContent.setText(content);
			//��MimeMessage���
			mp.addBodyPart(mbpContent);
			//��Multipart��Ӹ���
			//���������б��������ļ���ӵ��ʼ���Ϣ��
			for(String efile : attachments)
			{
				MimeBodyPart mbpFile = new MimeBodyPart();
				//���ļ�������FileDataSource����
				FileDataSource fds = new FileDataSource(efile);
				//������
				mbpFile.setDataHandler(new DataHandler(fds));
				mbpFile.setFileName(fds.getName());
				//��MimeMessage���
				mp.addBodyPart(mbpFile);
			}
			//��ո����б�
			attachments.clear();
			//��Multipart���MimeMessage
			msg.setContent(mp);
			//���÷�������
			msg.setSentDate(new Date());
			//�����ʼ�
			Transport.send(msg);  
		}
		catch (MessagingException mex)
		{
			mex.printStackTrace();
			return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		SendMail sendMail = new SendMail();
		sendMail.setSmtpServer("smtp.sina.com");
		//�˴����õ�¼���û���
		sendMail.setUsername("spring_test");
		//�˴����õ�¼������
		sendMail.setPassword("123abc");
		//�����ռ��˵ĵ�ַ
		sendMail.setTo("spring_test@sina.com");
		//���÷����˵�ַ
		sendMail.setFrom("spring_test@sina.com");
		//���ñ���
		sendMail.setSubject("�����ʼ����⣡");
		//��������
		sendMail.setContent("�������һ�����฽���Ĳ����ʼ���"); 
		//ճ������
		sendMail.attachfile("src/lee/SendMail.java");
		sendMail.attachfile("build.xml");
		if (sendMail.send())
		{
			System.out.println("---�ʼ����ͳɹ�---");
		}
	}
}