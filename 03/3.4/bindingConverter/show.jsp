<%@page contentType="text/html" pageEncoding="gbk"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<f:view >
<html>
	<head>
		<title>��ӳɹ�</title>
	</head>
	<body>
		<h1>��ӳɹ�</h1>
		������<h:outputText value="#{userBean.name}"/><br/>
		���ӣ�<h:outputText value="#{userBean.son}">
		</h:outputText>
	</body>
</html>
</f:view>
