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
<h:panelGrid columns="3" width="500px" border="1">
	<!-- ʹ��facet��ǩ����caption -->
	<f:facet name="caption">
		<h:outputText value="������"/>
	</f:facet>
	<!-- ָ�����ɱ��ͷ -->
	<f:facet name="header">
		<h:outputText value="���ͷ"/>
	</f:facet>
	<h:outputText value="��1����Ԫ��"/>
	<h:outputText value="��2����Ԫ��"/>
	<h:outputText value="��3����Ԫ��"/>
	<h:outputText value="��4����Ԫ��"/>
	<h:outputText value="��5����Ԫ��"/>
	<h:outputText value="��6����Ԫ��"/>
	<h:outputText value="��7����Ԫ��"/>
	<!-- ���������Ԫ����ϳ�һ��Ԫ�� -->
	<h:panelGroup layout="block"
		style="background-color:#dddddd">
	<h:outputText value="��8����Ԫ��"/>
	<h:outputText value="��9����Ԫ��"/>
	</h:panelGroup>
	<h:outputText value="��10����Ԫ��"/>
</h:panelGrid>
<!-- ������Ԫ����ϳ�һ��Ԫ�� -->
<h:panelGroup layout="block" 
	style="background-color:#dddddd">
	<h:inputText/>
	<h:inputText/>
</h:panelGroup>
</body>
</html>
</f:view>
