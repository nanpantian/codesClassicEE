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
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<f:view>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>�������ĵ���Ʒ</title>
</head>
<body>
<table width="780" align="center" cellspacing="0"
	background="images/bodybg.jpg">
<tr>
<td>
<div align="center">
<h3>ϵͳ�������ĵ���Ʒ</h3>
<h:dataTable width="80%" border="1" 
	cellpadding="0"
	cellspacing="1"
	style="border:1px solid black"
	value="#{viewFail.failItems}" var="item"
	rowClasses="odd,even">
	<!-- �����һ�� -->
	<h:column>
		<f:facet name="header">
			<h:outputText value="��Ʒ��"/>
		</f:facet>
		<h:outputText value="#{item.itemName}"/>
	</h:column>
	<!-- ����ڶ��� -->
	<h:column>
		<f:facet name="header">
			<h:outputText value="��Ʒ����"/>
		</f:facet>
		<h:outputText value="#{item.kind.kindName}"/>
	</h:column>
	<!-- ��������� -->
	<h:column>
		<f:facet name="header">
			<h:outputText value="��߾���"/>
		</f:facet>
		<h:outputText value="#{item.maxPrice}"/>
	</h:column>
	<!-- ��������� -->
	<h:column>
		<f:facet name="header">
			<h:outputText value="��Ʒ��ע"/>
		</f:facet>
		<h:outputText value="#{item.itemRemark}"/>
	</h:column>
</h:dataTable>
</div>
</td>
</tr>
</table>
</body>
</html>
</f:view>