package org.crazyit.auction.util;

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
public class SimpleMailSender
{
	//SMTP��������ַ
	private static final String SMTP_SERVER 
		= "smtp.sina.com"; 
	//��¼SMTP���������û�����
	private static final String SMTP_USER 
		= "spring_test";
	//��¼SMTP������������
	private static final String SMTP_PASS 
		= "123abc";
	//�ռ��������ַ
	private String to; 
	//�����������ַ
	private String from; 
	//�ʼ�����
	private String subject; 
	//�ʼ�����
	private String content; 
	//�޲����Ĺ�����
	public SimpleMailSender()
	{
	}
	/**
	 * ��ʼ�������ԵĹ�����
	 * @param to ָ���ռ��˵�ַ.
	 * @param from ָ�������˵�ַ.
	 * @param subject �ʼ�����
	 * @param content �ʼ�����
	 */
	public SimpleMailSender(String to , String from  
		, String subject , String content)
	{ 
		this.to = to;
		this.from = from;
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
	//�����ʼ�
	public boolean send()
	{
		//�����ʼ�Session�����Properties����
		Properties props = new Properties();
		props.put("mail.smtp.host" , SMTP_SERVER);
		props.put("mail.smtp.auth" , "true");
		//����Session����
		Session session = Session.getDefaultInstance(props
			//�������ڲ������ʽ������¼����������֤����
			, new Authenticator()
			{
				public PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(SMTP_USER , SMTP_PASS); 
				}
			});
		try
		{
			//����MimeMessage�������������ֵ
			MimeMessage msg = new MimeMessage(session);
			//���÷�����
			msg.setFrom(new InternetAddress(from));
			//�����ռ���
			InternetAddress[] addresses = {new InternetAddress(to)};
			msg.setRecipients(Message.RecipientType.TO , addresses);
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
}