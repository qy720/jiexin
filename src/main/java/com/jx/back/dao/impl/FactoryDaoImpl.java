package com.jx.back.dao.impl;

import java.util.Map;

import com.jx.back.dao.FactoryDao;
import com.jx.back.entity.Factory;
import org.springframework.stereotype.Repository;


/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
@Repository
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao{
	public FactoryDaoImpl() {
		//设置命名空间
		super.setNs("mapping.FactoryMapper");
	}

	public void updateState(Map map) {
		super.getSqlSession().update(super.getNs()+".updateState",map);
	}
}
