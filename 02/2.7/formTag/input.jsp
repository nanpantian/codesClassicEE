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
�����ı���<h:inputText value="#{user.name}"/><br/>
�����<h:inputSecret value="#{user.pass}" /><br/>
�����ı���<h:inputTextarea rows="4" cols="40"/><br/>
������<h:inputHidden value="#{user.grade}" /><br/>
</h:form>
</body>
</html>
</f:view>
