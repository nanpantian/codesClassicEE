package org.crazyit.jsf;

import javax.faces.event.ActionListener;
import javax.faces.event.ActionEvent;
import javax.faces.context.FacesContext;
import javax.faces.component.*;
import javax.faces.component.html.*;

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
public class CrazyActionListener 
	implements ActionListener
{
	//��д����Action�¼��ķ���
	public void processAction(ActionEvent event) 
	{
		//��ȡ��ǰ��FacesContext����
		FacesContext context =
			FacesContext.getCurrentInstance();
		//��ȡJSFҳ����<f:view.../>Ԫ��
		UIViewRoot viewRoot = context.getViewRoot();
		//ͨ��ID��ȡ<f:view.../>�ڵ�<h:form.../>��Ԫ�ء�
		UIComponent comp = viewRoot.findComponent("addForm");
		//ͨ��ID��ȡ<h:form.../>�ڵĵ�һ��<h:inputText.../>��Ԫ�ء�
		UIInput input = (UIInput)comp.findComponent("name");
		//ͨ��ID��ȡ<h:form.../>�ڵĵڶ���<h:inputText.../>��Ԫ�ء�
		HtmlInputText price = (HtmlInputText)comp
			.findComponent("price");
		if (input.getValue().equals("���Java����"))
		{
			price.setSize(60);
			price.setValue("99.0Ԫ");
			price.setStyle("background-color:#9999ff;"
				+ "font-weight:bold");
		}
	}
}
