package org.crazyit.jsf;

import javax.faces.component.html.HtmlInputText;
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
public class BookBean 
{
	private String name;
	//��UI������������

	private HtmlInputText price;



	//�޲����Ĺ�����
	public BookBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public BookBean(String name , HtmlInputText price)
	{
		this.name = name;
		this.price = price;
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

	//price���Ե�setter��getter����
	public void setPrice(HtmlInputText price)
	{
		this.price = price;
	}
	public HtmlInputText getPrice()
	{
		return this.price;
	}
	//��д�������ķ���
	public String process()
	{
		if (name.equals("���Java����"))
		{
			price.setValue("99.00Ԫ");
			price.setStyle("background-color:#11ff11");
		}
		return null;
	}
}