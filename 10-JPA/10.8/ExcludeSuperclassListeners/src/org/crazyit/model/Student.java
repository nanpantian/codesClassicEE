
package org.crazyit.model;

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
@Entity
@Table(name="student_table")
//ָ�������������ļ���������ʵ��������
@ExcludeSuperclassListeners
public class Student extends Person
{
	private int grade;

	//�޲����Ĺ�����
	public Student()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public Student(int grade)
	{
		this.grade = grade;
	}

	//grade���Ե�setter��getter����
	public void setGrade(int grade)
	{
		this.grade = grade;
	}
	public int getGrade()
	{
		return this.grade;
	}
}