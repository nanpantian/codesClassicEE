package org.crazyit.auction.jsf;

import java.util.*;
import javax.ejb.*;
import javax.faces.context.FacesContext;

import org.crazyit.auction.service.AuctionManager;
import org.crazyit.auction.exception.AuctionException;

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
public class AddBidAction
{
	//��װ�������������
	private int itemId;
	private double bidPrice;
	private double maxPrice;
	private String vercode;
	private String tipInfo;
	//����ע��ҵ���߼������Session Bean��
	@EJB(beanName="auctionManager")
	private AuctionManager am;
	//�����û�����
	public String bidPro() throws Exception
	{
		//��JSF�з���Session��Χ������
		Map<String , Object> session = FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getSessionMap();
			//ȡ��Session�е�userId�͸ո����ɵ������֤��
		Integer userId = (Integer)session.get("userId");
		String ver2 = (String)session.get("rand");
		session.put("rand" , null);
		//����û��������֤���Session�е������֤����ͬ
		if (vercode.equalsIgnoreCase(ver2))
		{
			if(bidPrice <= getMaxPrice())
			{
				setTipInfo("������ľ��۱�����ڵ�ǰ��߼ۣ�");
				return "input";
			}
			am.addBid(getItemId() , bidPrice ,userId);  
			setTipInfo("���۳ɹ���");
			return "success";
		}
		else
		{
			setTipInfo("��֤�벻ƥ��,����������");
			return "input";
		}
	}
	//itemId��setter��getter����
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
	//bidPrice���Ե�setter��getter����
	public void setBidPrice(double bidPrice)
	{
		this.bidPrice = bidPrice;
	}
	public double getBidPrice()
	{
		return this.bidPrice;
	}
	//maxPrice��setter��getter����
	public void setMaxPrice(double maxPrice)
	{
		this.maxPrice = maxPrice;
	}
	public double getMaxPrice()
	{
		Map<String , String> request = FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getRequestParameterMap();
		return Double.parseDouble(request.get("maxPrice"));
	}
	//vercode��setter��getter����
	public void setVercode(String vercode)
	{
		this.vercode = vercode;
	}
	public String getVercode()
	{
		 return this.vercode;
	}
	//errInfo��setter��getter����
	public void setTipInfo(String tipInfo)
	{
		this.tipInfo = tipInfo;
	}
	public String getTipInfo()
	{
		 return this.tipInfo;
	}
}