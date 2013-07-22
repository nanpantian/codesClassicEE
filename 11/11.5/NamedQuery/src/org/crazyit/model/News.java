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
@NamedNativeQuery(name="news_query"
	, query="select id, news_title , content"
	+ " from news_table where id > ?"
	, resultSetMapping="news_mapping")
@SqlResultSetMapping(name="news_mapping",
	entities={
		@EntityResult(entityClass=org.crazyit.model.News.class 
			, fields={
		@FieldResult(name="id", column="id"),
		@FieldResult(name="title", column="news_title"),
		@FieldResult(name="content", column="content")})
	},
	columns={
		@ColumnResult(name="news_title"),
		@ColumnResult(name="content")}
)
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
	/* @Columnָ����Fieldӳ�������Ϣ���˴�ָ������Ϊnull */
	@Column(nullable=true)
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
