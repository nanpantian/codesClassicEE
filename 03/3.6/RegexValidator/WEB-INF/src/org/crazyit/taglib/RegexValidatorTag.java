package org.crazyit.taglib;

import javax.faces.context.FacesContext;
import javax.el.*;
import javax.faces.webapp.ValidatorELTag;
import javax.faces.validator.Validator;
import javax.servlet.jsp.JspException;
import org.crazyit.validator.RegexValidator;

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

public class RegexValidatorTag 
	extends ValidatorELTag 
{
	private static String validatorID = null;
	//Ϊ�Զ����ǩ����һ������
	private String pattern = null;
	public RegexValidatorTag() 
	{
		super();
		if (validatorID == null) 
		{
			validatorID = "regexValidator";
		}
	}
	public void setValidatorID(String validatorID) 
	{
		this.validatorID = validatorID;
	}
	//pattern���Ե�setter��getter����
	public void setPattern(String pattern)
	{
		//��pattern�ַ�����б�ߣ�/���滻�ɷ�б�ߣ�\��
		this.pattern = pattern.replace("/" , "\\");
	}
	public String getPattern()
	{
		return this.pattern;
	}
	//ValidatorELTag���������д�ķ�����
	//�÷������ڴ���ʵ��ִ��У���У����
	protected Validator createValidator()
		throws JspException 
	{

		FacesContext facesContext = 
			FacesContext.getCurrentInstance();
		RegexValidator result = null;
		//������ע�������У����ID����������У����
		if (validatorID != null)
		{
			result = (RegexValidator)facesContext
				.getApplication()
				.createValidator(validatorID);
		}
		result.setPattern(pattern);
		return result;
	}
} 