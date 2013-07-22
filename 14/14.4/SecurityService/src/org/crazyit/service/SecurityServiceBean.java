package org.crazyit.service;

import java.util.*;
import javax.ejb.*;

import javax.annotation.security.*;

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
@Stateless(mappedName="SecurityService" 
	, name="SecurityServiceEJB")
//����������ɫ
@DeclareRoles({"customer" , "admin"})
public class SecurityServiceBean
	implements SecurityService
{
	private static Map<String , Double> items
		= Collections.synchronizedMap(new HashMap<String ,Double>());
	static {
		items.put("���Java����" , 99.0);
		items.put("������Java EE��ҵӦ��ʵս" , 89.0);	
	}
	@PermitAll
	public Map<String , Double> getAllItem()
	{
		return items;
	}
	//ֻ��ӵ��admin��ɫ���ܵ��ø÷���
	@RolesAllowed("admin")
	public void addItem(String name , double price)
	{
		items.put(name, price);
	}
	//ֻ��ӵ��customer��ɫ���ܵ��ø÷���
	@RolesAllowed({"customer" , "admin"})
	public double buyItem(String name)
	{
		System.out.println("��ѡ����" + name + "��Ʒ");
		return items.get(name);
	}
}
