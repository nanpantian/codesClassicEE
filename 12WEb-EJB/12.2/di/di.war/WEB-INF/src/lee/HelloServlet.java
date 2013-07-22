package lee;

import javax.ejb.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import org.crazyit.service.*;
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
public class HelloServlet extends HttpServlet
{
	//ָ�����ڲ���ʶ��Ϊhello��EJBע�뵽��Field��
	@EJB(beanName="hello")
	private Hello hello;
	public void service(HttpServletRequest request
		, HttpServletResponse response)
		throws IOException , ServletException
	{
		//��ȡ�������
		String name = request.getParameter("name");
		if (name == null || name.equals(""))
		{
			name = "δ��¼�û�";
		}
		//����Session Bean��ҵ�񷽷�
		String resultStr = hello.hello(name);
		//����ҳ�������
		PrintStream ps = new PrintStream(response.getOutputStream());
		//������EJB�Ľ��������ͻ���
		ps.println(resultStr);
	}
}