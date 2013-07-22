package org.crazyit.service;

import java.util.*;
import javax.ejb.*;
import javax.annotation.*;
import javax.naming.*;

import java.sql.*;
import javax.sql.*;

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
@Stateless(mappedName="Cmt")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CmtBean 
	implements Cmt
{
	private DataSource ds = null;
	@Resource
	private SessionContext sessCtx;
	public CmtBean()
		throws NamingException
	{
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("javaee");
	}
	public void insert()
	{
		try
		{
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			int result = stmt.executeUpdate("insert into user_table "
				+ "values(null, '���û�' , 'bbb')");
			System.out.println(result);
			//����������佫����ʧ��
			stmt.executeUpdate("insert into user_table "
				+ "values(1, 'aaa' , 'bbb')");
			stmt.close();
			conn.close();			
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
			sessCtx.setRollbackOnly();
		}
	}
}
