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
public class AddKindAction
{
	private String name;
	private String desc;
	private String vercode;
	private String errInfo;
	//����ע��ҵ���߼������Session Bean��
	@EJB(beanName="auctionManager")
	private AuctionManager am;

	public String proAdd()throws Exception
	{
		//��JSF�з���Session��Χ������
		Map<String , Object> session = FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getSessionMap();
		String ver2 = (String)session.get("rand");
		session.put("rand" , null);
		if (vercode.equalsIgnoreCase(ver2))
		{				
			am.addKind(name , desc);
			setErrInfo("������ӳɹ���");
			return "success";
		}
		else
		{
			setErrInfo("��֤�벻ƥ��,����������");
			return "input";
		}
	}
	//name���Ե�setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		 return this.name;
	}
	//desc���Ե�setter��getter����
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		 return this.desc;
	}
	//vercode���Ե�setter��getter����
	public void setVercode(String vercode)
	{
		this.vercode = vercode;
	}
	public String getVercode()
	{
		 return this.vercode;
	}
	//errInfo��setter��getter����
	public void setErrInfo(String errInfo)
	{
		this.errInfo = errInfo;
	}
	public String getErrInfo()
	{
		 return this.errInfo;
	}
}