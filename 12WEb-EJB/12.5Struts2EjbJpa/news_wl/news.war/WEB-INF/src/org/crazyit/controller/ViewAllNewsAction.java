package org.crazyit.controller;

import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

import org.crazyit.service.*;
import org.crazyit.model.*;
import org.crazyit.util.*;
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
//�̳�ActionSupport��ʵ��Struts 2��Action��
public class ViewAllNewsAction
	extends ActionSupport
{
	private List<News> newsList;
	//newsList���Ե�setter��getter����
	public void setNewsList(List<News> newsList)
	{
		this.newsList = newsList;
	}
	public List<News> getNewsList()
	{
		//����EJB�����ľ�̬��������ȡEJB������
		NewsService newsService = (NewsService)
			EJBFactory.lookup("newsService");
		//����EJB��ҵ���߼�����
		return newsService.getAllNews();
	}
}