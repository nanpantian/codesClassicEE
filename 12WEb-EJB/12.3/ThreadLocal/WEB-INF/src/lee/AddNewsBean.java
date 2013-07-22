package lee;

import javax.persistence.*;

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

public class AddNewsBean
{
	//������������Զ���ֱ����JSF��ǩ��
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
	public String add()
	{
		//����ʵ����󣬲���������
		News news = new News();
		news.setTitle(title);
		news.setContent(content);
		//��һ����ǰ�߳���������EntityManager
		EntityManager em = EntityManagerUtil.getEntityManager();
		//��ʼ����
		EntityManagerUtil.beginTransaction();
		//�־û�����Newsʵ��
		em.persist(news);
		//�ύ����
		EntityManagerUtil.commit();
		//�ر�EntityManager
		EntityManagerUtil.closeEntityManager();
		return "success";
	}
}