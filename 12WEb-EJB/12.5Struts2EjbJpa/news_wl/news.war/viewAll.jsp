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
<!-- ����Struts 2��ǩ�� -->
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
	<title>�鿴������Ϣ</title>
</head>
<body>
<h1><s:text name="succTitle"/></h1>
<h2>������Ϣ</h2>
<table border="1" width="660">
	<tr>
	<th>��ϢID</th>
	<th>��Ϣ����</th>
	<th>��Ϣ����</th>
	</tr
	<!-- �������ValueStack�е�newsList��������status�ǵ�������� -->
	<s:iterator value="newsList" status="index">
	<!-- �ж�����Ƿ�Ϊ���� -->
	<s:if test="#index.odd == true"> 
	<tr style="background-color:#ccffcc">
	</s:if>
	<!-- �жϵ���������Ƿ�Ϊż�� -->
	<s:else> 
	<tr>
	</s:else>
		<td><s:property value="id"/></td>
		<td><s:property value="title"/></td>
		<td><s:property value="content"/></td>
	</tr>
   	</s:iterator>
</table>
</body>
</html>
