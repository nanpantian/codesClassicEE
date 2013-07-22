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
		Person person = new Person();
		person.setName("�����");
		person.setAge(500);
		Address address = new Address();
		address.setDetail("����ɽ���� ˮ��������");
		try
		{
			//��������
			em.getTransaction().begin();
			//��������ʵ��Ĺ�����ϵ
			address.setPerson(person);
			//����addressʵ�壬���������cascade=ALL��
			//��˽������������ʵ��Person
			em.persist(address);
			//�ύ����
			em.getTransaction().commit();
		} 
		finally 
		{
			em.close();
		}
	}
}