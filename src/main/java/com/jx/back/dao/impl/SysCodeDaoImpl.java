package com.jx.back.dao.impl;

import com.jx.back.dao.SysCodeDao;
import com.jx.back.entity.SysCode;
import org.springframework.stereotype.Repository;

@Repository
public class SysCodeDaoImpl extends BaseDaoImpl<SysCode> implements SysCodeDao {
    public SysCodeDaoImpl() {
        //设置命名空间
        super.setNs("mapping.SysCodeMapper");
    }
}
