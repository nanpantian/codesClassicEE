package org.crazyit.jsf;

import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ActionEvent;
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
	//��UI�������������

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
	//��д����Action�¼��ķ���
	public void process(ActionEvent ae)
	{
		if (name.equals("���Java����"))
		{
			price.setValue(ae.getComponent());
			price.setSize(60);
			price.setStyle("background-color:#1111ff;"
				+ "font-weight:bold");
		}
	}
}