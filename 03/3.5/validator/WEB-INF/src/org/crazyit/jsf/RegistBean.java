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
public class RegistBean 
{
	private String name;
	private int duration;
	private double cost;

	//�޲����Ĺ�����
	public RegistBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public RegistBean(String name , int duration , double cost)
	{
		this.name = name;
		this.duration = duration;
		this.cost = cost;
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

	//duration���Ե�setter��getter����
	public void setDuration(int duration)
	{
		this.duration = duration;
	}
	public int getDuration()
	{
		return this.duration;
	}

	//cost���Ե�setter��getter����
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	public double getCost()
	{
		return this.cost;
	}

	//��д�������ķ���
	public String add()
	{
		return "success";
	}
}