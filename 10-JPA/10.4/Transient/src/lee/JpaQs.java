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
		final EntityManager em = emf.createEntityManager();
		News news = new News();
		news.setTitle("���Java���˳����ˣ�");
		news.setContent("���Java���˳����ˣ�"
			+ "������ɫ�ǣ����м����������лظ���");
		try
		{
			//��������
			em.getTransaction().begin();
			//����ʵ��
			em.persist(news);
			//�ύ����
			em.getTransaction().commit();
		} 
		finally 
		{
			em.close();
		}
	}
}