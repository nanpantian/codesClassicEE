package org.crazyit.business;

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
public class Person
{
	private Integer id;
	private String name;

	//�޲����Ĺ�����
	public Person()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public Person(Integer id , String name)
	{
		this.id = id;
		this.name = name;
	}

	//id���Ե�setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	//name���Ե�setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public boolean equals(Object target)
	{
		if (this == target)
		{
			return true;
		}
		if (target.getClass() == Person.class)
		{
			Person p = (Person)target;
			if (p.getId() == this.getId())
			{
				return true;
			}
		}
		return false;
	}
	public int hashCode()
	{
		return this.getId();
	}
}