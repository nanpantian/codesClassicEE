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
public class NameServiceTest
{
	public static void main(String[] args) 
		throws NamingException
	{
		final String fileName = "00.Ŀ¼.docx";
		final String dirName = "codes";
		//����һ��Hashtable��������ΪContext���ó�ʼ������
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, 
			"com.sun.jndi.fscontext.RefFSContextFactory");
		env.put(Context.PROVIDER_URL, "file:/G:/publish");
		Context ctx = new InitialContext(env);
		//�������ֲ��Ҷ���
		Object file = ctx.lookup(fileName);
		System.out.println(fileName+ " ���Ʊ��󶨵�: "
			+ file);
		System.out.println("file�������ǣ�" + file.getClass());
		//�������ֲ��Ҷ���
		Object dir = ctx.lookup(dirName);
		System.out.println(dirName + " ���Ʊ��󶨵�: "
			+ dir);
		System.out.println("dir�������ǣ�" + dir.getClass());
		//�رո�Context
		ctx.close();
	}
}
