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
		Person sun = new Person();
		sun.setName("�����");
		sun.setAge(500);
		Person zhu = new Person();
		zhu.setName("��˽�");
		zhu.setAge(380);
		Address road = new Address("����ȡ��·");
		try
		{
			//��������
			em.getTransaction().begin();
			//��ӹ���ʵ��
			//��ΪAddress�����ƹ�����ϵ������Ӧͨ��Personʵ�������������ϵ
			sun.getAddresses().add(new Address("����ɽ���� ˮ��������"));
			sun.getAddresses().add(road);
			zhu.getAddresses().add(new Address("����ׯ"));
			//��ϵͳ�����е�Addressʵ����ӳɹ�����ϵ
			zhu.getAddresses().add(road);
			//����ʵ��
			em.persist(sun);
			em.persist(zhu);
			//�ύ����
			em.getTransaction().commit();
		} 
		finally 
		{
			em.close();
		}
	}
}