package org.crazyit.jms;

import javax.ejb.*;
import javax.jms.*;
import javax.annotation.*;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> 
 * <br/>Copyright (C), 2001-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@MessageDriven(activationConfig=
/* 指定MDB所监听消息目的的类型 */
{@ActivationConfigProperty(propertyName="destinationType"
	, propertyValue="javax.jms.Queue"), 
@ActivationConfigProperty(propertyName="acknowledgeMode"
	, propertyValue="Auto-acknowledge"),
/* 指定MDB所监听的消息目的的JNDI绑定名 */
@ActivationConfigProperty(propertyName="destination" 
	, propertyValue="MessageQueue")
}
/* 指定MDB所监听的消息目的的JNDI绑定名 */
,mappedName="MessageQueue"
)
public class LifecycleMDB
	implements MessageListener
{
	//实现onMessage方法——当JMS消息被送达消息目的时，
	//该方法被触发
	public void onMessage(Message msg)
	{
		try
		{
			if (msg instanceof TextMessage)
			{
				TextMessage txt = (TextMessage)msg;
				String content = txt.getText();
				System.out.println("JMS信息中信息为："
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
		System.out.println("--初始化方法--");
	}
	@PreDestroy
	public void myDestroy()
	{
		System.out.println("--销毁之前的方法--");
	}
}
