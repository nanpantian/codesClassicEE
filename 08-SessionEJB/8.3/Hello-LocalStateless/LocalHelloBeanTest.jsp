<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="org.crazyit.service.* , org.crazyit.business.*"%>
<%@ page import="javax.naming.*"%>
<%
InitialContext ctx = new InitialContext();
//通过JNDI查找获得EJB
Object stub = ctx.lookup("Hello#.....");
Hello h = (Hello)stub;
out.println(h.hello("you");
%>
