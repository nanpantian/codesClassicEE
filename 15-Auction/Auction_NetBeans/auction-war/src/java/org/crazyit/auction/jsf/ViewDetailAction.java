package org.crazyit.auction.jsf;

import java.util.*;
import javax.ejb.*;

import javax.faces.context.*;

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
public class ViewDetailAction
{
	//��װ�û��������������
	private int itemId;
	private Item item;
	//����ע��ҵ���߼������Session Bean��
	@EJB(beanName="auctionManager")
	private AuctionManager am;
	//itemId���Ե�setter��getter����
	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	public int getItemId()
	{
		Map<String , String> request = FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getRequestParameterMap();
		return Integer.parseInt(request.get("itemId"));
	}
	//item���Ե�setter��getter����
	public void setItem(Item item)
	{
		this.item = item;
	}
	public Item getItem()
	{
		return am.getItem(getItemId());
	}
}