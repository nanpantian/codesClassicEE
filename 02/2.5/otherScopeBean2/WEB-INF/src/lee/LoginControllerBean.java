package lee;
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
public class LoginControllerBean
{
	private UserBean user;
	private LoginBackBean backBean;
	//user���Ե�setter��getter����
	public void setUser(UserBean user)
	{
		this.user = user;
	}
	public UserBean getUser()
	{
		return this.user;
	}

	//backBean���Ե�setter��getter����
	public void setBackBean(LoginBackBean backBean)
	{
		this.backBean = backBean;
	}
	public LoginBackBean getBackBean()
	{
		return this.backBean;
	}
	//�÷������󶨵�UI�������ť����action����
	public String valid()
	{
		if (backBean.getName().equals("crazyit") 
			&& backBean.getPass().equals("leegang"))
		{
			//����ʵ����Ӧ�ô����ݿ��ȡ���û���״̬��Ϣ
			getUser().setName("���Java");
			getUser().setGender("��");
			return "success";
		}
		backBean.setErr("�����û��������벻����");
		return "failure";
	}
}