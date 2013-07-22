package lee;

import java.util.List;
import javax.persistence.*;

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

public class JpaQs
{
	//һ���־õ�Ԫ��Ӧһ��EntityManagerFactory
	private static final EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("qs");
	public static void main(String[] args)
	{
		EntityManager em = emf.createEntityManager();
		try
		{
			//��������
			em.getTransaction().begin();
			Query query = em.createNativeQuery("{call select_all_news(?)}"
				, News.class);
			//ΪJPQL�е�һ����������ֵ��
			List<News> result = query.setParameter(1 , "%Java%")
				//��ȡ��ѯ���Ľ��
				.getResultList();
			//��ѯ���Ϊ����Ԫ��ΪNewsʵ���List����
			for (int i = 0 ; i < result.size() ; i++)
			{
				News news = result.get(i);
				System.out.println(news.getTitle()
					+ "\t" + news.getContent());
			}
			//�ύ����
			em.getTransaction().commit();
		} 
		finally 
		{
			em.close();
		}
	}
}