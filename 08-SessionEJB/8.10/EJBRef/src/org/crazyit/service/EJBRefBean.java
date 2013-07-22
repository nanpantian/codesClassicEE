package org.crazyit.service;

import java.util.*;
import javax.ejb.*;


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
@Stateless(mappedName="EJBRef" , name="EJBRef")
public class EJBRefBean
	implements EJBRef
{
	@EJB(name="ejb3/Hello")
	private Hello hello;
	public String callHello(String name)
	{
		final String prefix = "����Hello EJB�ɹ�������ֵ��";
		String result = hello.hello("yeeku");
		System.out.println(prefix 
			+ result);
		return prefix + result;
	}
}
