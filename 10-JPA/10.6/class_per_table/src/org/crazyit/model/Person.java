package org.crazyit.model;

import javax.persistence.*;
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
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="person_table")
public class Person
{
	//��ʶ����
	@Id
	private Integer id;
	//�����Personʵ�����������
	private String name;
	//�����Personʵ����Ա�����
	private char gender;
	//�����Personʵ���������ԣ�address
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="detail",
		column=@Column(name="address_detail")),
		@AttributeOverride(name="zip",
		column=@Column(name="address_zip")),
		@AttributeOverride(name="country",
		column=@Column(name="address_country"))
	})
	private Address address;
	//�޲����Ĺ�����
	public Person()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public Person(Integer id , String name , char gender)
	{
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	//id���Ե�setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
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

	//gender���Ե�setter��getter����
	public void setGender(char gender)
	{
		this.gender = gender;
	}
	public char getGender()
	{
		return this.gender;
	}

	//address���Ե�setter��getter����
	public void setAddress(Address address)
	{
		this.address = address;
	}
	public Address getAddress()
	{
		return this.address;
	}
}