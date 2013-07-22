package org.crazyit.util;

import javax.persistence.*;
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
public class EntityManagerUtil
{
	//����ϵͳ�е�EntityManagerFactory
	private static final EntityManagerFactory emf; 
	//ʹ��ThreadLocal����֤EntityManager���̰߳�ȫ
	private static final ThreadLocal<EntityManager> threadLocal;
	/**��ʼ��*/
	static 
	{
		//��ʼ��EntityManagerFactory����
		emf = Persistence.createEntityManagerFactory("newsUnit");
		threadLocal = new ThreadLocal<EntityManager>();
	}
	//ͨ��ThreadLocal��ȡEntityManager����
	public static EntityManager getEntityManager() 
	{
		//��ȡ��ǰ�̹߳�����EntityManager����
		EntityManager em = threadLocal.get();
		//�����ǰ�̹߳�����EntityManagerΪnull����û�д�
		if (em == null || !em.isOpen())
		{
			//�����µ�EntityManager
			em = emf.createEntityManager();
			threadLocal.set(em);
		}
		return em;
	}
	//�ر�EntityManager����
	public static void closeEntityManager()
	{
		EntityManager em = threadLocal.get();
		threadLocal.set(null);
		if (em != null)
		{
			em.close();
		}
	}
	//��ʼ����
	public static void beginTransaction() 
	{
		getEntityManager().getTransaction().begin();
	}
	//�ύ����
	public static void commit() 
	{
		getEntityManager().getTransaction().commit();
	}
	//������ѯ
	public static Query createQuery(String jpql)
	{
		return getEntityManager().createQuery(jpql);
	}
}