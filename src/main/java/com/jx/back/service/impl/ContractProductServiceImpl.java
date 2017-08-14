package com.jx.back.service.impl;

import com.jx.back.dao.ContractProductDao;
import com.jx.back.entity.ContractProduct;
import com.jx.back.service.ContractProductService;
import com.jx.back.utils.Page;
import com.jx.back.utils.UtilFuns;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ContractProductServiceImpl implements ContractProductService {

    @Resource
    ContractProductDao contractProductDao;


    public List<ContractProduct> findPage(Page page) {
        return contractProductDao.findPage(page);
    }

    public List<ContractProduct> find(Map paraMap) {
        return contractProductDao.find(paraMap);
    }

    public ContractProduct get(Serializable id) {
        return contractProductDao.get(id);
    }


    public void insert(ContractProduct contractProduct) {
        contractProduct.setId(UUID.randomUUID().toString());
        //计算总金额
        if(UtilFuns.isNotEmpty(contractProduct.getCnumber()) && UtilFuns.isNotEmpty(contractProduct.getPrice())){
            contractProduct.setAmount(contractProduct.getCnumber()*contractProduct.getPrice());
        }
        contractProductDao.insert(contractProduct);
    }

    public void update(ContractProduct contract) {
        contractProductDao.update(contract);
    }

    public void deleteById(Serializable id) {
        contractProductDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        contractProductDao.delete(ids);
    }


}
