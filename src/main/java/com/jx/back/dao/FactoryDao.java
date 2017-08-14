package com.jx.back.dao;

import java.util.Map;

import com.jx.back.entity.Factory;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
public interface FactoryDao extends BaseDao<Factory> {
    public void updateState(Map map);
}
