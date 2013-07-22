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
<!-- �þ������classes�µ�messages�Ĺ��ʻ���Դ�ļ� -->
<f:loadBundle basename="messages" var="msg"/>
<html>
<head>
	<title>�鿴������Ϣ</title>
	<style type="text/css">
		.odd {
			background-color:#ddffdd;
		}
		.even {
			background-color:#aaaaff;
		}
	</style>
</head>
<body>
<h1>��ϲ��������JBoss��JSF+EJB 3+JPA���ϳɹ�</h1>
<h2>������Ϣ</h2>
<h:dataTable width="600px" border="1"
	value="#{viewAll.newsList}" var="news"
	rowClasses="odd,even">
	<!-- ʹ��facet��ǩ����caption -->
	<f:facet name="caption">
		<h:outputText value="��Ϣ�б�"/>
	</f:facet>
	<!-- �����һ�� -->
	<h:column>
		<f:facet name="header">
			<h:outputText value="��ϢID"/>
		</f:facet>
		<h:outputText value="#{news.id}"/>
	</h:column>
	<!-- ����ڶ��� -->
	<h:column>
		<f:facet name="header">
			<h:outputText value="��Ϣ����"/>
		</f:facet>
		<h:outputText value="#{news.title}"/>
	</h:column>
	<!-- ��������� -->
	<h:column>
		<f:facet name="header">
			<h:outputText value="��Ϣ����"/>
		</f:facet>
		<h:outputText value="#{news.content}"/>
	</h:column>
</h:dataTable>
</body>
</html>
</f:view>