package org.crazyit.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> 
 * <br/>Copyright (C), 2001-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class EJBFactory 
{
	public static Object lookup(String ejbRefName)
	{
		try 
		{
			//����ִ��JNDI���ҵ�Context
			InitialContext ctx = new InitialContext();
			//����EJB����ִ��JNDI����
			return ctx.lookup("java:comp/env/"+ ejbRefName);
		} 
		catch (NamingException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
