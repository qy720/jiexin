package com.jx.back.service.impl;

import com.jx.back.dao.ContractDao;
import com.jx.back.entity.Contract;
import com.jx.back.service.ContractService;
import com.jx.back.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ContractServiceImpl implements ContractService {

    @Resource
    ContractDao contractDao;

    public List<Contract> findPage(Page page) {
        return contractDao.findPage(page);
    }

    public List<Contract> find(Map paraMap) {
        return contractDao.find(paraMap);
    }

    public Contract get(Serializable id) {
        return contractDao.get(id);
    }

    public void insert(Contract contract) {
        contract.setId(UUID.randomUUID().toString());
        contract.setState(0);//0草稿 1已上报
        contractDao.insert(contract);
    }

    public void update(Contract contract) {
        contractDao.update(contract);
    }

    public void deleteById(Serializable id) {
        contractDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        contractDao.delete(ids);
    }

    public void submit(Serializable[] ids) {
        Map map = new HashMap();
        map.put("state",1); //1已上报
        map.put("ids",ids);
        contractDao.updateState(map);
    }

    public void cancel(Serializable[] ids) {
        Map map = new HashMap();
        map.put("state",0); //0草稿
        map.put("ids",ids);
        contractDao.updateState(map);
    }

    public List<Contract> getContractList() {
        return null;
    }


}
