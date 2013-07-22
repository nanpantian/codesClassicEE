package lee;

import javax.persistence.*;

import java.util.*;

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
public class PersonManager
{
	private static final EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("qs");
	public static void main(String[] args)
	{
		PersonManager mgr = new PersonManager();
		mgr.createAndStorePerson();
	}
	private void createAndStorePerson()
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		//����һ����ͨԱ��
		Employee zhu = new Employee();
		//����Ա���Ļ�������
		zhu.setName("����");
		zhu.setTitle("��Ŀ�鳤");
		zhu.setGender('��');
		zhu.setSalary(4500);
		//�����ڶ���Ա��
		Employee zhang = new Employee();
		//���ø�Ա���Ļ�������
		zhang.setName("������");
		zhang.setTitle("��Ŀ����");
		zhang.setGender('Ů');
		zhang.setSalary(5500);
		//����һ��Customer����
		Customer he = new Customer();
		//����Customer����Ļ�������
		he.setName("С��");
		he.setGender('��');
		he.setComments("ϲ������");
		he.setEmployee(zhang);
		Address address = new Address("���� ���");
		zhu.setAddress(address);
		zhang.setAddress(address);
		he.setAddress(address);
		
		//�־û�����ʵ�塣
		em.persist(zhu);
		em.persist(zhang);
		em.persist(he);
		em.getTransaction().commit();
		em.close();
	}
}
