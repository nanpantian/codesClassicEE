package lee;

import javax.persistence.*;

import java.util.*;

import org.crazyit.model.*;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> 
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
		//创建一个普通员工
		Employee zhu = new Employee();
		//设置员工的基本属性
		zhu.setName("老朱");
		zhu.setTitle("项目组长");
		zhu.setGender('男');
		zhu.setSalary(4500);
		//设置员工的组件属性
		zhu.setAddress(new Address("广州","523034","中国"));
		zhu.setId(1);
		//创建第二个员工
		Employee zhang = new Employee();
		//设置该员工的基本属性
		zhang.setName("张美丽");
		zhang.setTitle("项目分析");
		zhang.setGender('女');
		zhang.setSalary(5500);
		//设置该员工的组件属性
		zhang.setAddress(new Address("广州","523034","中国"));
		zhang.setId(2);
		//创建一个经理对象
		Manager grace = new Manager();
		//设置经理对象的基本属性
		grace.setName("Grace");
		grace.setTitle("项目经理");
		grace.setGender('女');
		grace.setSalary(12000);
		//设置经理的组件属性
		grace.setAddress(new Address("加州","523034","美国"));
		//设置经理的管辖部门属性
		grace.setDepartment("研发部");
		grace.setId(3);
		//设置第二个员工和grace之间的关联关系
		zhang.setManager(grace);
		//创建一个Customer对象
		Customer he = new Customer();
		//设置Customer对象的基本属性
		he.setName("小贺");
		he.setGender('男');
		//设置Customer对象的组件属性
		he.setAddress(new Address("湖南","233034","中国"));
		he.setComments("喜欢购物");
		//建立Customer对象和grace对象的关联关系
		he.setEmployee(grace);
		he.setId(4);
		//创建一个普通Person对象
		Person lee = new Person();
		//设置Person对象的基本属性
		lee.setName("Yeeku");
		lee.setGender('男');
		//设置Person对象的组件属性
		lee.setAddress(new Address("天河","434333","中国"));
		lee.setId(5);
		//持久化所有实体。
		em.persist(lee);
		em.persist(grace);
		em.persist(zhu);
		em.persist(zhang);
		em.persist(he);
		em.getTransaction().commit();
		em.close();
	}

}
