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
@Table(name="address_table")
public class Address
{
	//��ʶ����
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="addressid")
	private int addressid;
	//��ַ��ϸ��Ϣ
	@Column(name="detail")
	private String detail;
	@ManyToOne(fetch=FetchType.EAGER
		,targetEntity=Person.class , cascade=CascadeType.ALL)
	/* ʹ��@JoinColumn����������е���Ϣ */
	@JoinColumn(name="person_id", nullable=true)
	private Person person;
	//�޲����Ĺ�����
	public Address()
	{
	}
	//��ʼ��detail���ԵĹ�����
	public Address(String detail)
	{
		this.detail = detail;
	}
	//addressid���Ե�setter��getter����
	public void setAddressid(int addressid)
	{
		this.addressid = addressid;
	}
	public int getAddressid()
	{
		return this.addressid;
	}

	//detail���Ե�setter��getter����
	public void setDetail(String detail)
	{
		this.detail = detail;
	}
	public String getDetail()
	{
		return this.detail;
	}

	//person���Ե�setter��getter����
	public void setPerson(Person person)
	{
		this.person = person;
	}
	public Person getPerson()
	{
		return this.person;
	}

}