package org.crazyit.jsf;

import javax.faces.component.html.*;
import javax.faces.event.*;
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
public class RegistBean 
{
	private String name;
	private String pass;
	//��UI������������

	private HtmlOutputText tip;




	//�޲����Ĺ�����
	public RegistBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public RegistBean(String name 
		, String pass , HtmlOutputText tip)
	{
		this.name = name;
		this.pass = pass;
		this.tip = tip;
	}

	//name���Ե�setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	//pass���Ե�setter��getter����
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}

	//tip���Ե�setter��getter����
	public void setTip(HtmlOutputText tip)
	{
		this.tip = tip;
	}
	public HtmlOutputText getTip()
	{
		return this.tip;
	}
	
	public void judgeName(ValueChangeEvent ve)
	{
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