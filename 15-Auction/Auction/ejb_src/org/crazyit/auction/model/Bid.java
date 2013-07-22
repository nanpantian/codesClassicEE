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
@Table(name="bid")
public class Bid
{
	//��ʶ����
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bid_id")
	private Integer id;
	//���۵ļ۸�
	@Column(name="bid_price"
		, nullable=false)
	private double bidPrice;
	//���۵�����
	@Column(name="bid_date"
		, nullable=false)
	@Temporal(TemporalType.DATE)
	private Date bidDate;
	//���ξ��������ĵ���Ʒ
	@ManyToOne(fetch=FetchType.EAGER
		,targetEntity=Item.class , cascade=CascadeType.ALL)
	/* ʹ��@JoinColumn����������е���Ϣ */
	@JoinColumn(name="item_id", nullable=false)
	private Item bidItem;
	//���뾺�۵��û�
	@ManyToOne(fetch=FetchType.EAGER
		,targetEntity=AuctionUser.class , cascade=CascadeType.ALL)
	/* ʹ��@JoinColumn����������е���Ϣ */
	@JoinColumn(name="user_id", nullable=false)
	private AuctionUser bidUser;


	//�޲����Ĺ�����
	public Bid()
	{
	}
	//��ʼ��ȫ���������ԵĹ�����
	public Bid(Integer id , double bidPrice , Date bidDate)
	{
		this.id = id;
		this.bidPrice = bidPrice;
		this.bidDate = bidDate;
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

	//bidPrice���Ե�setter��getter����
	public void setBidPrice(double bidPrice)
	{
		this.bidPrice = bidPrice;
	}
	public double getBidPrice()
	{
		return this.bidPrice;
	}

	//bidDate���Ե�setter��getter����
	public void setBidDate(Date bidDate)
	{
		this.bidDate = bidDate;
	}
	public Date getBidDate()
	{
		return this.bidDate;
	}

	//bidItem���Ե�setter��getter����
	public void setBidItem(Item bidItem)
	{
		this.bidItem = bidItem;
	}
	public Item getBidItem()
	{
		return this.bidItem;
	}

	//bidUser���Ե�setter��getter����
	public void setBidUser(AuctionUser bidUser)
	{
		this.bidUser = bidUser;
	}
	public AuctionUser getBidUser()
	{
		return this.bidUser;
	}

	public int hashCode()
	{
		return bidUser.getUsername().hashCode()
			+ bidItem.hashCode() * 13 + (int)bidPrice * 19;
	}

	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj != null && obj.getClass() == Bid.class)
		{
			Bid bid = (Bid)obj;
			if (bid.getBidUser().getUsername().equals(bidUser.getUsername())
				&& bid.getBidItem().equals(this.getBidItem()) 
				&& bid.getBidPrice() == this.getBidPrice())
			{
				return true;
			}
		}
		return false;
	}
}