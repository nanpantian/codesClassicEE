<%@page contentType="text/html" pageEncoding="GBK"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
	<title>����ǩ</title>
</head>
<body>
<h1>����ǩ</h1>
<h:form>
HtmlSelectManyCheckbox��
<h:selectManyCheckbox value="#{user.name}">
	<f:selectItem itemLabel="���Java����" itemValue="java"/>
	<f:selectItem itemLabel="���Ajax����" itemValue="ajax"/>
	<f:selectItem itemLabel="���XML����" itemValue="xml"/>
</h:selectManyCheckbox>
<br/>
HtmlSelectManyListbox��
<h:selectManyListbox value="#{user.pass}" size="5">
	<f:selectItem itemLabel="���Java����" itemValue="java"/>
	<f:selectItem itemLabel="���Ajax����" itemValue="ajax"/>
	<f:selectItem itemLabel="���XML����" itemValue="xml"/>
</h:selectManyListbox>
<br/>
HtmlSelectManyMenu: 
<h:selectManyMenu value="#{user.grade}" >
	<f:selectItem itemLabel="���Java����" itemValue="1"/>
	<f:selectItem itemLabel="���Ajax����" itemValue="2"/>
	<f:selectItem itemLabel="���XML����" itemValue="3"/>
</h:selectManyMenu>
<br/>
</h:form>
</body>
</html>
</f:view>
