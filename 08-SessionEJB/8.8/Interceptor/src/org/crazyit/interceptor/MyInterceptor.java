package org.crazyit.interceptor;

import javax.interceptor.*;
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
public class MyInterceptor
{
	@AroundInvoke
	public Object log(InvocationContext ctx)
		throws Exception
	{
		System.out.println("------��������ʼ����------");
		//��Ŀ�귽��ִ��
		Object rvt = ctx.proceed();
		if (rvt != null)
		{
			rvt = "�������ı��˷���ֵ��" + rvt;
		}
		System.out.println("------������ִ�н���------");
		return rvt;
	}
}
