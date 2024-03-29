package org.crazyit.jsf;

import javax.faces.component.html.*;
import javax.faces.event.*;
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
public class RegistBean 
{
	private String name;
	private String pass;
	//绑定UI组件本身的属性

	private HtmlOutputText tip;




	//无参数的构造器
	public RegistBean()
	{
	}
	//初始化全部属性的构造器
	public RegistBean(String name 
		, String pass , HtmlOutputText tip)
	{
		this.name = name;
		this.pass = pass;
		this.tip = tip;
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

	//pass属性的setter和getter方法
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}

	//tip属性的setter和getter方法
	public void setTip(HtmlOutputText tip)
	{
		this.tip = tip;
	}
	public HtmlOutputText getTip()
	{
		return this.tip;
	}
}