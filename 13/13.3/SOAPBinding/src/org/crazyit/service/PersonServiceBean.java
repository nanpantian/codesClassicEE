package org.crazyit.service;

import javax.ejb.*;
import javax.jws.*;
import javax.jws.soap.*;

import org.crazyit.model.*;
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
@Stateless
@WebService(name="person"
	, serviceName="personWS"
	, portName="personPort"
	, targetNamespace="http://www.crazyit.org")
@SOAPBinding(style=SOAPBinding.Style.RPC
	, use=SOAPBinding.Use.ENCODED)
public class PersonServiceBean
	implements PersonService
{
	//���Ƹ�Web Service��������Ϊ
	@WebMethod(operationName="sayHello"
		, action="http://www.crazyit.org/greet")
	public String hello(Person person)
	{
		return person.getName() + "�����ã����������ǣ�"
			+ person.getAge()
			+ "������ʱ���ǣ�" + new java.util.Date();
	}
	//���÷����ų���Web Service֮��
	@WebMethod(exclude=true)
	public long test()
	{
		return Math.round(Math.random() * 100);
	}
}
