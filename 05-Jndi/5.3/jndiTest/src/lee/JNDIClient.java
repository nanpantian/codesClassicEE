package lee;

import java.util.*;
import javax.naming.*;
import javax.swing.*;
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
public class JNDIClient
{
	public static void main(String[] args)
		throws Exception
	{
		final String INIT_FACTORY = 
			"weblogic.jndi.WLInitialContextFactory";
		final String WL_URL = "t3://localhost:7001";
		Hashtable props = new Hashtable();
		props.put(Context.INITIAL_CONTEXT_FACTORY , INIT_FACTORY);
		props.put(Context.PROVIDER_URL , WL_URL);
		//�����Ҫ��ȫ���ƣ�����Ҫ�������д���
//		props.put(Context.SECURITY_PRINCIPAL, "weblogic");
//		props.put(Context.SECURITY_CREDENTIALS, "weblogic");
		//��ʼ��Context��ʹ��InitialContext��ʼ��Context
		Context ctx = new InitialContext(props); 
		//ͨ��JNDI���Ҷ��󣬸ö�����һ��JFrame����
		Object obj = ctx.lookup("testName");
		System.out.println(obj);
	}
}
