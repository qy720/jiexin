package com.jx.back.dao.impl;

import com.jx.back.dao.ExtCProductDao;
import com.jx.back.entity.ExtCproduct;
import org.springframework.stereotype.Repository;


/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
@Repository
public class ExtCProductDaoImpl extends BaseDaoImpl<ExtCproduct> implements ExtCProductDao{
	public ExtCProductDaoImpl() {
		//设置命名空间
		super.setNs("mapping.ExtCproductMapper");
	}

}
