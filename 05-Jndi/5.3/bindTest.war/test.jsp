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
<%@ page import="javax.naming.*,javax.swing.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> ����JNDI�� </title>
	<meta name="website" content="http://www.crazyit.org" />
</head>
<body>
<%
final String TEST_JNDI = "testName";
//��ʼ��Context��ʹ��InitialContext��ʼ��Context
Context ctx = new InitialContext(); 
//���ⴴ��һ������
JFrame mainWin = new JFrame("���Դ���");
//ִ�а�
ctx.rebind(TEST_JNDI , mainWin);
out.println("<h3>JNDI�󶨳ɹ���</h3>");
%>
</body>
</html>