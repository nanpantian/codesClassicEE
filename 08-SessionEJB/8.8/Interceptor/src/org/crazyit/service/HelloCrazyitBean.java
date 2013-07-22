package org.crazyit.service;

import java.util.*;
import javax.ejb.*;
import javax.annotation.*;

import javax.interceptor.*;

import org.crazyit.interceptor.*;

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
@Stateless(mappedName="HelloCrazyit")
@Interceptors(MyInterceptor.class)
public class HelloCrazyitBean 
	implements HelloCrazyit
{
	public String hello(String name)
	{
		System.out.println(name 
			+ ", ���ã�����ʱ���ǣ�"
			+ new java.util.Date());
		return "crazyit.org";
	}
	public void crazyit()
	{
		System.out.println("���Java����!");
		System.out.println("���ܻ�ӭ��Java��̳!");
	}
	@ExcludeClassInterceptors
	public void exclude()
	{
		System.out.println("���ų�������������֮��ķ���!");
	}
}