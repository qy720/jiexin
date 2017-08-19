package com.jx.back.service.impl;

import com.jx.back.dao.SysCodeDao;
import com.jx.back.entity.SysCode;
import com.jx.back.service.SysCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SysCodeServiceImpl implements SysCodeService {

    @Resource
    SysCodeDao sysCodeDao;

    public List<SysCode> find(Map paraMap) {
        return sysCodeDao.find(paraMap);
    }
}
