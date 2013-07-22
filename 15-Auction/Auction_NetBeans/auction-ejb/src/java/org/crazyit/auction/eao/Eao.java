package org.crazyit.auction.eao;

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
public interface Eao
{
	/**
	 * ����ʵ��
	 * @param <T> ��̬����ʵ����
	 * @param entityClass ʵ����
	 * @param pk ����
	 * @return ����ָ���������ص�ʵ��
	 */
	<T> T get(Class<T> entityClass, Object pk);
	/**
	 * ����ʵ��
	 * @param entity ��Ҫ�����ʵ��
	 */
	void save(Object entity);
	/**
	 * ����ʵ��
	 * @param entity ��Ҫ���µ�ʵ��
	 */
	void update(Object entity);
	/**
	 * ɾ��ʵ��
	 * @param entityClass ��Ҫɾ��ʵ����
	 * @param pk ��Ҫɾ����ʵ������
	 */
	void delete(Class<?> entityClass, Object pk);

	/**
	 * ִ�в�ѯ�ķ���
	 * @param entityClass ʵ����
	 * @param whereJpql ָ����ѯ���صĵ�һ����¼
	 * @param orderBy �������������������ò�����Ϊnull.Map�����keyΪʵ���ֶ�����valueΪASC/DESC���磺
	 * LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
	 * orderBy.put("itemName", "DESC");��������itemName�������У�
	 * ���������key-value�ԣ����һ�η����key-value��Ϊ��Ҫ�ؼ��֣�
	 * �ڶ��η����key-value��Ϊ��Ҫ����ؼ��֡���
	 * @param args ��ΪΪJPQL��ѯ�ַ����Ĳ�����ֵ
	 * @return ���ز�ѯ�õ���ʵ��List
	 */
	<T> List<T> getResultList(Class<T> entityClass
		, String whereJpql
		, LinkedHashMap<String , String> orderBy
		, Object... args);
	/**
	 * ִ�в�ѯ�������з�ҳ�ķ���
	 * @param entityClass ʵ����
	 * @param whereJpql ָ����ѯ���صĵ�һ����¼
	 * @param firstResult ָ����ѯ���صĵ�һ����¼
	 * @param maxResult ���ò�ѯ��෵�ض��ټ�����¼
	 * @param orderBy �������������������ò�����Ϊnull.Map�����keyΪʵ���ֶ�����valueΪASC/DESC���磺
	 * LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>();
	 * orderBy.put("itemName", "DESC");��������itemName�������У�
	 * ���������key-value�ԣ����һ�η����key-value��Ϊ��Ҫ�ؼ��֣�
	 * �ڶ��η����key-value��Ϊ��Ҫ����ؼ��֡���
	 * @param args ��ΪΪJPQL��ѯ�ַ����Ĳ�����ֵ
	 * @return ���ز�ѯ�õ���ʵ��List
	 */
	<T> List<T> getResultList(Class<T> entityClass
		, String whereJpql
		, int firstResult 
		, int maxResult
		, LinkedHashMap<String , String> orderBy
		, Object... args);
}
