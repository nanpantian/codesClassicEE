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
		throws NamingException
	{
		//��ȡJBoss��JNDI�����Context
		Context jbossCtx = getJBossInitialContext();
		Hello h1 = (Hello)jbossCtx.lookup("Hello");
		//����JBoss������EJB��ҵ�񷽷�
		System.out.println(h1.hello("�����"));
		//��ȡWebLogic��JNDI�����Context
		Context ctx = getInitialContext();
		Hello h2 = (Hello)ctx.lookup("Hello#org.crazyit.service.Hello");
		//����WebLogic������EJB��ҵ�񷽷�
		System.out.println(h2.hello("�׹Ǿ�"));
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
			props.put(Context.PROVIDER_URL , SERVER_URL);
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
	//���߷�����������ȡJBoss��JNDI�����Context
	private Context getJBossInitialContext()
	{
		final String INIT_FACTORY = 
			"org.jnp.interfaces.NamingContextFactory";
		final String SERVER_URL = "localhost:1099";
		Context ctx = null;
		try
		{
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY
				, INIT_FACTORY);
			props.put(Context.PROVIDER_URL , SERVER_URL);
			ctx = new InitialContext(props);
		}
		catch(NamingException ne)
		{
			System.err.println("��������JBoss Server��:" + SERVER_URL);
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