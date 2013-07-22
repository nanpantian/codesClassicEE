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
@Table(name="news_table")
public class News
{
	//��Ϣ��ı�ʶ����
	@Id /* �������α�ʶ���� */
	/* ָ���������е��������ɲ��� */
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//��Ϣ����
	/* @Columnָ����Fieldӳ�������Ϣ���˴�ָ�������������� */
	@Column(name="news_title" , length=50)
	private String title;
	//��Ϣ����
	private String content;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="happen_season")
	private Season happenSeason;
	//�޲����Ĺ�����
	public News()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public News(int id , String title 
		, String content , Season happenSeason)
	{
		this.id = id;
		this.title = title;
		this.content = content;
		this.happenSeason = happenSeason;
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

	//title���Ե�setter��getter����
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	//content���Ե�setter��getter����
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}

	//happenSeason���Ե�setter��getter����
	public void setHappenSeason(Season happenSeason)
	{
		this.happenSeason = happenSeason;
	}
	public Season getHappenSeason()
	{
		return this.happenSeason;
	}
}