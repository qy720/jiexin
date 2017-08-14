package com.jx.back.dao.impl;

import com.jx.back.dao.ContractDao;
import com.jx.back.entity.Contract;
import org.springframework.stereotype.Repository;

import java.util.Map;


/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao{
	public ContractDaoImpl() {
		//设置命名空间
		super.setNs("mapping.ContractMapper");
	}

	public void updateState(Map map) {
		super.getSqlSession().update(super.getNs()+".updateState",map);
	}
}
