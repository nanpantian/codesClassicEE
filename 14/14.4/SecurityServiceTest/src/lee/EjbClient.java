package lee;

import javax.rmi.*;
import javax.naming.*;
import java.util.Properties;

import org.crazyit.service.*;
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
public class EjbClient
{	 
	public void test()
		throws Exception
	{
		//��ȡWebLogic��JNDI�����Context
		Context ctx = getInitialContext();
		SecurityService ss = (SecurityService)ctx
			.lookup("SecurityService#org.crazyit.service.SecurityService");
		//�������淽��������admin��ɫ��
		ss.addItem("���XML����" , 65.0);
		System.out.println(ss.getAllItem());
		//�������淽��������customer��admin��ɫ
		System.out.println(ss.buyItem("���Java����"));
	}
	//���߷�����������ȡWebLogic��JNDI�����Context
	private Context getInitialContext()
	{
		final String INIT_FACTORY = 
			"weblogic.jndi.WLInitialContextFactory";
		final String SERVER_URL = "t3://localhost:7001";
		Context ctx = null;
		try
		{
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY 
				, INIT_FACTORY);
			//ָ����¼���õ��û�����������
			props.put(Context.SECURITY_PRINCIPAL , "admin");
			props.put(Context.SECURITY_CREDENTIALS , "12");
			ctx = new InitialContext(props);
		}
		catch(NamingException ne)
		{
			System.err.println("��������WebLogic Server��:"
				+ SERVER_URL);
			ne.printStackTrace();
		}
		return ctx;
	}
	public static void main(String[] args)
		throws Exception
	{
		EjbClient client = new EjbClient();
		client.test();
	}
}