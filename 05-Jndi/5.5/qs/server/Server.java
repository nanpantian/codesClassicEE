
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
//Զ�̽ӿڱ��뼯��java.rmi.Remote�ӿ�
public interface Server extends Remote 
{
	//������Remote�ӿ��������ķ�����Ӧ���׳�RemoteException�쳣
	String helloWorld(String name)
		throws RemoteException;
	Person getPerson(String name , int age)
		throws RemoteException;
}

