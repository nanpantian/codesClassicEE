package org.crazyit.auction.eao.impl;

import java.util.*;

import javax.ejb.*;

import org.crazyit.auction.model.*;
import org.crazyit.auction.eao.*;

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
@Stateless(name="bidEao")
public class BidEaoImpl
	extends CrazyItEao implements BidEao  
{

	/**
	 * �����û����Ҿ���
	 * @param id �û�id
	 * @return �û���Ӧ��ȫ��
	 * @return �û���Ӧ��ȫ������
	 */
	public List<Bid> findByUser(Integer userId)
	{
		return getResultList(Bid.class 
			, "where o.bidUser.id = ?1"
			, null
			, userId);
	}
	/**
	 * ������Ʒid���Լ����۲�ѯ�û�
	 * @param itemId ��Ʒid;
	 * @param price ���۵ļ۸�
	 * @return ��ָ����Ʒ��ָ�����۶�Ӧ���û�
	 */
	public AuctionUser findUserByItemAndPrice(Integer itemId , Double price)
	{
		List<Bid> bidList = getResultList(Bid.class 
			, "where o.bidItem.id = ?1 and o.bidPrice = ?2"
			, null
			, itemId , price);
		//���ز�ѯ�õ��ĵ�һ��Bid���������AuctionUser����
		if (bidList!= null && bidList.size() >= 1)
		{
			return bidList.get(0).getBidUser();
		}
		return null;
	}
}