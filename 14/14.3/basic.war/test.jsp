<%@page contentType="text/html;charset=GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
	<title>JAAS����ҳ��</title>
</head>
<body>
	<h1>JAAS����ҳ��</h1>
	<div style="font-wight:bold">
		HttpServletRequest���ṩ�����·�����JAAS��أ�
		<ul>
			<li>getRemoteUser() </li>
			<li>getUserPrincipal()</li>
			<li>isUserInRole(String role) </li>
		</ul>
	</div>
	<p><%=request.getRemoteUser()%>,��ӭ��</p>
	<p>��������ǣ�<%=request.getUserPrincipal()%></p>
	<p>���Ƿ�Ϊcrazyit��ɫ��<%=request.isUserInRole("crazyit")%></p>
</body>
</html>
