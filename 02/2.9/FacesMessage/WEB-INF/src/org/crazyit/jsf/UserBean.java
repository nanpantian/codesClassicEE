package org.crazyit.jsf;

import javax.faces.context.*;
import javax.faces.application.*;
import javax.faces.validator.*;
import javax.faces.convert.*;

import javax.faces.*;
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
	private int age;



	//�޲����Ĺ�����
	public UserBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public UserBean(String name , int age)
	{
		this.name = name;
		this.age = age;
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

	//age���Ե�setter��getter����
	public void setAge(int age)
	{
		if (age > 100 || age < 0)
		{
			FacesContext.getCurrentInstance()
				.addMessage("age"
				, new FacesMessage(FacesMessage.SEVERITY_FATAL
				, "���䲻��" , "�������С��100���Ҵ���0��")); 
		}
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}
	//�򵥵Ĵ����߼���ֱ�ӷ��ء�success���ַ���
	public String regist()
	{
		return "success";
	}
}