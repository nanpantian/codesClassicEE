package org.crazyit.auction.schedule;

import javax.servlet.*;
import java.util.*;

import javax.ejb.*;

import org.crazyit.auction.service.*;
import org.crazyit.auction.exception.*;


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
public class ScheduleListener 
	implements ServletContextListener
{
	//������������ҵ���߼����
	@EJB(beanName="auctionManager")
	private AuctionManager mgr;
	public void contextDestroyed(ServletContextEvent sce)
	{
	}
	public void contextInitialized(ServletContextEvent sce)
	{
		java.util.Timer timer = new java.util.Timer(true);
		timer.schedule(new TimerTask()
		{
			//�������ִ����
			public void run()
			{
				try
				{
					mgr.updateWiner();
				}
				catch (AuctionException ae)
				{
					ae.printStackTrace();
				}
			}
		}, 0 , 1000 * 3600);
	}	
}
