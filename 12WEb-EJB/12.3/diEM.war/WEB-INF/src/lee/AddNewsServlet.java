package lee;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.annotation.*;
import javax.transaction.*;
import javax.naming.*;

import org.crazyit.model.*;

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
public class AddNewsServlet extends HttpServlet
{
	//��������ע��ķ�ʽע��EntityManager
	@PersistenceContext(unitName="newsUnit")
	private EntityManager em;
	//����ע�����������JTA����
	@Resource
	private UserTransaction tx;	
	public void service(HttpServletRequest request
		, HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("GBK");
		//��ȡ�������
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//����ʵ�����
		News news = new News();
		news.setTitle(title);
		news.setContent(content);
		try
		{
			tx.begin();
			//�־û�Newsʵ��
			em.persist(news);
			tx.commit();
			PrintStream out = new PrintStream(response.getOutputStream());
			out.println("<h3>��Ϣ��ӳɹ���</h3>");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}