<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@ page import="java.util.*,org.crazyit.service.*,javax.naming.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD html 4.0 Transitional//EN">
<html>
<head>
<title>�������Ʒ�б�</title>
</head>
<body>
<%
ShopService ss = (ShopService)session.getAttribute("ss");
if (ss == null)
{
	Context ctx = new InitialContext();
	//ͨ��JNDI����EJB������
	Object stub = ctx.lookup
		("ShopService#org.crazyit.service.ShopService");
	ss = (ShopService)stub;
	session.setAttribute("ss" , ss);
}
//��ȡ�ϸ�ҳ����������
String[] buys = request.getParameterValues("item");
//��������ĸ�Ԫ��
for (String item : buys)
{
	ss.addItem(item);
}
%>
�����������Ʒ��<br/>
<%
//ͨ��EJB��ȡ�������ϸ��Ϣ
Map<String , Integer> buyInfo = ss.showDetail();
//������й�����Ϣ
for(String item : buyInfo.keySet())
{
	out.println(item + "������Ϊ��" 
		+ buyInfo.get(item)	+ "<br />");
}
%>
<hr/>
<a href="shop.jsp">�ٴι���</a>
</body>
</html>
