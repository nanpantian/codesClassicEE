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
@Table(name="person_table")
/* ָ���ڶ�����ı���Ϊperson_detail*/
@SecondaryTable(name="person_detail"
	, pkJoinColumns=@PrimaryKeyJoinColumn(name="person_id"))
public class Person
{
	//ʵ����ı�ʶ����
	@Id /* �������α�ʶ���� */
	/* ָ���������е��������ɲ��� */
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/* @Columnָ����Fieldӳ�������Ϣ���˴�ָ�������������� */
	@Column(name="person_name" , length=50)
	private String name;
	/* ָ�������з��������ݱ�person_detail���� */
	@Column(table="person_detail", name="email")
	private String email;
	/* ָ�������з��������ݱ�person_detail���� */
	@Column(table="person_detail", name="phone")
	private String phone;
	//�޲����Ĺ�����
	public Person()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public Person(int id , String name 
		, String email , String phone)
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	//id���Ե�setter��getter����
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
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

	//email���Ե�setter��getter����
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}

	//phone���Ե�setter��getter����
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getPhone()
	{
		return this.phone;
	}

}