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
	@Lob
	private byte[] pic;
	

	//�޲����Ĺ�����
	public Person()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public Person(int id , String name , byte[] pic)
	{
		this.id = id;
		this.name = name;
		this.pic = pic;
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

	//pic���Ե�setter��getter����
	public void setPic(byte[] pic)
	{
		this.pic = pic;
	}
	public byte[] getPic()
	{
		return this.pic;
	}
}