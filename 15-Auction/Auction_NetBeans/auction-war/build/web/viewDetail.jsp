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
<title>��Ʒ��ϸ��Ϣ</title>
</head>
<body>
<table width="780" align="center" cellspacing="0"
	background="images/bodybg.jpg">
<tr>
<td>
<table width="80%" align="center" cellpadding="0" 
	cellspacing="1" style="border:1px solid black">
<tr bgcolor="#e1e1e1" >
	<td colspan="2"><h3>���������Ʒ��ϸ��Ϣ</h3></td> 
</tr>
<tr height="24">
	<td>��Ʒ��</td>
	<td><h:outputText value="#{viewDetail.item.itemName}"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ����</td>
	<td><h:outputText value="#{viewDetail.item.itemDesc}"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ��ע</td>
	<td><h:outputText value="#{viewDetail.item.itemRemark}"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ����</td>
	<td><h:outputText value="#{viewDetail.item.kind.kindName}"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ������</td>
	<td><h:outputText value="#{viewDetail.item.owner.username}"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ���ļ�</td>
	<td><h:outputText value="#{viewDetail.item.initPrice}"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ��߼�</td>
	<td><h:outputText value="#{viewDetail.item.maxPrice}"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ����ʱ��</td>
	<td><h:outputText value="#{viewDetail.item.addtime}"/></td>
</tr>
<tr  height="24">
	<td>��Ʒ����ʱ��</td>
	<td><h:outputText value="#{viewDetail.item.endtime}"/></td>
</tr>
<tr  height="32">
	<td colspan="2">&nbsp;</td>
</tr>
<tr height="24">
	<td colspan="2">
	���������Ȥ�������Ʒ���ۣ�������۸���ύ��<br/>
	��ע�⣬���ļ۸�Ӧ������Ʒ����߼�<br/>
	<h:outputText value="#{addBid.tipInfo}" styleClass="tip"/>
	</td>
</tr>
<tr height="32">
	<td colspan="2">
	<div align="center">
	<h:form>
		<input type="hidden" name="itemId" 
			value="<h:outputText value='#{viewDetail.item.id}'/>"/>
		<input type="hidden" name="maxPrice" 
			value="<h:outputText value='#{viewDetail.item.maxPrice}'/>"/>
		���ļۣ�<h:inputText value="#{addBid.bidPrice}"/><br/>
		��֤�룺<h:inputText value="#{addBid.vercode}"/><br/>
		<h:commandButton value="����" action="#{addBid.bidPro}"/>
	</h:form>
	��֤�룺<img id="d" src="authImg.jpg">
	</div>
	</td>
</tr>
</table>
</body>
</html>
</f:view>