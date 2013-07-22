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
//JMS�첽�����߾���һ������������ʵ��MessageListener�ӿ�
public class AsyncConsumer
	implements MessageListener
{
	public AsyncConsumer()throws NamingException
		,JMSException , InterruptedException
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
		//���ͻ���ID��Ϊcrazyit.org
		conn.setClientID("leegang.org");
		//����JMS���ӣ�������ʼ����JMS��Ϣ
		conn.start();
		//JMS���Ӵ���JMS�Ự	
		Session session = conn.createSession(false/*���������ԻỰ*/
			, Session.AUTO_ACKNOWLEDGE);
		//�����ɿ�����Ϣ������
		MessageConsumer receiver = session.createDurableSubscriber(
			dest , "leegang.org");
		//ΪJMS��Ϣ�����߰���Ϣ������
		receiver.setMessageListener(this);
		//������ͣ20s���ڴ��ڼ������첽��ʽ������Ϣ
		Thread.sleep(20000);
		//�ر���Դ
		session.close();
		conn.close();
	}
	//ʵ����Ϣ����������ʵ�ֵķ�����
	public void onMessage(Message m)
	{
		TextMessage msg = (TextMessage)m;
		System.out.println(msg);
		try
		{
			System.out.println("�첽���յ���Ϣ��"
				+ msg.getText());
		}
		catch (JMSException ex)
		{
			ex.printStackTrace();
		}
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
		AsyncConsumer consumer = new AsyncConsumer();
	}
}