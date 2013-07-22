package lee;

import javax.ejb.*;

import org.crazyit.service.*;

import org.crazyit.util.*;
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

public class LoginBean
{
	//������������Զ���ֱ����JSF��ǩ��
	private String name;
	private String pass;
	private String err;	
	//name���Ե�setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	//pass���Ե�setter��getter����
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}

	//err���Ե�setter��getter����
	public void setErr(String err)
	{
		this.err = err;
	}
	public String getErr()
	{
		return this.err;
	}
	//�÷������󶨵�UI�������ť����action����
	public String valid()
	{
		//ͨ��EJB��������ȡEJB��������EJB�ķ���
		UserService us = (UserService)EJBFactory.lookup("userService");
		//����Session Bean�ķ����������û�����
		if (us.loginPro(name , pass))
		{
			return "success";
		}
		setErr("�����û��������벻����");
		return "failure";
	}
}