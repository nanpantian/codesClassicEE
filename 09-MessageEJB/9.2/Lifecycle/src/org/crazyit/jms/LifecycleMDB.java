package org.crazyit.jms;

import javax.ejb.*;
import javax.jms.*;
import javax.annotation.*;
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
	, propertyValue="MessageQueue")
}
/* ָ��MDB����������ϢĿ�ĵ�JNDI���� */
,mappedName="MessageQueue"
)
public class LifecycleMDB
	implements MessageListener
{
	//ʵ��onMessage����������JMS��Ϣ���ʹ���ϢĿ��ʱ��
	//�÷���������
	public void onMessage(Message msg)
	{
		try
		{
			if (msg instanceof TextMessage)
			{
				TextMessage txt = (TextMessage)msg;
				String content = txt.getText();
				System.out.println("JMS��Ϣ����ϢΪ��"
					+ content);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	@PostConstruct
	public void myInit()
	{
		System.out.println("--��ʼ������--");
	}
	@PreDestroy
	public void myDestroy()
	{
		System.out.println("--����֮ǰ�ķ���--");
	}
}
