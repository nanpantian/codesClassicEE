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
//ָ����EJB���ڲ���ʶ��Ϊhello��
@Stateless(name="hello")
public class HelloBean 
	implements Hello
{
	public String hello(String name)
	{
		return name + "�����á�"
			+ "����ʱ���ǣ�" + new java.util.Date();
	}
}
