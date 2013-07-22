package org.crazyit.jsf;


import javax.faces.context.*;
import javax.servlet.http.*;
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
public class BookBean 
{
	private String name;
	private Double price;
	//�޲����Ĺ�����
	public BookBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public BookBean(String name , Double price)
	{
		this.name = name;
		this.price = price;
	}

	//name���Ե�setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	//price���Ե�setter��getter����
	public void setPrice(Double price)
	{
		this.price = price;
	}
	public Double getPrice()
	{
		return this.price;
	}

	//��д�������ķ���
	public String process()
	{
		FacesContext fc = FacesContext.getCurrentInstance();
		LocaleBean localeBean = (LocaleBean)fc.getExternalContext()
			.getSessionMap().get("localeBean");
		String[] langAndCountry = localeBean.getLocale().split("_");
		Locale current = new Locale(langAndCountry[0] , langAndCountry[1]);
		//ʹ��ResourceBundle�����ع��ʻ���Ϣ��Դ
		ResourceBundle rb = ResourceBundle.getBundle(
			"global" , current); 
		//���漸�д������ڲ���ExternalContext�ķ���
		ExternalContext ec = fc.getExternalContext();
		if (name.equals("���Java����")
			&& price == 99)
		{
			//�����ݴ���session��Χ
			ec.getSessionMap().put("website"
				, "crazyit.org");
			return "success";
		}
		else
		{
			ec.getSessionMap().put("tip" 
				, rb.getString("wrong"));
			return "failure";
		}
	}
}