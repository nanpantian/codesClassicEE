package lee;

import javax.ejb.*;

import org.crazyit.service.*;
import javax.faces.context.*;
import javax.servlet.http.*;
import javax.naming.*;
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
//ͨ��@EJB Annotation����EJB���á�
@EJB(name="userService"
	, beanInterface=org.crazyit.service.UserService.class)
public class LoginBean
{
	//������������Զ���ֱ����JSF��ǩ��
	private String name;
	private String pass;
	private String info;
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

	//info���Ե�setter��getter����
	public void setInfo(String info)
	{
		this.info = info;
	}
	public String getInfo()
	{
		return this.info;
	}
	//�÷������󶨵�UI�������ť����action����
	public String valid()
	{
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession)ec.getSession(true);
		UserService us = (UserService)session.getAttribute("us");
		if (us == null)
		{
			try
			{
				Context ctx = new InitialContext();
				//ͨ��EJB���ò���EJB
				us = (UserService)ctx.lookup("java:comp/env/userService");
				session.setAttribute("us" , us);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		//����Session Bean�ķ����������û�����
		if (us.loginPro(name , pass))
		{
			//����Session Bean�ķ�����ȡ�û��ĵ�¼��Ϣ
			setInfo(us.getLoginInfo());
			return "success";
		}
		setInfo("�����û��������벻����");
		return "failure";
	}
}