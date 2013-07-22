package org.crazyit.model;

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
public class AddressPk
	implements java.io.Serializable
{
	private String zip;
	private String phone;

	//�޲����Ĺ�����
	public AddressPk()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public AddressPk(String zip , String phone)
	{
		this.zip = zip;
		this.phone = phone;
	}

	//zip���Ե�setter��getter����
	public void setZip(String zip)
	{
		this.zip = zip;
	}
	public String getZip()
	{
		return this.zip;
	}

	//phone���Ե�setter��getter����
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getPhone()
	{
		return this.phone;
	}
	//��дequals����
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj.getClass() == AddressPk.class)
		{
			AddressPk target = (AddressPk)obj;
			if (target.getZip().equals(zip)
				&& target.getPhone().equals(phone))
			{
				return true;
			}
		}
		return false;
	}
	//��дhashCode����
	public int hashCode()
	{
		return zip.hashCode() * 17
			+ phone.hashCode();
	}

}