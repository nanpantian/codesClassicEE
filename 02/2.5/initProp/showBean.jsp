<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2010, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<f:view>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>��ʾ���</title>
	<meta name="website" content="http://www.crazyit.org" />
</head>	
<body>
<h3>��ʾ���</h3>
List���͵�Bean��<h:outputText value="#{trainings}" /><br/>
Map���͵�Bean��<h:outputText value="#{scores}"/><br/>
</body>
</html>
</f:view>
