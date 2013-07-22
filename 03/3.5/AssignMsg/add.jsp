<%@page contentType="text/html" pageEncoding="gbk"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<f:view>
<html>
	<head>
		<title>��ӱ���</title>
	</head>
	<body>
	<h1>��ӱ���</h1>
	<h:form prependId="false">
	��վ������<h:inputText value="#{registBean.name}"
		id="name" validatorMessage="�������ȱ�����5��25֮��">
		<f:validateLength minimum="5" maximum="25"/>
	</h:inputText>
	<h:message for="name" style="color:red"/><br/>
	����ʱ�䣨�꣩��<h:inputText value="#{registBean.duration}"
		id="duration" validatorMessage="����ʱ�������0��30��֮��">
		<f:validateLongRange minimum="0" maximum="30"/>
	</h:inputText>
	<h:message for="duration" style="color:red"/><br/>
	Ͷ����ã�ǧԪ/�꣩��<h:inputText value="#{registBean.cost}"
		id="cost" validatorMessage="ÿ��Ͷ����ñ�����0��20ǧԪ֮��">
		<f:validateDoubleRange minimum="0" maximum="20"/>
	</h:inputText>
	<h:message for="cost" style="color:red"/><br/>
	<h:commandButton value="��ӱ���" action="#{registBean.add}"/>
	</h:form>
	</body>
</html>
</f:view>
