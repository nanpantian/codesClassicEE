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
	private String email;
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
	@PrePersist
	public void prePersist()
	{
		System.out.println("--����֮ǰ--");
		//�򵥼���
		this.setEmail(reverse(this.getEmail()));
	}
	@PreUpdate
	public void preUpdate()
	{
		System.out.println("--����֮ǰ--");
		//�򵥼���
		this.setEmail(reverse(this.getEmail()));
	}
	@PostUpdate
	public void postUpdate()
	{
		System.out.println("--����֮��--");
	}
	@PostLoad
	public void postLoad()
	{
		System.out.println("--����֮��--");
		//�򵥵ػָ�
		this.setEmail(reverse(this.getEmail()));
	}
	//�ṩһ���������ڶ��ַ������з�ת
	private String reverse(String raw)
	{
		StringBuffer sb = new StringBuffer(raw);
		return sb.reverse().toString();
	}
}