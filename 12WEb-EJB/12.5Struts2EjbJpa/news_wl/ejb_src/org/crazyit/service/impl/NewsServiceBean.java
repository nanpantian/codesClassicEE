package org.crazyit.service.impl;

import java.util.*;
import javax.ejb.*;

import org.crazyit.service.*;
import org.crazyit.eao.*;
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
//���������������������
@TransactionManagement(TransactionManagementType.CONTAINER)
public class NewsServiceBean
	implements NewsService
{
	//����ע��EAO���
	@EJB(beanName="newsEao")
	private NewsEao newsEao;
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int addNews(String title , String content)
	{
		News news = new News();
		news.setTitle(title);
		news.setContent(content);
		//����EAO����ķ���ִ�г־û�
		newsEao.save(news);
		return news.getId();
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<News> getAllNews()
	{
		//����EAO�ķ���ʵ��ҵ���߼�
		return newsEao.findAll();
	}
}
