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
	@Transient
	private String content;
	//������
	public News()
	{
	}
	//��ʶ���Ե�setter��getter����
	public void setId(int id) 
	{
		this.id = id; 
	}
	public int getId()
	{
		return (this.id); 
	}
	//��Ϣ�����setter������getter����
	public void setTitle(String title) 
	{
		this.title = title; 
	}
	public String getTitle() 
	{
		return (this.title); 
	}
	//��Ϣ���ݵ�setter������getter����
	public void setContent(String content)
	{
		this.content = content; 
	}
	public String getContent()
	{
		return (this.content); 
	}
}
