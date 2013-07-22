package org.crazyit.eao;

import javax.ejb.*;
import java.util.*;

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
@Local
public interface NewsEao
{
	/**
	 * ����id����Newsʵ��
	 * @param id ��Ҫ���ҵ�News��id
	 */ 
	News get(Integer id);
	/**
	 * ����Newsʵ��
	 * @param news ��Ҫ���ӵ�Newsʵ��
	 */	  
	void save(News news);
	/**
	 * �޸�Newsʵ��
	 * @param news ��Ҫ�޸ĵ�Newsʵ��
	 */
	void update(News news);
	/**
	 * ɾ��Newsʵ��
	 * @param id ��Ҫɾ����News��id
	 */ 
	void delete(Integer id);
	/**
	 * ɾ��Newsʵ��
	 * @param news ��Ҫɾ����Newsʵ��
	 */
	void delete(News news);
	/**
	 * ��ѯȫ����Newsʵ��
	 * @return ���ȫ����Newsʵ��
	 */ 
	List<News> findAll();
}
