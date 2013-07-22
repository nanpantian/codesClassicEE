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
	<title>�����Լ���������Ʒ</title>
</head>
<body>
<table width="780" align="center" cellspacing="0"
	background="images/bodybg.jpg">
<tr>
<td>
<div align="center">
<h3>����ǰ��������Ʒ��</h3>
<h:dataTable width="80%" border="1" 
	cellpadding="0"
	cellspacing="1"
	style="border:1px solid black"
	value="#{mgrItem.items}" var="item"
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
<tr>
<td>
<h3>�������Ʒ</h3>
<div align="center">
<h:outputText value="#{addItem.tipInfo}" styleClass="tip"/>
<h:form>
<table width="50%">
<tr>
	<td>��&nbsp;Ʒ&nbsp;����</td>
	<td><h:inputText id="name" value="#{addItem.name}"
		required="true"
		requiredMessage="��Ʒ��������д��"
		validatorMessage="��Ʒ�����ȱ�����2��20֮��">
		<f:validateLength minimum="2" maximum="20"/>
		</h:inputText></td>
	<td><h:message for="name" style="color:red"/></td>	
</tr>
<tr>
	<td>��Ʒ������</td>
	<td><h:inputText id="desc" value="#{addItem.desc}">
		</h:inputText></td>
	<td>&nbsp;</td>	
</tr>
<tr>
	<td>��Ʒ��ע��</td>
	<td><h:inputText id="remark" value="#{addItem.remark}">
		</h:inputText></td>
	<td>&nbsp;</td>	
</tr>
<tr>
<td>���ļ۸�</td>
	<td><h:inputText id="initPrice" value="#{addItem.initPrice}"
		required="true"
		requiredMessage="��Ʒ�����ļ۸������д��"
		converterMessage="����������ļ۸���Ч��">
		</h:inputText></td>
	<td><h:message for="initPrice" style="color:red"/></td>
</tr>
<tr>
	<td>��Чʱ�䣺</td>
	<td><h:selectOneMenu value="#{addItem.avail}">
		<f:selectItem itemLabel="һ��" itemValue="1"/>
		<f:selectItem itemLabel="����" itemValue="2"/>
		<f:selectItem itemLabel="����" itemValue="3"/>
		<f:selectItem itemLabel="����" itemValue="4"/>
		<f:selectItem itemLabel="����" itemValue="5"/>
		<f:selectItem itemLabel="һ������" itemValue="6"/>
		<f:selectItem itemLabel="һ����" itemValue="7"/>
		<f:selectItem itemLabel="һ��" itemValue="8"/>
	</h:selectOneMenu></td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td>��Ʒ���ࣺ</td>
	<td><h:selectOneMenu value="#{addItem.kind}" >
		<f:selectItems value="#{mgrItem.kinds}"/>
	</h:selectOneMenu></td>
	<td>&nbsp;</td>
</tr>
<tr>
	<td>��֤�룺</td>
	<td><h:inputText id="vercode" value="#{addItem.vercode}"
	required="true"
	requiredMessage="��֤�������д��"
	validatorMessage="��֤�볤�ȱ������6">
	<f:validateLength minimum="6" maximum="6"/>
	</h:inputText></td>
	<td><h:message for="vercode" style="color:red"/></td>
</tr>
<tr>
<td colspan="3">
<h:commandButton value="���" action="#{addItem.proAdd}"/></td>
</tr>
</table>
</h:form>
��֤�룺<img id="d" src="authImg.jpg">
</div>
</td>
</tr>
</table>
</body>
</html>
</f:view>