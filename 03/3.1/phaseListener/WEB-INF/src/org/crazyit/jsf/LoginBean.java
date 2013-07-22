package org.crazyit.jsf;

import javax.faces.component.html.HtmlInputText;
import javax.faces.event.ActionEvent;
import javax.faces.context.FacesContext; 

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
public class LoginBean 
{
	private String name;
	private String pass;

	//�޲����Ĺ�����
	public LoginBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public LoginBean(String name , String pass)
	{
		this.name = name;
		this.pass = pass;
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

	//pass���Ե�setter��getter����
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}
	
	public String process()
	{
		//����Ӧ�õ���ҵ�����ͨ�����ݿ�����֤�û����������Ƿ���ȷ
		//�˴�ֻ��ֱ���ж�
		if (getName().equals("crazyit.org")
			&& getPass().equals("leegang"))
		{
			//����¼�û������ó�session��Χ������
			FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().put("user" , getName());
			return "success";
		}  
		return "failure";
	}
}