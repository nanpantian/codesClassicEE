package org.crazyit.listener;

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
public class PersonPersistListener
{
	@PrePersist
	public void prePersist(Object entity)
	{
		if (entity instanceof Person)
		{
			System.out.println("--����֮ǰ--");
			Person person = (Person)entity;
			//�򵥼���
			person.setEmail(reverse(person.getEmail()));
		}
	}
	@PreUpdate
	public void preUpdate(Object entity)
	{
		if (entity instanceof Person)
		{
			System.out.println("--����֮ǰ--");
			Person person = (Person)entity;
			//�򵥼���
			person.setEmail(reverse(person.getEmail()));
		}
	}
	@PostUpdate
	public void postUpdate(Object entity)
	{
		System.out.println("--����֮��--");
	}
	@PostLoad
	public void postLoad(Object entity)
	{
		if (entity instanceof Person)
		{
			System.out.println("--����֮��--");
			Person person = (Person)entity;
			//�򵥼���
			person.setEmail(reverse(person.getEmail()));
		}
	}
	//�ṩһ���������ڶ��ַ������з�ת
	private String reverse(String raw)
	{
		StringBuffer sb = new StringBuffer(raw);
		return sb.reverse().toString();
	}
}
