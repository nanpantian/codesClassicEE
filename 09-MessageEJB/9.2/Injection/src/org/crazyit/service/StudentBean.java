package org.crazyit.service;

import java.sql.*;
import javax.sql.*;
import javax.ejb.*;
import javax.annotation.*;
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
@Stateless(name="StudentBean")
public class StudentBean
	implements Student
{
	//��������ע���ȡ����Դ
	@Resource(name="javaee")
	private DataSource ds;
	public void add(String name , String gender 
		, int age) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			//ͨ������Դ��ȡ���ݿ�����
			conn = ds.getConnection();
			//ʹ��PreparedStatementִ��SQL���
			pstmt = conn.prepareStatement
				("insert into student values(null , ? , ? , ?)");
			pstmt.setString(1 , name);
			pstmt.setString(2 , gender);
			pstmt.setInt(3 , age);
			pstmt.executeUpdate();
		}
		finally
		{
			pstmt.close();
			conn.close();
		}
	}
}
