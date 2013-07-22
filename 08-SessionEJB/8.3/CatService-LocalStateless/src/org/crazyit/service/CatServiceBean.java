package org.crazyit.service;

import java.util.*;
import javax.ejb.*;

import org.crazyit.business.*;

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
@Stateless(mappedName="CatService")
public class CatServiceBean 
	implements CatService
{
	static Map<Person , Cat[]> catsInfo;
	static 
	{
		catsInfo = new HashMap<Person , Cat[]>();
		catsInfo.put(new Person(1 , "�����")
			, new Cat[]{
				new Cat("Kitty" , 2),
				new Cat("Garfield" , 4),
		});
		catsInfo.put(new Person(2 , "��˽�")
			, new Cat[]{
				new Cat("Tom" , 2),
				new Cat("����è" , 4),
		});
	}
	public Cat[] getCats(Person owner)
	{
		return catsInfo.get(owner);
	}
}
