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
@Stateless(name="userService")
public class UserServiceBean 
	implements UserService
{
	//�����û����������ж�ָ���û��Ƿ����
	public boolean loginPro(String name , String pass)
	{
		//��������£�ҵ���߼����Ӧ�õ���EAO���������ݿ⣬
		//���ݵײ����ݿ�ļ�¼���ж��Ƿ���ڸ��û�,�������ڻ�δ��ʽ����
		//Session Facade EAO����ֱ���������ж��ˡ�
		if (name.equals("crazyit") && pass.equals("leegang"))
		{
			return true;
		}
		return false;
	}
}