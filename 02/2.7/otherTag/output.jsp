<%@page contentType="text/html" pageEncoding="GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
	<title>������ǩ</title>
</head>
<body>
<h1>������ǩ</h1>
������ʻ���Դ��<h:outputText value="#{mess.name}"/><br/>
���Bean���ԣ�<h:outputText value="#{user.name}" /><br/>
����label��ǩ��<h:outputLabel value="#{user.name}" /><br/>
������ͨ�������ӣ�<h:outputLink value="http://www.crazyit.org">
��������</h:outputLink><br/>
������ͨ�������ӣ�<h:outputLink value="http://www.crazyit.org">
<img src="http://www.crazyit.org/logo.jpg"></h:outputLink><br/>
�����ռλ���Ĺ��ʻ���Ϣ��<h:outputFormat value="#{mess.hello}">
<f:param value="�����"/>
<f:param value="www.crazyit.org"/>
</h:outputFormat>
</body>
</html>
</f:view>
