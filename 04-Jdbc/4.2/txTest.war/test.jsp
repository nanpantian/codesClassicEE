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
<%@ page import="javax.naming.*,java.sql.*,javax.sql.*,javax.transaction.*"%>
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
//ͨ��JNDI���ҵ�һ������Դ
DataSource oracleDs = (DataSource)ctx.lookup("java:/oracle");
//ͨ��JNDI���ҵڶ�������Դ
DataSource otherDs = (DataSource)ctx.lookup("java:/other");
//ͨ��JDNI���һ�ȡJBoss�������ṩ�����������
UserTransaction tx = (UserTransaction)ctx
	.lookup("UserTransaction");
//��ȡ���ݿ�����
Connection oracleConn = oracleDs.getConnection();
Connection otherConn = otherDs.getConnection();
Statement oracleStmt = null;
Statement otherStmt = null;
//��ʼ����
tx.begin();
try 
{
	//��ȡStatement
	oracleStmt = oracleConn.createStatement();
	otherStmt = otherConn.createStatement();
	//���������Բ���ɹ�
	int result = oracleStmt.executeUpdate(
		"insert into dept values(50 , '�з���' , '����')");
	out.println(result == 1 ? "��һ�����ݿ����ɹ�!" : "ʧ��!");
	//������佫ʧ�ܣ���ΪOracle��dept������������Ϊ40�ļ�¼��
	otherStmt.executeUpdate(
		"insert into dept values(40 , '�г���' , '����')");
	//�ύ����
	tx.commit();
}
catch(SQLException ex)
{
	ex.printStackTrace();
	//�ع�����
	tx.rollback();
}
finally
{
	//�ر���Դ
	oracleStmt.close();
	otherStmt.close();
	oracleConn.close();
	otherConn.close();
}
%>
</body>
</html>