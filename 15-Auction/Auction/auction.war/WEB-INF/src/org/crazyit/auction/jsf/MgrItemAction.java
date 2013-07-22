package org.crazyit.auction.jsf;

import java.util.*;
import javax.ejb.*;
import javax.faces.context.FacesContext;
import javax.faces.model.*;

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
public class MgrItemAction
{
	private List<Item> items;
	private List<SelectItem> kinds;
	//����ע��ҵ���߼������Session Bean��
	@EJB(beanName="auctionManager")
	private AuctionManager am;
	//items���Ե�setter��getter����
	public void setItems(List<Item> items)
	{
		this.items = items;
	}
	public List<Item> getItems()
	{
		//��JSF�з���Session��Χ������
		Map<String , Object> session = FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getSessionMap();
		Integer userId = (Integer)session.get("userId");
		return am.getItemsByOwner(userId);
	}
	//kinds���Ե�setter��getter����
	public void setKinds(List<SelectItem> kinds)
	{
		this.kinds = kinds;
	}
	public List<SelectItem> getKinds()
	{
		 List<Kind> kinds = am.getAllKind();
		 //��Kind����ļ���ת��ΪSelectItem�ļ��ϡ�
		 List<SelectItem> kindItems = new ArrayList<SelectItem>();
		 for (int i = 0 ; i < kinds.size() ; i++)
		 {
			 kindItems.add(new SelectItem(kinds.get(i).getId().toString()
				 , kinds.get(i).getKindName().toString())); 
		 }
		 return kindItems;
	}
}