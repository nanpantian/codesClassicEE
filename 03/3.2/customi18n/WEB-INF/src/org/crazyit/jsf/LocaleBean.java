package org.crazyit.jsf;

import javax.faces.event.ValueChangeEvent;
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
public class LocaleBean
{
	private String locale;

	//�޲����Ĺ�����
	public LocaleBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public LocaleBean(String locale)
	{
		this.locale = locale;
	}

	//locale���Ե�setter��getter����
	public void setLocale(String locale)
	{
		this.locale = locale;
	}
	public String getLocale()
	{
		return this.locale;
	}
	public void choose(ValueChangeEvent vce)
	{
		//���û�ѡ���ֵ��Ϊ��ǰlocale
		this.locale = (String)vce.getNewValue();
	}
}