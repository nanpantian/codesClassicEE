<%@page contentType="text/html" pageEncoding="gbk"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
<html>
	<head>
		<title>����û�</title>
	</head>
	<body>
	<h1>����û�</h1>
	<h:form>
	�û�����<h:inputText value="#{userBean.name}" converterMessage="sssss"/><br/>
	���ӣ�<h:inputText value="#{userBean.son}">
	</h:inputText>���밴"��������ߣ�����"�ĸ�ʽ���룩<br/>
	<h:commandButton value="���" action="#{userBean.add}"/>
	</h:form>
	</body>
</html>
</f:view>
