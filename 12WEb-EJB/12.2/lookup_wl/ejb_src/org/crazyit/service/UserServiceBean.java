package org.crazyit.service;

import java.util.*;
import javax.ejb.*;

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
@Stateful
public class UserServiceBean 
	implements UserService
{
	private int loginCount;
	public boolean loginPro(String name , String pass)
	{
		if (name.equals("crazyit") && pass.equals("leegang"))
		{
			loginCount++;
			return true;
		}
		return false;
	}
	public String getLoginInfo()
	{
		return "��ӭ�������ѳɹ���¼" + loginCount + "��!";
	}
}
