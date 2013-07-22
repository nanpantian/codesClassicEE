package org.crazyit.jsf;

import javax.faces.component.html.*;
import javax.faces.event.*;
import javax.faces.context.FacesContext;
import javax.faces.component.*;
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
public class CrazyValueChangeListener
	implements ValueChangeListener
{
	public void processValueChange(ValueChangeEvent ve) 
	{
		FacesContext context =
			FacesContext.getCurrentInstance();
		//��ȡJSFҳ����<f:view.../>Ԫ��
		UIViewRoot viewRoot = context.getViewRoot();
		//ͨ��ID��ȡ<f:view.../>�ڵ�<h:form.../>��Ԫ�ء�
		UIComponent comp = viewRoot.findComponent("registForm");
		//ͨ��ID��ȡ<h:form.../>�ڵ�<h:outputText.../>��Ԫ�ء�
		UIOutput tip = (UIOutput)comp.findComponent("tip");
		//ʹ��һ���ַ�������ģ�����ݿ����Ѵ��ڵ��û���
		String[] existNames = 
		{
			"crazyit.org",
			"leegang.org",
			"crazyit"
		};
		//��ȡ�û��������ֵ
		String name = ve.getNewValue().toString();
		for (int i = 0 ; i < existNames.length ; i++)
		{
			//����û�������û��������ݿ����Ѵ����û���
			if (existNames[i].equals(name))
			{
				tip.setValue(name + "�û����Ѿ����ڣ�");
				//��tip�����ʾ������
				tip.setRendered(true);
				return;
			}
		}
		tip.setValue("��ϲ����"+ name + "�û������ã�");
		//��tip�����ʾ������
		tip.setRendered(true);
	}
}
