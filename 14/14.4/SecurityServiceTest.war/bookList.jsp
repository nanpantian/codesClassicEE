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
<%@ page import="javax.naming.*"%>
<%@ page import="org.crazyit.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> ͼ���б� </title>
	<meta name="website" content="http://www.crazyit.org" />
</head>
<body>
<%
Context ctx = new InitialContext();
SecurityService ss = (SecurityService)ctx
	.lookup("SecurityService#org.crazyit.service.SecurityService");
%>
<h3>��ѡ����Ҫ�����ͼ��</h3>
<form action="buy.jsp" method="post">
<%
//����EJB�ķ�������ȡϵͳ�а�������ͼ�顣
for (String book : ss.getAllItem().keySet())
{%>
<%=book%> <input name="book" type="radio" value="<%=book%>"><br/>
<%}%>
<input type="submit" value="����"/>
</form>
<a href="addBook.jsp">���ͼ��</a>
</body>
</html>