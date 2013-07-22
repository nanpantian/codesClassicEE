package lee;

import javax.jms.*;
import javax.naming.*;
import java.util.Properties;
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
public class PropertyConsumer
{	 
	public void receiveMessage()
		throws JMSException , NamingException
	{
		//����WebLogicĬ�����ӹ�����JNDI
		final String CONNECTION_FACTORY_JNDI
			= "weblogic.jms.ConnectionFactory";
		//��ȡJNDI���������Context
		Context ctx = getInitialContext();
		//ͨ��JNDI���һ�ȡ���ӹ���
		ConnectionFactory connFactory = (ConnectionFactory)
			ctx.lookup(CONNECTION_FACTORY_JNDI);
		//ͨ��JNDI���һ�ȡ��ϢĿ��	
		Destination dest = (Destination)ctx.lookup("MessageTopic");
		//���ӹ�����������
		Connection conn = connFactory.createConnection();
		//����JMS���ӣ�������ʼ����JMS��Ϣ
		conn.start();
		//JMS���Ӵ���JMS�Ự
		Session session = conn.createSession(false/*���������ԻỰ*/
			, Session.AUTO_ACKNOWLEDGE);
		//JMS�Ự������Ϣ������,ָ������Ϣ������ֻ��ConType����ΪTXT����Ϣ����Ȥ��
		MessageConsumer receiver = session.createConsumer(dest
			, "ConType='TXT'");
		//ͬ��������Ϣ�����û�н��յ���Ϣ���÷����������߳�
		TextMessage msg = (TextMessage)receiver.receive();
		System.out.println(msg);
		System.out.println("ͬ�����յ�����Ϣ��" + msg.getText());
		//�ر���Դ
		session.close();
		conn.close();
	}
	//���߷�����������ȡ���������Context����
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
	public static void main(String[] args)
		throws Exception
	{
		PropertyConsumer pc = new PropertyConsumer();
		pc.receiveMessage();
	}
}