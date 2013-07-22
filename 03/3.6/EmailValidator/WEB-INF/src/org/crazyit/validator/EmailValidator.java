package org.crazyit.validator;

import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.application.*;
import javax.faces.validator.*;

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
public class EmailValidator
	implements Validator
{
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
		if (!toValidate.toString().matches(
			"\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"))
		{
			throw new ValidatorException(
				new FacesMessage("EmailУ��ʧ��"));
		}
	}
}