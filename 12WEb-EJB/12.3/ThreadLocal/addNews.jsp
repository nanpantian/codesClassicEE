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
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<f:view>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
	<title>�����Ϣ</title>
</head>
<body>
<h3>
<h:outputText value="ͨ��ThreadLocalʹ���̰߳�ȫ��EntityManager"/>
</h3>
<h:form id="loginForm">
	<h:outputText value="��Ϣ����"/>
	<!-- �����浥��������ֵ�󶨵�addNews Bean��name���� -->
	<h:inputText value="#{addNews.title}" /><br/>
	<h:outputText value="��Ϣ����"/>
	<!-- �����浥��������ֵ�󶨵�addNews Bean��pass���� -->
	<h:inputText id="pass" value="#{addNews.content}"/><br/>
	<!-- �����水ť�Ķ����󶨵�addNews Bean��valid���� -->
	<h:commandButton action="#{addNews.add}"
		value="���" />
</h:form>
</body>
</html>
</f:view>