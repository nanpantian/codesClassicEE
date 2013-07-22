package org.crazyit.controller;

import javax.ejb.*;
import javax.naming.*;
import java.util.*;

import org.crazyit.service.*;
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
public class ViewAllNews
{
	//ͨ������ע�뽫EJB���ע����й�Bean
	@EJB(beanName="newsService")
	private NewsService newsService;
	private List<News> newsList;
	//newsList���Ե�setter��getter����
	public void setNewsList(List<News> newsList)
	{
		this.newsList = newsList;
	}
	public List<News> getNewsList()
	{
		//����EJB��ҵ���߼�����
		return newsService.getAllNews();
	}
}