package org.crazyit.service;

import java.util.*;
import javax.ejb.*;


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
@Stateful(mappedName="ShopService")
public class ShopServiceBean 
	implements ShopService
{
	private Map<String, Integer> buyInfo
		= new HashMap<String, Integer>();
	public void addItem(String item)
	{
		//����Ʒ�Ѿ������
		if (buyInfo.containsKey(item))
		{
			//����������1
			buyInfo.put(item , 
				buyInfo.get(item) + 1);
		}
		else
		{
			//��������Ϊ1
			buyInfo.put(item , 1);
		}
	}
	public Map<String, Integer> showDetail()
	{
		return buyInfo;
	}
}
