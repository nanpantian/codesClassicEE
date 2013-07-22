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
public class AddItemAction
{
	private String name;
	private String desc;
	private String remark;
	private double initPrice;
	private int avail;
	private int kind;
	private String vercode;
	private String tipInfo;
	//����ע��ҵ���߼������Session Bean��
	@EJB(beanName="auctionManager")
	private AuctionManager am;
	//�����û������execute����
	public String proAdd() throws Exception
	{
		//��JSF�з���Session��Χ������
		Map<String , Object> session = FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getSessionMap();
		String ver2 = (String)session.get("rand");
		//ǿ��ϵͳ�����ɵ������֤��ʧЧ
		session.put("rand" , null);
		Integer userId = (Integer)session.get("userId");
		//����û��������֤����ϵͳ�����������֤����ͬ
		if (vercode.equalsIgnoreCase(ver2))
		{
			//�����û�ѡ����Чʱ��ѡ�ָ��ʵ�ʵ���Чʱ��
			switch(avail)
			{
				case 6 :
					avail = 7;
					break;
				case 7 :
					avail = 30;
					break;
				case 8 :
					avail = 365;
					break;
			}
			//�����Ʒ
			am.addItem(name , desc , remark 
				, initPrice ,avail , kind, userId);
			setTipInfo("��Ʒ��ӳɹ���");
			//���ռ��û�������Ϣ�ı������
			return "succss";
		}
		else
		{
			setTipInfo("��֤�벻ƥ��,����������");
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
	//remark���Ե�setter��getter����
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		 return this.remark;
	}
	//initPrice���Ե�setter��getter����
	public void setInitPrice(double initPrice)
	{
		this.initPrice = initPrice;
	}
	public double getInitPrice()
	{
		 return this.initPrice;
	}
	//avail���Ե�setter��getter����
	public void setAvail(int avail)
	{
		this.avail = avail;
	}
	public int getAvail()
	{
		 return this.avail;
	}
	//kind���Ե�setter��getter����
	public void setKind(int kind)
	{
		this.kind = kind;
	}
	public int getKind()
	{
		 return this.kind;
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
	public void setTipInfo(String tipInfo)
	{
		this.tipInfo = tipInfo;
	}
	public String getTipInfo()
	{
		 return this.tipInfo;
	}
}