<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="org.crazyit.service.* , org.crazyit.business.*"%>
<%@ page import="javax.naming.*"%>
<%
InitialContext ctx = new InitialContext();
//ͨ��JNDI���һ��EJB
Object stub = ctx.lookup("Hello#.....");
Hello h = (Hello)stub;
out.println(h.hello("you");
%>
