<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2010, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="login.jsp"%>
<%@ page import="javax.naming.*"%>
<%@ page import="org.crazyit.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> �Ѿ������ͼ�� </title>
	<meta name="website" content="http://www.crazyit.org" />
</head>
<body>
<%
request.setCharacterEncoding("GBK");
String book = request.getParameter("book");
Context ctx = new InitialContext();
SecurityService ss = (SecurityService)ctx
	.lookup("SecurityService#org.crazyit.service.SecurityService");
//����EJB�ķ��������ø÷�������ӵ��customer��admin��ɫ��
double price = ss.buyItem(book);
%>
<h3>���Ѿ������ͼ����:<%=book%></h3>
����ļ۸��ǣ�<%=price%>
</body>
</html>