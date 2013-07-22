package org.crazyit.jsf;

import javax.faces.convert.*;
import javax.faces.context.*;
import javax.faces.component.*;

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
	private Converter converter;

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

	//converter���Ե�setter��getter����
	public void setConverter(Converter converter)
	{
		this.converter = converter;
	}
	public Converter getConverter()
	{
		//���������ڲ���ʵ��һ��ת����
		return new Converter()
		{
			//ʵ�ִ��ַ���������Ŀ������ת���ķ���
			public Object getAsObject(FacesContext context, 
				UIComponent component, String value)
				throws ConverterException 
			{
				try
				{
					String[] values = value.split(":");
					Son son = new Son(values[0] 
						, Double.parseDouble(values[1]) 
						, Integer.parseInt(values[2]));
					return son;
				}
				//���������Զ����쳣
				catch (Exception ex)
				{
					ex.printStackTrace();
					//�׳�ConverterException�쳣��
					throw new ConverterException("�޷�ת����");
				}
			}
			//ʵ�ִ�Ŀ���������ַ�������ת���ķ���
			public String getAsString(FacesContext context, 
				UIComponent component, Object value)
			{
				Son son = (Son)value;
				return "Son[name=" + son.getName()
					+ ", height=" + son.getHeight()
					+ ", age=" + son.getAge() + "]";
			}
		};
	}

	//��д�������ķ���
	public String add()
	{
		return "success";
	}
}