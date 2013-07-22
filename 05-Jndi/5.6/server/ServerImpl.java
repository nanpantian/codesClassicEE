import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;
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
public class ServerImpl extends UnicastRemoteObject
	implements Server 
{
	//����һ��List�����������ӽ����Ŀͻ�
	static List<Client> users 
		= new ArrayList<Client>();
	public ServerImpl()
		throws RemoteException
	{
	}
	//�÷�������һ���β���Client����
	//ͨ�����ַ�ʽ�÷��������Զ�̿ͻ��˶��������
	public void hello(Client cm , String saying)
		throws Exception
	{
		if (!users.contains(cm))
		{
			users.add(cm);
		}
		try
		{
			java.util.Date now = new java.util.Date();
			String msg = now + saying;
			//���ε������ӵ��÷�������ÿ���ͻ��˵�showDialog����
			for (Client c : users)
			{
				//�ص�Զ�̿ͻ��˷���
				c.showDialog(msg);
			}
		}
		catch (RemoteException ex)
		{
			users.remove(cm);
			ex.printStackTrace();
		}
	}
	public static void main(String args[])
		throws Exception 
	{
		//ע��RMI����˿�
		LocateRegistry.createRegistry(1099);
		Server remote = new ServerImpl();
		//��Զ�̷������󶨵�ָ��JNDI��
		Naming.rebind("rmi://127.0.0.1:1099/crazyit"
			, remote);
	}
}
