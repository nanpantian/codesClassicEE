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
<head>
	<title>�����Ϣ�ɹ�</title>
</head>    
<body>
<f:view>
	 <h3><h:outputText value="��ӳɹ�"/></h3>
	 ��ӵ���Ϣ����: <h:outputText value="#{addNews.title}" /><br/>
	 ��ӵ���Ϣ����: <h:outputText value="#{addNews.content}" /><br/>
</f:view>
</body>
</html> 