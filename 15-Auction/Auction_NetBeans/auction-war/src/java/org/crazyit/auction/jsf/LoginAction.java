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
public class LoginAction
{
	private String username;
	private String password;
	private String vercode;
	private String errInfo;
	//����ע��ҵ���߼������Session Bean��
	@EJB(beanName="auctionManager")
	private AuctionManager am;
	public String execute() throws Exception
	{
		//��JSF�з���Session��Χ������
		Map<String , Object> session = FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getSessionMap();
		String ver2 = (String )session.get("rand");
		//���Http Session�е������֤���ַ�����
		session.put("rand" , null);
		if (vercode.equalsIgnoreCase(ver2))
		{
			Integer userId = am.validLogin(username,password);
			if (userId != null && userId > 0)
			{
				session.put("userId" , userId);
				return "success";
			}
			else
			{
				setErrInfo("�û���/���벻ƥ��");
				return "failure";
			}
		}
		else
		{
			setErrInfo("��֤�벻ƥ��,����������");
			return "failure";
		}
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

	//password���Ե�setter��getter����
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
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