package org.crazyit.auction.jsf.listener;

import javax.faces.event.*;
import javax.faces.context.*;
import javax.faces.application.*;

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
public class LoggedInCheck implements PhaseListener
{ 
	public PhaseId getPhaseId()
	{ 
		return PhaseId.RESTORE_VIEW; 
	} 
	public void beforePhase(PhaseEvent event)
	{ 
	} 
	public void afterPhase(PhaseEvent event)
	{ 
		FacesContext fc = event.getFacesContext(); 
		//��login.jspҳ�治�����
		boolean loginPage = fc.getViewRoot()
			.getViewId().lastIndexOf("login.jsp") 
			> -1 ? true : false; 
		//��main.jspҳ�治�����
		boolean mainPage = fc.getViewRoot()
			.getViewId().lastIndexOf("main.jsp") 
			> -1 ? true : false; 
		//ֻ�Ժ�׺��jsp��������м��
		boolean jspSuffix = fc.getViewRoot()
			.getViewId().lastIndexOf(".jsp") 
			> -1 ? true : false; 
		if (!loginPage && !mainPage && !loggedIn(fc) && jspSuffix) 
		{ 
			NavigationHandler nh = fc.getApplication()
				.getNavigationHandler(); 
			nh.handleNavigation(fc, null, "logout"); 
		} 
	} 
	//��֤�Ƿ��Ѿ���¼
	private boolean loggedIn(FacesContext fc) 
	{
		//��ȡsession��user����
		Object user = fc.getExternalContext().getSessionMap()
			.get("userId");
		//���session��Χ��user���Դ��ڣ��������û��Ѿ���¼��
		if (user != null
			&& user.toString().length() > 0)
		{
			return true;
		}
		return false;
	} 
}
