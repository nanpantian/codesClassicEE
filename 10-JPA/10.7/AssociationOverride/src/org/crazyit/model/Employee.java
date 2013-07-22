package org.crazyit.model;

import java.util.*;

import javax.persistence.*;

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

//Ա����̳���Person��
@Entity
@AssociationOverride(name="address", 
	joinColumns=@JoinColumn(name="employee_address"))
public class Employee extends Person
{
	//�����Ա����ְλ����
	private String title;
	//�����Ա���Ĺ�������
	private double salary;
	//�͹˿ͱ��ֹ�����ϵ������
	@OneToMany(cascade=CascadeType.ALL 
		, mappedBy="employee" , targetEntity=Customer.class)
	private Set<Customer> customers = new HashSet<Customer>();
	//�޲����Ĺ�����
	public Employee()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public Employee(String title , double salary)
	{
		this.title = title;
		this.salary = salary;
	}

	//title���Ե�setter��getter����
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	//salary���Ե�setter��getter����
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	public double getSalary()
	{
		return this.salary;
	}

	//customers���Ե�setter��getter����
	public void setCustomers(Set<Customer> customers)
	{
		this.customers = customers;
	}
	public Set<Customer> getCustomers()
	{
		return this.customers;
	}
}