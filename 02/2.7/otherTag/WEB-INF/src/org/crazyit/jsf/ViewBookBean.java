package org.crazyit.jsf;

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
public class ViewBookBean
{
	public List<BookBean> getBooks()
	{
		//���5��ͼ��
		List<BookBean> books = 
			new ArrayList<BookBean>();
		books.add(new BookBean(1 , "���Java����"
			, "crazyit.org"));
		books.add(new BookBean(2 , "������Java EE��ҵӦ��ʵս"
			, "crazyit.org"));
		books.add(new BookBean(3 , "���Ajax����"
			, "crazyit.org"));
		books.add(new BookBean(4 , "���XML����"
			, "crazyit.org"));
		books.add(new BookBean(5 , "����Java EE��ҵӦ��ʵս"
			, "crazyit.org"));
		return books;
	}
}
