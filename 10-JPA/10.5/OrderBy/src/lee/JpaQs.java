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
		Address mountain = new Address("����ɽ���� ˮ��������");
		Address road = new Address("����ȡ��·");
		try
		{
			//��������
			em.getTransaction().begin();
			//ΪPerson���2������ʵ��
			//��ΪPerson�����ƹ�����ϵ������Ӧͨ��Addressʵ�������������ϵ
			mountain.setPerson(sun);
			road.setPerson(sun);
			//����Addressʵ�壬�������ἶ����Personʵ�塣
			//��Personʵ�岻���ƹ�����ϵ����˱���Person���ἶ����Addressʵ��
			em.persist(road);
			em.persist(mountain);
			//�ύ����
			em.getTransaction().commit();
		} 
		finally 
		{
			em.close();
		}
	}
}