package org.crazyit.auction.model;

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
@Table(name="kind")
public class Kind
{
	//��ʶ����
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kind_id")
	private Integer id;
	//������
	@Column(name="kind_name" , length=50
		, nullable=false)
	private String kindName;
	//��������
	@Column(name="kind_desc" , length=255
		, nullable=false)
	private String kindDesc;
	/*�������µ�������Ʒ
	  ������mappedBy���Ա���Kindʵ�岻���ƹ�����ϵ��
	  ��˲�������@JoinTable��@JoinColumn����*/
	@OneToMany(cascade=CascadeType.ALL , mappedBy="kind"
		, targetEntity=Item.class)
	private Set<Item> items = new HashSet<Item>();

	//�޲����Ĺ�����
	public Kind()
	{
	}
	//��ʼ��ȫ���������ԵĹ�����
	public Kind(Integer id , String kindName , String kindDesc)
	{
		this.id = id;
		this.kindName = kindName;
		this.kindDesc = kindDesc;
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

	//kindName���Ե�setter��getter����
	public void setKindName(String kindName)
	{
		this.kindName = kindName;
	}
	public String getKindName()
	{
		return this.kindName;
	}

	//kindDesc���Ե�setter��getter����
	public void setKindDesc(String kindDesc)
	{
		this.kindDesc = kindDesc;
	}
	public String getKindDesc()
	{
		return this.kindDesc;
	}

	//items���Ե�setter��getter����
	public void setItems(Set<Item> items)
	{
		this.items = items;
	}
	public Set<Item> getItems()
	{
		return this.items;
	}

}