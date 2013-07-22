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
public class ViewItemAction
{
	private int kindId;
	private String kind;
	private List<Item> items;
	//����ע��ҵ���߼������Session Bean��
	@EJB(beanName="auctionManager")
	private AuctionManager am;
	//kindId���Ե�setter��getter����
	public void setKindId(int kindId)
	{
		this.kindId = kindId;
	}
	public int getKindId()
	{
		Map<String , String> request = FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getRequestParameterMap();
		return Integer.parseInt(request.get("kindId"));
	}
	//kind���Ե�setter��getter����
	public void setKind(String kind)
	{
		this.kind = kind;
	}
	public String getKind()
	{
		return am.getKind(getKindId());
	}
	//items���Ե�setter��getter����
	public void setItems(List<Item> items)
	{
		this.items = items;
	}
	public List<Item> getItems()
	{
		return am.getItemsByKind(getKindId());
	}
}