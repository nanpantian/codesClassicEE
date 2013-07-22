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
			Query query = em.createQuery("select news , news.title , news.content"
				+ " from News as news where news.id > ?1 and"
				+ " news.title not like :title");
			//ΪJPQL�е�һ����������ֵ��
			List result = query.setParameter(1 , 1)
				// ΪJPQL����Ϊname�Ĳ������ò���ֵ
				.setParameter("title" , "%Java%")
				// ��ȡ��ѯ���Ľ��
				.getResultList();
			for (int i = 0 ; i < result.size() ; i++)
			{
				Object[] row = (Object[])result.get(i);
				for (int j = 0 ; j < row.length ; j++)
				{
					System.out.println(row[j]);
				}
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