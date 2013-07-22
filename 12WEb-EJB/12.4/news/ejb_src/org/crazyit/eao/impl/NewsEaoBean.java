package org.crazyit.eao.impl;

import java.util.*;
import javax.ejb.*;
import javax.annotation.*;
import javax.persistence.*;

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
@Stateless(name="newsEao")
public class NewsEaoBean
	implements NewsEao
{
	//����ע��EntityManager���
	@PersistenceContext(unitName="newsUnit")
	private EntityManager em;
	/**
	 * ����id����Newsʵ��
	 * @param id ��Ҫ���ҵ�News��id
	 */ 
	public News get(Integer id)
	{
		return em.find(News.class , id);
	}
	/**
	 * ����Newsʵ��
	 * @param news ��Ҫ���ӵ�Newsʵ��
	 */	  
	public void save(News news)
	{
		em.persist(news);
	}
	/**
	 * �޸�Newsʵ��
	 * @param news ��Ҫ�޸ĵ�Newsʵ��
	 */
	public void update(News news)
	{
		em.merge(news);
	}
	/**
	 * ɾ��Newsʵ��
	 * @param id ��Ҫɾ����News��id
	 */ 
	public void delete(Integer id)
	{
		em.remove(get(id));
	}
	/**
	 * ɾ��Newsʵ��
	 * @param news ��Ҫɾ����Newsʵ��
	 */
	public void delete(News news)
	{
		em.remove(news);
	}
	/**
	 * ��ѯȫ����Newsʵ��
	 * @return ���ȫ����Newsʵ��
	 */ 
	public List<News> findAll()
	{
		return (List<News>)em.createQuery("select news from News as news")
			.getResultList();
	}
}
