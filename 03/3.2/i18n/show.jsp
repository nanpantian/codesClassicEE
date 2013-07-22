<%@page contentType="text/html" pageEncoding="gbk"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<f:view >
    <html>
        <head>
            <title><h:outputText value="#{global.greeting}" /></title>
			<!-- ���ع��ʻ���Դ�ļ������غ��ͨ��local���������� -->
			<f:loadBundle basename="local" var="local"/>
        </head>
        <body>
			<h1><h:outputText value="#{global.greeting}" /></h1>
            <h:outputText value="#{local.name}"/>
			<h:outputText value="#{bookBean.name}" /><br/>
			<h:outputText value="#{local.price}"/>
			<h:outputText value="#{bookBean.price}" /><br/>
			ͼ�����վ�㣺${sessionScope.website}
        </body>
	</html>
</f:view>
