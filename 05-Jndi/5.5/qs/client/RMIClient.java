
import javax.naming.*;
import java.rmi.*;
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
public class RMIClient
{
	public static void main(String[] args)throws Exception
	{
		//ͨ��JNDI����Զ�̷���,��ִ��ǿ������ת��
		Server ser = (Server)Naming.lookup("rmi://:1099/crazyit");
		System.out.println(ser instanceof java.rmi.server.RemoteStub);
		//����Զ�̷���
		System.out.println(ser.helloWorld("yeeku"));
		//����Զ�̷�����
		System.out.println(ser.getPerson("yeeku",28));
	}
}
