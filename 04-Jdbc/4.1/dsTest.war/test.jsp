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
<%@ page import="javax.naming.*,java.sql.*,javax.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title> �����������������Դ </title>
	<meta name="website" content="http://www.crazyit.org" />
</head>
<body>
<%
//��ʼ��Context��ʹ��InitialContext��ʼ��Context
Context ctx = new InitialContext(); 
//JBoss��ʵ��JNDI���ֱ��������õ�JNDI֮ǰ����java:/ǰ׺
DataSource ds = (DataSource)ctx.lookup("java:/firstds");
//��ȡ���ݿ�����
Connection conn = ds.getConnection();
//��ȡStatement
Statement stmt = conn.createStatement();
//ִ�в�ѯ������ResulteSet����
ResultSet rs = stmt.executeQuery("select * from item");
while(rs.next())
{
	out.println(rs.getString(1) + "&nbsp;&nbsp;"
		+ rs.getString(2) + "<br/>");
}
rs.close();
stmt.close();
conn.close();
%>
</body>
</html>