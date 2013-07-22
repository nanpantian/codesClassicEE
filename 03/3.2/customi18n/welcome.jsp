<%@page contentType="text/html" pageEncoding="gbk"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<f:view locale="#{localeBean.locale}">
<html>
	<head>
		<title>JSP Page</title>
	</head>
	<body>
	<!-- ���ع��ʻ���Դ�ļ������غ��ͨ��local���������� -->
	<f:loadBundle basename="local" var="local"/>
	<h:form>
		<!-- ͨ�������˵���ѡ������/���һ��� -->
		<h:selectOneMenu value="#{localeBean.locale}"
			valueChangeListener="#{localeBean.choose}"
			onchange="this.form.submit();"
			immediate="true"> 
			<f:selectItem itemValue="en_US" 
				itemLabel="#{global.en_USText}"/> 
			<f:selectItem itemValue="zh_CN" 
				itemLabel="#{global.zh_CNText}"/> 
		</h:selectOneMenu>
	</h:form>
	<!-- ʹ��ȫ����Դ�ļ��е���Ϣ -->
	<h1><h:outputText value="#{global.title}"/></h1>
	<b>${sessionScope.tip}</b>
	<h:form>
	<!-- ʹ�þֲ���Դ�ļ��е���Ϣ -->
	<h:outputText value="#{local.name}"/>
	<h:inputText value="#{bookBean.name}"/><br/>
	<!-- ʹ�þֲ���Դ�ļ��е���Ϣ -->
	<h:outputText value="#{local.price}"/>
	<h:inputText value="#{bookBean.price}"/><br/>
	<h:commandButton value="#{local.process}" action="#{bookBean.process}"/><br/>
	</h:form>
	</body>
</html>
</f:view>