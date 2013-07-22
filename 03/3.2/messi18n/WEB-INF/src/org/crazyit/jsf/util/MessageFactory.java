package org.crazyit.jsf.util;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.text.MessageFormat;

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
public class MessageFactory
{
	//������˽�У��������Ϊ��̬������ʹ��
	private MessageFactory() 
	{
	}
	//�÷�������Ϊ��ռλ�����ַ���������
	public static String substituteParams(Locale locale
		, String msgtext, Object[] params) 
	{
		String localizedStr = null;
		if ((params == null) || (msgtext == null)) 
		{
			return msgtext;
		}
		StringBuffer b = new StringBuffer(100);
		MessageFormat mf = new MessageFormat(msgtext);
		if (locale != null) 
		{
			mf.setLocale(locale);
			b.append(mf.format(params));
			localizedStr = b.toString();
		}
		return localizedStr;
	}
	public static FacesMessage getMessage(Locale locale
		, String key , Object[] params)
	{
		FacesMessage result = null;
		String summary = null;
		String detail = null;
		String bundleName = null;
		ResourceBundle bundle = null;
		//�ж��û��Ƿ��ṩ����Ϣ��Դ��
		if ((bundleName = getApplication()
			.getMessageBundle()) != null) 
		{
			if ((bundle = ResourceBundle.getBundle(
				bundleName , locale, getCurrentLoader(bundleName))) != null) 
			{
				try 
				{
					summary = bundle.getString(key);
				} 
				catch (MissingResourceException e) 
				{
				}
			}
		}
		if (summary == null) 
		{
			bundle = ResourceBundle.getBundle(
				FacesMessage.FACES_MESSAGES , locale 
				, getCurrentLoader(bundleName));

			if (bundle == null) 
			{
				throw new NullPointerException();
			}
			try 
			{
				summary = bundle.getString(key);
			}
			catch (MissingResourceException e)
			{
			}
		}
		if (summary == null)
		{
			return null;
		}
		if ((summary == null) || (bundle == null)) 
		{
			throw new NullPointerException();
		}
		//Ϊ���ʻ���Ϣ������
		summary = substituteParams(locale, summary, params);
		try 
		{
			detail = substituteParams(locale
				, bundle.getString(key + "_detail")
				, params);
		}
		catch (MissingResourceException e) 
		{
		}
		return new FacesMessage(summary , detail);
	}
	//----------�����Ǳ��������ṩ�ľ�̬��������----------
		//��ȡ���ʻ���Ϣ����������ʽΪռλ��
	public static FacesMessage getMessage(
		FacesContext context , String key,
		Object... params)
	{
		if ((context == null) || (key == null)) 
		{
			throw new NullPointerException(
				"One or more parameters could be null");
		}
		Locale locale = null;
		if ((context != null) && (context.getViewRoot() != null))
		{
			locale = context.getViewRoot()
				.getLocale();
		}
		else 
		{
			locale = Locale.getDefault();
		}
		if (locale == null)
		{
			throw new NullPointerException();
		}
		FacesMessage message = getMessage(locale, key, params);
		if (message != null) 
		{
			return message;
		}
		locale = Locale.getDefault();
		return getMessage(locale, key, params);
	}
	//ֱ��ʹ�õ�ǰLocale����ȡ���ʻ���Ϣ(0��ռλ��)
	public static FacesMessage getMessage(String key) 
	{
		return getMessage(getCurrentLocale(), key, null);
	}
	//ֱ��ʹ�õ�ǰLocale����ȡ���ʻ���Ϣ(���ռλ��)
	public static FacesMessage getMessage(String key
		, Object... params) 
	{
		return getMessage(getCurrentLocale(), key, params);
	}
	//----------������Ϊ���������ṩ�����protected����----------
	//��ȡӦ����ص�Application����
	protected static Application getApplication()
	{
		return (FacesContext.getCurrentInstance().getApplication());
	}
	//��ȡ��ǰ��ClassLoader����
	protected static ClassLoader getCurrentLoader(Object fallbackClass) 
	{
		ClassLoader loader = Thread.currentThread()
			.getContextClassLoader();
		if (loader == null)
		{
			loader = fallbackClass.getClass()
				.getClassLoader();
		}
		return loader;
	}
	//��ȡ��ǰ��Locale����
	protected static Locale getCurrentLocale() 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		Locale locale = null;
		//���Ӧ��Context�Ѿ���ʼ���ҵ�ǰContext��ViewRoot��Ϊnull
		if ((context != null) && (context.getViewRoot() != null)) 
		{
			locale = context.getViewRoot().getLocale();
			if (locale == null)
			{
				locale = Locale.getDefault();
			}
		}
		else 
		{
			locale = Locale.getDefault();
		}
		return locale;
	}
}