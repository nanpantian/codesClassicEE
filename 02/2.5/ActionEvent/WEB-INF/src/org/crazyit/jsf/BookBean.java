package org.crazyit.jsf;

import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ActionEvent;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> 
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
	//绑定UI组件本身的属性

	private HtmlInputText price;



	//无参数的构造器
	public BookBean()
	{
	}
	//初始化全部属性的构造器
	public BookBean(String name , HtmlInputText price)
	{
		this.name = name;
		this.price = price;
	}

	//name属性的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	//price属性的setter和getter方法
	public void setPrice(HtmlInputText price)
	{
		this.price = price;
	}
	public HtmlInputText getPrice()
	{
		return this.price;
	}
	//编写处理Action事件的方法
	public void process(ActionEvent ae)
	{
		if (name.equals("疯狂Java讲义"))
		{
			price.setValue(ae.getComponent());
			price.setSize(60);
			price.setStyle("background-color:#1111ff;"
				+ "font-weight:bold");
		}
	}
}