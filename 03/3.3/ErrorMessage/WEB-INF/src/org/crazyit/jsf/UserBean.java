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
	private Date birthday;

	//�޲����Ĺ�����
	public UserBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public UserBean(String name , Date birthday)
	{
		this.name = name;
		this.birthday = birthday;
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

	//birthday���Ե�setter��getter����
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	public Date getBirthday()
	{
		return this.birthday;
	}

	//��д�������ķ���
	public String add()
	{
		System.out.println(getBirthday());
		return "success";
	}

}