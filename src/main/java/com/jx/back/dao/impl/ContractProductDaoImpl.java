package com.jx.back.dao.impl;

import com.jx.back.dao.ContractDao;
import com.jx.back.dao.ContractProductDao;
import com.jx.back.entity.Contract;
import com.jx.back.entity.ContractProduct;
import org.springframework.stereotype.Repository;

import java.util.Map;


/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
@Repository
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao{
	public ContractProductDaoImpl() {
		//设置命名空间
		super.setNs("mapping.ContractProductMapper");
	}

}
