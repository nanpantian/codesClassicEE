
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
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
//Զ�̷����࣬Զ�̷��������̳�UnicastRemoteObject����ʵ��Remote�ӿ�
public class ServerImpl extends UnicastRemoteObject
	implements Server
{
	//����Ĭ�Ϲ��������������׳�RemoteException
	//��˴˴�������ʽ����ù�����
	public ServerImpl()
		throws RemoteException
	{
	}
	//ʵ��Remote�ӿڱ���ʵ�ֵķ���
	public String helloWorld(String name)
		throws RemoteException
	{
		return name + ", ����!";
	}
	//ʵ��Remote�ӿڱ���ʵ�ֵķ���
	public Person getPerson(String name , int age)
		throws RemoteException
	{
		return new Person(name , age);
	}
	//�����Ƿ�����ı��ط��������ᡰ��¶��ΪԶ�̷���
	public void info()
	{
		System.out.println("���Ǳ��ط���");
	}
	//�����ṩ������ڣ���Զ����ʵ����Ϊ�����ķ���
	public static void main(String[] args)
		throws Exception
	{
		//����Զ�̷�����ʵ��
		Server imp = new ServerImpl();
		//ע��Զ�̷���Ķ˿�
		LocateRegistry.createRegistry(1099);
		//��Զ�̷���ʵ����ΪԶ�̷���
		Naming.rebind("rmi://:1099/crazyit", imp);
	}
}
