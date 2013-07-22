package org.crazyit.converter;

import javax.faces.convert.*;
import javax.faces.context.*;
import javax.faces.component.*;

import org.crazyit.jsf.*;
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
public class SonConverter 
	implements Converter
{
	//ʵ�ִ��ַ���������Ŀ������ת���ķ���
	public Object getAsObject(FacesContext context, 
		UIComponent component, String value)
	{
		String[] values = value.split(":");
		Son son = new Son(values[0] 
			, Double.parseDouble(values[1]) 
			, Integer.parseInt(values[2]));
		return son;
	}
	//ʵ�ִ�Ŀ���������ַ�������ת���ķ���
	public String getAsString(FacesContext context, 
		UIComponent component, Object value)
	{
		Son son = (Son)value;
		return "Son[name=" + son.getName()
			+ ", height=" + son.getHeight()
			+ ", age=" + son.getAge() + "]";
	}
}
