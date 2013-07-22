package org.crazyit.auction.jsf;

import java.util.*;
import javax.ejb.*;
import javax.faces.context.FacesContext;

import org.crazyit.auction.service.AuctionManager;
import org.crazyit.auction.exception.AuctionException;
import org.crazyit.auction.model.*;

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
public class ViewBidAction
{
	private List<Bid> bids;
	//����ע��ҵ���߼������Session Bean��
	@EJB(beanName="auctionManager")
	private AuctionManager am;
	//bids���Ե�setter��getter����
	public void setBids(List<Bid> bids)
	{
		this.bids = bids;
	}
	public List<Bid> getBids()
	{
		//��JSF�з���Session��Χ������
		Map<String , Object> session = FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getSessionMap();
		Integer userId = (Integer)session.get("userId");
		//����ҵ���߼�������ʼ��failItems����
		return am.getBidByUser(userId);
	}
}