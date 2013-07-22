package org.crazyit.auction.service.impl;

import org.apache.log4j.Logger;

import java.util.*;
import javax.ejb.*;
import javax.annotation.*;
import javax.jms.*;

import org.crazyit.auction.eao.*;
import org.crazyit.auction.model.*;
import org.crazyit.auction.exception.AuctionException;
import org.crazyit.auction.service.AuctionManager;

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
//���������������������
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Stateless(name="auctionManager")
public class AuctionManagerImpl implements AuctionManager
{
	static Logger log = Logger.getLogger(
		AuctionManagerImpl.class.getName());
	//�����Ǹ�ҵ���߼������������EAO���
	@EJB(beanName="auctionUserEao")
	private AuctionUserEao userEao;
	@EJB(beanName="bidEao")
	private BidEao bidEao;
	@EJB(beanName="itemEao")
	private ItemEao itemEao;
	@EJB(beanName="kindEao")
	private KindEao kindEao;
	@EJB(beanName="stateEao")
	private StateEao stateEao;
	//����������Դ�Ƿ���JMS��Ϣ�������Դ
	@Resource(mappedName="AuctionQueue")
	private Destination dest;
	@Resource(mappedName="ConnectionFactory")
	private ConnectionFactory connFactory;
	/**
	 * ����Ӯȡ�߲�ѯ��Ʒ
	 * @param winerId Ӯȡ�ߵ�ID
	 * @return Ӯȡ�߻�õ�ȫ����Ʒ
	 */
	public List<Item> getItemByWiner(Integer winerId) throws AuctionException
	{
		try
		{
			return itemEao.findItemByWiner(winerId);
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("��ѯ�û���Ӯȡ����Ʒ�����쳣,������");
		}
	}

	/**
	 * ��ѯ���ĵ�ȫ����Ʒ
	 * @return ȫ��������Ʒ
	 */
	public List<Item> getFailItems() throws AuctionException
	{
		try
		{
			return itemEao.findItemByState(3);
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("��ѯ������Ʒ�����쳣,������");
		}
	}

	/**
	 * �����û�����������֤��¼�Ƿ�ɹ�
	 * @param username ��¼���û���
 	 * @param pass ��¼������
	 * @return ��¼�ɹ������û�ID�����򷵻�-1
	 */
	public int validLogin(String username , String pass) throws AuctionException
	{
		try
		{
			AuctionUser u = userEao.findUserByNameAndPass(username , pass);
			if (u != null)
			{
				return u.getId();
			}
			return -1;
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("�����û���¼�����쳣,������");
		}
	}

	/**
	 * ��ѯ�û���ȫ������
	 * @param userId �����û���ID
	 * @return �û���ȫ������
	 */
	public List<Bid> getBidByUser(Integer userId) throws AuctionException
	{
		try
		{
			return bidEao.findByUser(userId);
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("����û���ȫ�����۳����쳣,������");
		}
	}

	/**
	 * �����û�����Ŀǰ���������е�ȫ����Ʒ
	 * @param userId �����ߵ�ID
	 * @return ���ڵ�ǰ�û��ġ����������е�ȫ����Ʒ��
	 */
	public List<Item> getItemsByOwner(Integer userId) throws AuctionException
	{
		try
		{
			return itemEao.findItemByOwner(userId);
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("��ѯ�û����е���Ʒ�����쳣,������");
		}
	}

	/**
	 * ��ѯȫ������
	 * @return ϵͳ��ȫ��ȫ������
	 */   
	public List<Kind> getAllKind() throws AuctionException
	{
		try
		{
			return kindEao.findAll();
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("��ѯȫ����������쳣,������");
		}
	}

	/**
	* �����Ʒ
	* @param name ��Ʒ����
	* @param desc ��Ʒ����
	* @param remark ��Ʒ��ע
	* @param avail ��Ч����
	* @param kind ��Ʒ����
	* @param userId ����ߵ�ID
	* @return ������Ʒ������
	*/
	public int addItem(String name , String desc , String remark ,
		double initPrice , int avail , int kindId , Integer userId)
		throws AuctionException
	{
		try
		{
			Kind k = kindEao.get(Kind.class , kindId);
			AuctionUser owner = userEao.get(AuctionUser.class , userId);
			//����Item����
			Item item = new Item();
			item.setItemName(name);
			item.setItemDesc(desc);
			item.setItemRemark(remark);
			item.setAddtime(new Date());
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE , avail);
			item.setEndtime(c.getTime());
			item.setInitPrice(initPrice);
			item.setMaxPrice(initPrice);
			item.setItemState(stateEao.get(State.class , 1));
			item.setKind(k);
			item.setOwner(owner);
			//�־û�Item����
			itemEao.save(item);
			return item.getId();
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("�����Ʒ�����쳣,������");
		}
	}

	/**
	 * �������
	 * @param name ��������
	 * @param desc ��������
	 * @return �������������
	 */ 
	public int addKind(String name , String desc)
		throws AuctionException
	{
		try
		{
			Kind k = new Kind();
			k.setKindName(name);
			k.setKindDesc(desc);
			kindEao.save(k);
			return k.getId();
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("�����������쳣,������");
		}
	}

	/**
	 * ���ݲ�Ʒ���࣬��ȡ���������е�ȫ����Ʒ
	 * @param kindId ����id;
	 * @return �����ȫ����Ʒ
	 */
	public List<Item> getItemsByKind(int kindId) throws AuctionException
	{
		try
		{
			return itemEao.findItemByKind(kindId);
		}
		catch (Exception e)
		{
			log.debug(e.getMessage());
			throw new AuctionException("���������ȡ��Ʒ�����쳣,������");
		}
	}

	/**
	 * ��������id��ȡ������
	 * @param kindId ����id;
	 * @return �����������
	 */
	public String getKind(int kindId) throws AuctionException
	{
		try
		{
			Kind  k = kindEao.get(Kind.class , kindId);
			if (k != null)
			{
				return k.getKindName();
			}
			return null;
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("��������id��ȡ�������Ƴ����쳣,������");
		}
	}

	/**
	 * ������Ʒid����ȡ��Ʒ
	 * @param itemId ��Ʒid;
	 * @return ָ��id��Ӧ����Ʒ
	 */
	public Item getItem(int itemId)
		throws AuctionException
	{
		try
		{
			return itemEao.get(Item.class, itemId);
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("������Ʒid��ȡ��Ʒ��ϸ��Ϣ�����쳣,������");
		}
	}

	/**
	 * �����µľ��ۣ����Ծ����û����ʼ�֪ͨ
	 * @param itemId ��Ʒid;
	 * @param bidPrice ���ۼ۸�
	 * @param userId �����û���ID
	 * @return �����������ۼ�¼��ID
	 */
	public int addBid(int itemId , double bidPrice , Integer userId)
		throws AuctionException
	{
		try
		{
			AuctionUser au = userEao.get(AuctionUser.class , userId);
			Item item = itemEao.get(Item.class , itemId);
			if (bidPrice > item.getMaxPrice())
			{
				item.setMaxPrice(bidPrice);
				itemEao.save(item);
			}
			//��ʼ��Bid����
			Bid bid = new Bid();
			bid.setBidItem(item);
			bid.setBidUser(au);
			bid.setBidDate(new Date());
			bid.setBidPrice(bidPrice);
			//�־û�Bid����
			bidEao.save(bid);

			//���ӹ�����������
			Connection conn = connFactory.createConnection();
			//JMS���Ӵ���JMS�Ự
			Session session = conn.createSession(false/*���������ԻỰ*/
				, Session.AUTO_ACKNOWLEDGE);
			//JMS�Ự������Ϣ������
			MessageProducer sender = session.createProducer(dest);
			//������Ϣ������������������Ϣ�Ĵ���ģʽ����Чʱ�䡣
			sender.setDeliveryMode(DeliveryMode.PERSISTENT);
			sender.setTimeToLive(20000);
			//ͨ��JMS�Ự����һ��MapMessage
			MapMessage msg = session.createMapMessage();
			//������Ϣ����
			msg.setString("mailTo" , au.getEmail());
			msg.setString("bidUser" , au.getUsername());
			msg.setString("itemName" , item.getItemName());
			//������Ϣ
			sender.send(msg);
			//�ر���Դ
			session.close();
			conn.close();

			return bid.getId();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			log.debug(ex.getMessage());
			throw new AuctionException("�����û����۳����쳣,������");
		}
	}

	/**
	 * ����ʱ�����޸���Ʒ��״̬��Ӯȡ��
	 */
	public void updateWiner()
		throws AuctionException
	{
		try
		{
			List<Item> itemList = itemEao.findItemByState(1);
			for (int i = 0 ; i < itemList.size() ; i++ )
			{
				Item item = itemList.get(i);
				if (!item.getEndtime().after(new Date()))
				{
					//����ָ����Ʒ����߾�������ѯ�û�
					AuctionUser au = bidEao.findUserByItemAndPrice(
						item.getId() , item.getMaxPrice());
					//�������Ʒ����߾����߲�Ϊnull
					if (au != null)
					{
						//���þ�������ΪӮȡ��
						item.setWiner(au);
						//�޸���Ʒ��״̬��Ϊ����Ӯȡ��
						item.setItemState(stateEao.get(State.class , 2));
						itemEao.save(item);
					}
					else
					{
						//���ø���Ʒ��״̬Ϊ�����ġ�
						item.setItemState(stateEao.get(State.class , 3));
						itemEao.save(item);
					}
				}
			}
		}
		catch (Exception ex)
		{
			log.debug(ex.getMessage());
			throw new AuctionException("�����Ʒ�Ƿ񳬹�����ʱ������쳣,������");
		}
	}
}