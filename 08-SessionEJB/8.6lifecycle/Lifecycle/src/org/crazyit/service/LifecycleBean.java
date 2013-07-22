package org.crazyit.service;

import java.util.*;
import javax.ejb.*;
import javax.annotation.*;

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
@Stateful(mappedName="Lifecycle")
public class LifecycleBean 
	implements Lifecycle
{
	private Map<String, Integer> buyInfo
		= new HashMap<String, Integer>();
	public LifecycleBean()
	{
		System.out.println("ִ�й���������Beanʵ��!");
	}
	public void addItem(String item)
	{
		//����Ʒ�Ѿ������
		if (buyInfo.containsKey(item))
		{
			//����������1
			buyInfo.put(item , 
				buyInfo.get(item) + 1);
		}
		else
		{
			//��������Ϊ1
			buyInfo.put(item , 1);
		}
	}
	public Map<String, Integer> showDetail()
	{
		return buyInfo;
	}
	//���涨����4���򵥵��������ڷ���
	@Init
	public void init()
	{
		System.out.println("ִ��@Init���εķ���!");
	}
	@PostConstruct
	public void postConstruct()
	{
		System.out.println("ִ��@PostConstruct���εķ���!");
	}
	@PrePassivate
	public void prePassivate()
	{
		System.out.println("ִ��@PrePassivate���εķ���!");
	}
	@PostActivate
	public void postActivate()
	{
		System.out.println("ִ��@PostActivate���εķ���!");
	}
	@PreDestroy
	public void preDestroy()
	{
		System.out.println("ִ��@PreDestroy���εķ���!");
	}
	//@Remove���εķ����ɿͻ�������
	@Remove
	public void remove()
	{
		System.out.println("ִ��@Remove���εķ���!");
	}
}
