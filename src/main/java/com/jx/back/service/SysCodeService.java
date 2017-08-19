package com.jx.back.service;

import com.jx.back.entity.SysCode;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014年10月9日
 */
public interface SysCodeService {
	public List<SysCode> find(Map paraMap);			//带条件查询，条件可以为null，既没有条件；返回list对象集合
}
