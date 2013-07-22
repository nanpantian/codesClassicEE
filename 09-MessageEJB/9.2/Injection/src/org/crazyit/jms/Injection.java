package org.crazyit.jms;

import javax.ejb.*;
import javax.jms.*;

import org.crazyit.service.*;
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
@MessageDriven(activationConfig=
/* ָ��MDB��������ϢĿ�ĵ����� */
{@ActivationConfigProperty(propertyName="destinationType"
	, propertyValue="javax.jms.Queue"), 
@ActivationConfigProperty(propertyName="acknowledgeMode"
	, propertyValue="Auto-acknowledge"),
/* ָ��MDB����������ϢĿ�ĵ�JNDI���� */
@ActivationConfigProperty(propertyName="destination" 
	, propertyValue="MessageQueue")}
/* ָ��MDB����������ϢĿ�ĵ�JNDI���� */
,mappedName="MessageQueue"
)
public class Injection 
	implements MessageListener
{
	@EJB(name="StudentBean")
	private Student student;
	//ʵ��onMessage����������JMS��Ϣ���ʹ���ϢĿ��ʱ��
	//�÷���������
	public void onMessage(Message msg)
	{
		try
		{
			if (msg instanceof MapMessage)
			{
				MapMessage map = (MapMessage)msg;
				String name = map.getString("name");
				String gender = map.getString("gender");
				int age = map.getInt("age");
				//����Session Bean�ķ������ѧ����
				student.add(name , gender , age);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
