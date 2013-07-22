package lee;

import javax.naming.*;
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
public class NameServiceTest2
{
	public static void main(String[] args) 
		throws NamingException
	{
		final String fileName = "youandme.mp3";
		final String newName = "�ͺ���.mp3";
		final String dirName = "Beyond";
		final String newDir1 = "newDir1";
		final String newDir2 = "newDir2";
		//����һ��Hashtable��������ΪContext���ó�ʼ������
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, 
			"com.sun.jndi.fscontext.RefFSContextFactory");
		env.put(Context.PROVIDER_URL, "file:/F:/music");
		Context ctx = new InitialContext(env);
		//�г���ǰContext�µ����а󶨹�ϵ
		NamingEnumeration<Binding> bindings 
			= ctx.listBindings("");
		while(bindings.hasMore())
		{
			Binding binding = bindings.next();
			System.out.println(binding.getName()
				+ " --> " + binding.getObject());
		}
		//�г���ǰContext��ָ��SubContext�µ����а󶨹�ϵ
		bindings = ctx.listBindings(dirName);
		System.out.println("------������Beyond Context�µİ�------");
		while(bindings.hasMore())
		{
			Binding binding = bindings.next();
			System.out.println(binding.getName()
				+ " --> " + binding.getObject());
		}
		//����2��SubContext��ʵ�ʾ��Ǵ���������Ŀ¼��
		ctx.createSubcontext(newDir1);
		ctx.createSubcontext(newDir2);
		//ɾ��1��SubContext
		ctx.destroySubcontext(newDir2);
		//����ǰContext��ָ���İ�������������
		ctx.rename(fileName , newName);
		ctx.close();
	}
}
