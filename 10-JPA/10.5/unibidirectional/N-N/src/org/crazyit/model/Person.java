package org.crazyit.model;

import javax.persistence.*;
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
@Entity
@Table(name="person_table")
public class Person
{
	//��ʶ����
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int personid;
	//Person��name����
	private String name;
	//����Person��age����
	private int age;
	//N��N������ϵ��ʹ��Set���������ʵ��
	@ManyToMany(cascade=CascadeType.ALL
		, fetch=FetchType.LAZY , targetEntity=Address.class)
	@JoinTable(
		name="person_address",
		joinColumns=@JoinColumn(name="person_id"),
		inverseJoinColumns=@JoinColumn(name="address_id")
	)
	private Set<Address> addresses
		= new HashSet<Address>();
	//�޲����Ĺ�����
	public Person()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public Person(int personid , String name , int age)
	{
		this.personid = personid;
		this.name = name;
		this.age = age;
	}

	//personid���Ե�setter��getter����
	public void setPersonid(int personid)
	{
		this.personid = personid;
	}
	public int getPersonid()
	{
		return this.personid;
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

	//age���Ե�setter��getter����
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}
	//addresses���Ե�setter��getter����
	public void setAddresses(Set<Address> addresses)
	{
		this.addresses = addresses;
	}
	public Set<Address> getAddresses()
	{
		return this.addresses;
	}
}