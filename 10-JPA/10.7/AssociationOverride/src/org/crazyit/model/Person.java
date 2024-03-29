package org.crazyit.model;

import javax.persistence.*;
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
@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public class Person
{
	//标识属性
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//定义该Person实体的名字属性
	private String name;
	//定义该Person实体的性别属性
	private char gender;
	//记录关联实体的属性
	@ManyToOne(fetch=FetchType.EAGER
		,targetEntity=Address.class , cascade=CascadeType.ALL)
	/* 使用@JoinColumn来配置外键列的信息 */
	@JoinColumn(name="address_id", nullable=true)
	private Address address;
	
	//无参数的构造器
	public Person()
	{
	}
	//初始化全部属性的构造器
	public Person(Integer id , String name , char gender)
	{
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	//id属性的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
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

	//gender属性的setter和getter方法
	public void setGender(char gender)
	{
		this.gender = gender;
	}
	public char getGender()
	{
		return this.gender;
	}

	//address属性的setter和getter方法
	public void setAddress(Address address)
	{
		this.address = address;
	}
	public Address getAddress()
	{
		return this.address;
	}
}