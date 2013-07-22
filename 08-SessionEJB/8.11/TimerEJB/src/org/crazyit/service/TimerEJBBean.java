package org.crazyit.service;

import javax.ejb.*;
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
@Stateless(mappedName="TimerEJB")
public class TimerEJBBean
	implements TimerEJB
{
	//�������ö�ʱ���ķ���
	@Resource
	TimerService timerService;
	public void setTime(java.util.Date init 
		, long interval)
	{
		//����һ��ÿ��intervalʱ��ͻ�������ʱ��
		timerService.createTimer(init , interval
			, "�µĶ�ʱ����");
	}
	//���嶨ʱִ�еķ���
	@Timeout
	public void check(Timer timer)
	{
		System.out.println("��ʱ����Ϣ��"
			+ timer.getInfo());
		System.out.println("ģ��ϵͳ��飡");
	}
}
