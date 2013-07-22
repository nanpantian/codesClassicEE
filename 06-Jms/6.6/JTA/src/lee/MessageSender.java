package lee;

import javax.jms.*;
import javax.naming.*;
import java.util.Properties;
import javax.transaction.*;

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
public class MessageSender
{
	public void sendMessage()
		throws Exception
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
		Destination dest = (Destination)ctx.lookup("MessageQueue");
		//ͨ��JNDI���һ�ȡJTA���������
		UserTransaction tx = (UserTransaction)ctx
			.lookup("javax.transaction.UserTransaction");
		tx.begin();
		//���ӹ�����������
		Connection conn = connFactory.createConnection();
		//JMS���Ӵ���JMS�Ự
		Session session = conn.createSession(false/*ʹ�������ԻỰ*/
			, Session.AUTO_ACKNOWLEDGE);
		//JMS�Ự������Ϣ������
		MessageProducer sender = session.createProducer(dest);
		//������Ϣ������������������Ϣ�Ĵ���ģʽ����Чʱ�䡣
		sender.setDeliveryMode(DeliveryMode.PERSISTENT);
		sender.setTimeToLive(20000);
		//ͨ��JMS�Ự����һ���ı���Ϣ
		TextMessage msg = session.createTextMessage();
		//������Ϣ����
		msg.setText("Hello");
		//������Ϣ
		sender.send(msg);
		int a = 4 / 0;
		msg.setText("Welcome to JMS");
		//�ٴη�����Ϣ
		sender.send(msg);
		//�˴�����ִ��JDBC������EJB���������
		//...
		//�ύ����
		tx.commit();
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
		MessageSender mp = new MessageSender();
		mp.sendMessage();
	}
}

