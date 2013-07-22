package org.crazyit.listener;

import javax.persistence.*;

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
public class DefaultPersistListener
{
	public void prePersist(Object entity)
	{
		System.out.println("--����֮ǰ--");
	}
	public void preUpdate(Object entity)
	{
		System.out.println("--����֮ǰ--");
	}
	public void postUpdate(Object entity)
	{
		System.out.println("--����֮��--");
	}
	public void postLoad(Object entity)
	{
		System.out.println("--����֮��--");
	}
}
