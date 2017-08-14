package com.jx.back.service.impl;

import com.jx.back.dao.ExtCProductDao;
import com.jx.back.entity.ExtCproduct;
import com.jx.back.service.ExtCProductService;
import com.jx.back.utils.Page;
import com.jx.back.utils.UtilFuns;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ExtCProductServiceImpl implements ExtCProductService {

    @Resource
    ExtCProductDao extCProductDao;


    public List<ExtCproduct> findPage(Page page) {
        return extCProductDao.findPage(page);
    }

    public List<ExtCproduct> find(Map paraMap) {
        return extCProductDao.find(paraMap);
    }

    public ExtCproduct get(Serializable id) {
        return extCProductDao.get(id);
    }


    public void insert(ExtCproduct extCProduct) {
        extCProduct.setId(UUID.randomUUID().toString());
        //计算总金额
        if(UtilFuns.isNotEmpty(extCProduct.getCnumber()) && UtilFuns.isNotEmpty(extCProduct.getPrice())){
            extCProduct.setAmount(extCProduct.getCnumber()*extCProduct.getPrice());
        }
        extCProductDao.insert(extCProduct);
    }

    public void update(ExtCproduct extCProduct) {
        extCProductDao.update(extCProduct);
    }

    public void deleteById(Serializable id) {
        extCProductDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        extCProductDao.delete(ids);
    }


}
