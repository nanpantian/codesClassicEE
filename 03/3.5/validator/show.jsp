<%@page contentType="text/html" pageEncoding="gbk"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<f:view >
<html>
	<head>
		<title>�����ɹ�</title>
	</head>
	<body>
		<h1>�����ɹ�</h1>
		��վ������<h:outputText value="#{registBean.name}"/><br/>
		����ʱ�䣺<h:outputText value="#{registBean.duration}"/>��<br/>
		ÿ��Ͷ�룺<h:outputText value="#{registBean.cost * 1000}"/>Ԫ
	</body>
</html>
</f:view>
