package lee;

import java.util.*;
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
public class TestBean
{
	//������������Զ���ֱ����JSF��ǩ��
	private String name;
	private Map<String , Double> books;
	private List<String> schools;
	//�޲����Ĺ�����
	public TestBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public TestBean(String name 
		, Map<String , Double> books 
		, List<String> schools)
	{
		this.name = name;
		this.books = books;
		this.schools = schools;
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

	//schools���Ե�setter��getter����
	public void setSchools(List<String> schools)
	{
		this.schools = schools;
	}
	public List<String> getSchools()
	{
		return this.schools;
	}
	//books���Ե�setter��getter����
	public void setBooks(Map<String , Double> books)
	{
		this.books = books;
	}
	public Map<String , Double> getBooks()
	{
		return this.books;
	}

}