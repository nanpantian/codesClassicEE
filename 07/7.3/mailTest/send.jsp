<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2010, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ page import="javax.naming.*,javax.mail.*,javax.mail.internet.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> ���ͳɹ� </title>
	<meta name="website" content="http://www.crazyit.org" />
</head>
<body>
<%
final String TEST_JNDI = "testMail";
final String SEND_PROTOCOL = "smtp";
final String MAIL_SERVER = "smtp.sina.com";
final int MAIL_PORT = 25;
//��ʼ��Context��ʹ��InitialContext��ʼ��Context
Context ctx = new InitialContext(); 
Session sess = (Session)ctx.lookup(TEST_JNDI);
//Properties props = new Properties();
//Session sess = Session.getDefaultInstance(props);
//��ȡsmtp��Ӧ��Transport����
Transport transport = sess.getTransport(SEND_PROTOCOL);
transport.connect(MAIL_SERVER , MAIL_PORT 
	, "spring_test" , "123abc");
request.setCharacterEncoding("GBK");
//��ȡ�ʼ����ռ��ˡ����⡢����
String receiver = request.getParameter("receiver");
String title = request.getParameter("title");
String content = request.getParameter("content");
//����MimeMessage�������������ֵ
MimeMessage msg = new MimeMessage(sess);
//���÷�����
msg.setFrom(new InternetAddress("spring_test@sina.com"));
//�����ռ���
InternetAddress[] addresses = {new InternetAddress(receiver)};
msg.setRecipients(Message.RecipientType.TO , addresses);
//�����ʼ�����
msg.setSubject(title);    
//����Multipart
Multipart mp = new MimeMultipart();
//��Multipart�������
MimeBodyPart mbpContent = new MimeBodyPart();
mbpContent.setText(content);
mp.addBodyPart(mbpContent);
//��Multipart���MimeMessage
msg.setContent(mp);
//���÷�������
msg.setSentDate(new java.util.Date());
//�����ʼ�
transport.sendMessage(msg, msg.getAllRecipients());
out.println("<h3>�ʼ����ͳɹ�</h3>");
%>
</body>
</html>