package org.crazyit.dto;
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
public class NewsDTO
{
	private String title;
	private String content;

	//�޲����Ĺ�����
	public NewsDTO()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public NewsDTO(String title , String content)
	{
		this.title = title;
		this.content = content;
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

}