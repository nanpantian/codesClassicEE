package org.crazyit.jsf;


import java.util.*;
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
public class UserBean 
{
	private String name;
	private Son son;

	//�޲����Ĺ�����
	public UserBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public UserBean(String name , Son son)
	{
		this.name = name;
		this.son = son;
	}

	//name���Ե�setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	//son���Ե�setter��getter����
	public void setSon(Son son)
	{
		this.son = son;
	}
	public Son getSon()
	{
		return this.son;
	}

	//��д�������ķ���
	public String add()
	{
		return "success";
	}
}