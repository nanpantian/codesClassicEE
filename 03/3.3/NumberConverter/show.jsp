<%@page contentType="text/html" pageEncoding="gbk"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<f:view >
<html>
	<head>
		<title>�鿴ͼ��</title>
	</head>
	<body>
		<h1>�鿴ͼ��</h1>
		<h:outputText value="#{bookBean.name}"/><br/>
		<h:outputText value="#{bookBean.price}">
			<!-- ת������������ʱ�佫ֻ�������ڲ��� -->
			<f:convertNumber pattern="��0000.00"/>
		</h:outputText>
	</body>
</html>
</f:view>
