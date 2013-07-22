package lee;

import java.util.List;
import javax.persistence.*;

import org.crazyit.model.*;
import java.io.*;

import java.awt.*;
import javax.swing.*;
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
		throws IOException
	{
		final EntityManager em = emf.createEntityManager();
		Person person = new Person();
		person.setName("crazyit.org");
		person.setBirth(new java.util.Date());
		try
		{
			//��������
			em.getTransaction().begin();
			//����ʵ��
			em.persist(person);
			//�ύ����
			em.getTransaction().commit();
		} 
		finally 
		{
			em.close();
		}
	}
}