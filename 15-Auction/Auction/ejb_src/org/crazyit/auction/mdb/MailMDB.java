package org.crazyit.auction.mdb;

import javax.jms.*;
import javax.ejb.*;

import org.crazyit.auction.util.*;

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
	, propertyValue="AuctionQueue")
}
/* ��MDB��Beanʵ�����ӵ�ʵ��MessageListener�ӿ� */
,messageListenerInterface=javax.jms.MessageListener.class 
/* ָ��MDB����������ϢĿ�ĵ�JNDI���� */
,mappedName="AuctionQueue"
)
public class MailMDB 
{
	//ʵ��onMessage����������JMS��Ϣ���ʹ���ϢĿ��ʱ��
	//�÷���������
	public void onMessage(Message rawMsg)
	{
		try
		{
			if (rawMsg instanceof MapMessage)
			{
				//����Ϣǿ��ת��ΪMapMessage
				MapMessage msg = (MapMessage)rawMsg;
				String mailTo = msg.getString("mailTo");
				String bidUser = msg.getString("bidUser");
				String itemName = msg.getString("itemName");
				//׼�������ʼ�
				SimpleMailSender sender =
					new SimpleMailSender();
				sender.setFrom("spring_test@sina.com");
				sender.setTo(mailTo);
				sender.setSubject("����֪ͨ");
				sender.setContent("Dear "
					+ bidUser
					+ ", лл����뾺�ۣ���ľ��۵���Ʒ����: "
					+ itemName);
				sender.send();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

