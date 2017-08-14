package com.jx.back.service;

import com.jx.back.entity.Contract;
import com.jx.back.utils.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
public interface ContractService {
	public List<Contract> findPage(Page page);		//分页查询
	public List<Contract> find(Map paraMap);			//带条件查询，条件可以为null，既没有条件；返回list对象集合
	public Contract get(Serializable id);			//只查询一个，常用于修改
	public void insert(Contract contract);			//插入，用实体作为参数
	public void update(Contract contract);			//修改，用实体作为参数
	public void deleteById(Serializable id);		//按id删除，删除一条；支持整数型和字符串类型ID
	public void delete(Serializable[] ids);			//批量删除；支持整数型和字符串类型ID
	
	public void submit(Serializable[] ids);			//上报
	public void cancel(Serializable[] ids);			//取消
	
	public List<Contract> getContractList();			//获取生产厂家列表
}
