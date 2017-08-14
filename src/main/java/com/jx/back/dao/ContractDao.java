package com.jx.back.dao;

import com.jx.back.entity.Contract;

import java.util.Map;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
public interface ContractDao extends BaseDao<Contract> {
    public void updateState(Map map);
}
