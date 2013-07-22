package lee;

import org.crazyit.*;

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
public class CallPerson
{
	public static void main(String[] args) 
	{
		//PersonWS��wsdl2java���ɵ��࣬���ڼ򻯿ͻ��˿���
		PersonWS service = new PersonWS();
		//Person��Ҳ�Ƕ�̬���ɵ���
		Person pws = service.getPersonPort();
		//����Person_Type(��Ҳ�Ƕ�̬���ɵ���)���󣬸ö��󽫻���Ϊʵ�ʵĲ���
		Person_Type person = new Person_Type();
		person.setName("crazyit.org");
		person.setAge(20);
		//��Person_Type�����װ��SayHello����
		SayHello sh = new SayHello();
		sh.setSomebd(person);
		//����Web Service������
		System.out.println(pws.sayHello(sh).getReturn());
	}
}
