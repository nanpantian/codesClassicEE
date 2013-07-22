package org.crazyit.auction.model;

import java.util.*;
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
@Table(name="auction_user")
public class AuctionUser
{
	//��ʶ����
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;
	//�û�������
	@Column(name="username" , length=50)
	private String username;
	//��������
	@Column(name="userpass" , length=50)
	private String userpass;
	//�����ʼ�����
	@Column(name="email" , length=100)
	private String email;

	/*����������������Ʒʵ��
	  ������mappedBy���Ա���AuctionUserʵ�岻���ƹ�����ϵ��
	  ��˲�������@JoinTable��@JoinColumn����*/
	@OneToMany(cascade=CascadeType.ALL , mappedBy="owner"
		, targetEntity=Item.class)
	private Set<Item> itemsByOwner = new HashSet<Item>();
	/*����Ӯȡ�߹�������Ʒʵ��
	  ������mappedBy���Ա���AuctionUserʵ�岻���ƹ�����ϵ��
	  ��˲�������@JoinTable��@JoinColumn����*/
	@OneToMany(cascade=CascadeType.ALL , mappedBy="winer"
		, targetEntity=Item.class)
	private Set<Item> itemsByWiner = new HashSet<Item>();
	/*���û��������ȫ������
	  ������mappedBy���Ա���AuctionUserʵ�岻���ƹ�����ϵ��
	  ��˲�������@JoinTable��@JoinColumn����*/
	@OneToMany(cascade=CascadeType.ALL , mappedBy="bidUser"
		, targetEntity=Bid.class)
	private Set<Bid> bids = new HashSet<Bid>();

	//�޲����Ĺ�����
	public AuctionUser()
	{
	}
	//��ʼ��ȫ���������ԵĹ�����
	public AuctionUser(Integer id , String username ,
		String userpass , String email)
	{
		this.id = id;
		this.username = username;
		this.userpass = userpass;
		this.email = email;
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

	//username���Ե�setter��getter����
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return this.username;
	}

	//userpass���Ե�setter��getter����
	public void setUserpass(String userpass)
	{
		this.userpass = userpass;
	}
	public String getUserpass()
	{
		return this.userpass;
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

	//itemsByOwner���Ե�setter��getter����
	public void setItemsByOwner(Set<Item> itemsByOwner)
	{
		this.itemsByOwner = itemsByOwner;
	}
	public Set<Item> getItemsByOwner()
	{
		return this.itemsByOwner;
	}

	//itemsByWiner���Ե�setter��getter����
	public void setItemsByWiner(Set<Item> itemsByWiner)
	{
		this.itemsByWiner = itemsByWiner;
	}
	public Set<Item> getItemsByWiner()
	{
		return this.itemsByWiner;
	}

	//bids���Ե�setter��getter����
	public void setBids(Set<Bid> bids)
	{
		this.bids = bids;
	}
	public Set<Bid> getBids()
	{
		return this.bids;
	}
}