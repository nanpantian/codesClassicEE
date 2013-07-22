package org.crazyit.controller;

import com.opensymphony.xwork2.ActionSupport;

import org.crazyit.service.*;
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
public class AddNewsAction extends ActionSupport
{
	//������Action�����ڷ�װ�û������������������
	private String title;
	private String content;
	//title���Ե�setter��getter����
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	//content���Ե�setter��getter����
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}
	//�����û������execute����
	public String execute() throws Exception
	{
		//����EJB�����ľ�̬��������ȡEJB������
		NewsService newsService = (NewsService)
			EJBFactory.lookup("newsService");
		//����EJB�ķ����������û�����
		newsService.addNews(title , content);
		return SUCCESS;
	}
}