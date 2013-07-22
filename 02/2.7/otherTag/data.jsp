<%@page contentType="text/html" pageEncoding="GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
	<style type="text/css">
		.odd {
			background-color:#ddffdd;
		}
		.even {
			background-color:#aaaaff;
		}
	</style>
	<title>������ǩ</title>
</head>
<body>
<h1>������ǩ</h1>
<h:dataTable width="600px" border="1"
	value="#{viewBook.books}" var="book"
	rowClasses="odd,even"
	first="2" rows="2">
	<!-- ʹ��facet��ǩ����caption -->
	<f:facet name="caption">
		<h:outputText value="ͼ���б�"/>
	</f:facet>
	<!-- �����һ�� -->
	<h:column>
		<f:facet name="header">
			<h:outputText value="ͼ��ID"/>
		</f:facet>
		<h:inputText value="#{book.id}" size="3"/>
	</h:column>
	<!-- ����ڶ��� -->
	<h:column>
		<f:facet name="header">
			<h:outputText value="ͼ������"/>
		</f:facet>
		<h:outputText value="#{book.name}"/>
	</h:column>
	<!-- ��������� -->
	<h:column>
		<f:facet name="header">
			<h:outputText value="����֧��վ��"/>
		</f:facet>
		<h:outputLink value="http://www.#{book.website}">
			<h:outputText value="���Java����"/>
		</h:outputLink>
	</h:column>
	<f:facet name="footer">
		<h:panelGroup>
			<h:outputText value="������5��ͼ��"/>,
			<h:outputText value="�ܼۣ�268.00Ԫ"/>
		</h:panelGroup>
	</f:facet>
</h:dataTable>
</body>
</html>
</f:view>
