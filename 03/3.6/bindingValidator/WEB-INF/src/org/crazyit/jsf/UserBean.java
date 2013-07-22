package org.crazyit.jsf;


import java.util.*;
import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.application.*;
import javax.faces.validator.*;
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
	private String email;
	//����󶨵��й�Bean���Ե�У����
	private Validator validator;
	//�޲����Ĺ�����
	public UserBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public UserBean(String name , String email)
	{
		this.name = name;
		this.email = email;
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

	//email���Ե�setter��getter����
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}

	//validaor���Ե�setter��getter����
	public void setValidator(Validator validaor)
	{
		this.validator = validator;
	}
	public Validator getValidator()
	{
		//�������ڲ������ʽ����һ��Validator����
		return new Validator()
		{
			//����һ������У��ķ���
			public void validate(FacesContext context,
				UIComponent component, Object toValidate) 
			{
				if (context == null || component == null)
				{
					throw new NullPointerException();
				}
				//����ֻ���������������
				if (!(component instanceof UIInput))
				{
					return;
				}
				//Ҫ����֤��ֵ�������
				if (null == toValidate) 
				{
					return;
				}
				//�����У���ֵ��ƥ��������ʽ
				if (!toValidate.toString().matches(
					"\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"))
				{
					throw new ValidatorException(
						new FacesMessage("EmailУ��ʧ��"));
				}
			}
		};
	}
	//��д�������ķ���
	public String add()
	{
		return "success";
	}
}