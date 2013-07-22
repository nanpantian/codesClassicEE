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
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- �þ������classes�µ�messages�Ĺ��ʻ���Դ�ļ� -->
<f:loadBundle basename="messages" var="msg"/>
<html>
<head>
	<title>�������Ϣ</title>
</head>
<body>
<f:view>
<h3>
<!-- ������ʻ���Դ�ļ��еĹ��ʻ���Ϣ -->
<h:outputText value="#{msg.loginHeader}"/>
</h3>
<h:form id="loginForm">
	<!-- ������ʻ���Դ�ļ��еĹ��ʻ���Ϣ -->
	<h:outputText value="#{msg.namePrompt}"/>
	<!-- �����浥��������ֵ�󶨵�addNews Bean��name���� -->
	<h:inputText value="#{addNews.title}" /><br/>
	<!-- ������ʻ���Դ�ļ��еĹ��ʻ���Ϣ -->
	<h:outputText value="#{msg.contentPrompt}"/>
	<!-- �����浥��������ֵ�󶨵�addNews Bean��pass���� -->
	<h:inputText id="pass" value="#{addNews.content}"/><br/>
	<!-- �����水ť�Ķ����󶨵�addNews Bean��addNews���� -->
	<h:commandButton action="#{addNews.addNews}"
		value="#{msg.buttonTitle}" />
</h:form>
</f:view>
</body>
</html>
