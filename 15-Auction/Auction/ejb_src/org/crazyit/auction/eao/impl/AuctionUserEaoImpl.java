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
@Stateless(name="auctionUserEao")
public class AuctionUserEaoImpl
	extends CrazyItEao implements AuctionUserEao  
{
	/**
	 * �����û�������������û�
	 * @param username ��ѯ������û���
	 * @param pass ��ѯ���������
	 * @return ָ���û����������Ӧ���û�
	 */
	public AuctionUser findUserByNameAndPass(String username , String pass)
	{
		List<AuctionUser> userList = getResultList(AuctionUser.class 
			, "where o.username = ?1 and o.userpass=?2"
			, null
			, username , pass);
		if (userList != null && userList.size() > 0)
		{
			return userList.get(0);
		}
		return null;
	}
}