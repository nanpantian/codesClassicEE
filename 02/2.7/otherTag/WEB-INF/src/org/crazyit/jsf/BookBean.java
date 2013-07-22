package org.crazyit.jsf;

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
public class BookBean
{
	private int id;
	private String name;
	private String website;

	//�޲����Ĺ�����
	public BookBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public BookBean(int id , String name , String website)
	{
		this.id = id;
		this.name = name;
		this.website = website;
	}

	//id���Ե�setter��getter����
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
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

	//website���Ե�setter��getter����
	public void setWebsite(String website)
	{
		this.website = website;
	}
	public String getWebsite()
	{
		return this.website;
	}

}