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
		//����Ա�����������
		zhu.setAddress(new Address("����","523034","�й�"));
		zhu.setId(1);
		//�����ڶ���Ա��
		Employee zhang = new Employee();
		//���ø�Ա���Ļ�������
		zhang.setName("������");
		zhang.setTitle("��Ŀ����");
		zhang.setGender('Ů');
		zhang.setSalary(5500);
		//���ø�Ա�����������
		zhang.setAddress(new Address("����","523034","�й�"));
		zhang.setId(2);
		//����һ����������
		Manager grace = new Manager();
		//���þ�������Ļ�������
		grace.setName("Grace");
		grace.setTitle("��Ŀ����");
		grace.setGender('Ů');
		grace.setSalary(12000);
		//���þ������������
		grace.setAddress(new Address("����","523034","����"));
		//���þ����Ĺ�Ͻ��������
		grace.setDepartment("�з���");
		grace.setId(3);
		//���õڶ���Ա����grace֮��Ĺ�����ϵ
		zhang.setManager(grace);
		//����һ��Customer����
		Customer he = new Customer();
		//����Customer����Ļ�������
		he.setName("С��");
		he.setGender('��');
		//����Customer������������
		he.setAddress(new Address("����","233034","�й�"));
		he.setComments("ϲ������");
		//����Customer�����grace����Ĺ�����ϵ
		he.setEmployee(grace);
		he.setId(4);
		//����һ����ͨPerson����
		Person lee = new Person();
		//����Person����Ļ�������
		lee.setName("Yeeku");
		lee.setGender('��');
		//����Person������������
		lee.setAddress(new Address("���","434333","�й�"));
		lee.setId(5);
		//�־û�����ʵ�塣
		em.persist(lee);
		em.persist(grace);
		em.persist(zhu);
		em.persist(zhang);
		em.persist(he);
		em.getTransaction().commit();
		em.close();
	}

}