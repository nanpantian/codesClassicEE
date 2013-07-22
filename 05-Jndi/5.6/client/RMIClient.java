
import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

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
//��Ϊ�ÿͻ������豩¶��Զ�̷����������̳�UnicastRemoteObject
public class RMIClient implements Client
{
	public static void main(String[] args)
		throws Exception 
	{
		Client client = new RMIClient();
		UnicastRemoteObject.exportObject(client);
		Server stub = (Server)Naming
			.lookup("rmi://127.0.0.1:1099/crazyit");
		//������������������ڶ�ȡ�û���������
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		String line = null;
		while((line = br.readLine()) != null)
		{
			//����Զ�̷���ʱ����������Ϊ��������
			stub.hello(client , line);
		}
	}
	//ʵ������Զ�̵��õķ���
	public void showDialog(String msg)
		throws java.rmi.RemoteException
	{
		//ʹ��JOptionPane��ʾ�Ի���
		System.out.println(msg);
	}
}