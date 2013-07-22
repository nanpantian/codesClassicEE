package org.crazyit.validator;

import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.application.*;
import javax.faces.validator.*;

import org.crazyit.jsf.util.*;
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
public class RegexValidator
	implements Validator, StateHolder 
{
	public final static String CRAZYIT_REGEX_INVALID
		= "crazyit_regex_invalid";
	private boolean transientValue = false;
	//��������ָ��������ʽ������
	private String pattern;
	//pattern���Ե�setter��getter����
	public void setPattern(String pattern)
	{
		this.pattern = pattern;
	}
	public String getPattern()
	{
		return this.pattern;
	}
	public void validate(FacesContext context,
		UIComponent component, Object toValidate) 
	{
		if (context == null || component == null)
		{
			throw new NullPointerException();
		}
		//����ֻ���������������
		if (!(component instanceof UIInput))
		{
			return;
		}
		//Ҫ����֤��ֵ�������
		if (null == toValidate) 
		{
			return;
		}
		//�����У���ֵ��ƥ��������ʽ
		if (!toValidate.toString().matches(pattern))
		{
			//ʹ�ù��ʻ���Ϣ��Դ����keyΪcrazyit_regex����Ϣ��Ϊ��ʾ
			throw new ValidatorException(
				MessageFactory.getMessage(CRAZYIT_REGEX_INVALID
				, component.getId()
				, pattern));
		}
	}
	//ʵ�ָ÷������ڱ����У������״̬
	public Object saveState(FacesContext context)
	{
		Object[] values = new Object[1];
		values[0] = pattern;
		return values;
	}
	//ʵ�ָ÷������ڻָ���У������״̬
	public void restoreState(FacesContext context
		,Object state) 
	{
		Object[] values = (Object[])state;
		pattern = (String) values[0];
	}
	public boolean isTransient() 
	{
		return (this.transientValue);
	}
	public void setTransient(boolean transientValue) 
	{
		this.transientValue = transientValue;
	}
}