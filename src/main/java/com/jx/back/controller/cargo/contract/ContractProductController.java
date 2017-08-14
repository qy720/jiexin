package com.jx.back.controller.cargo.contract;

import com.jx.back.controller.BaseController;
import com.jx.back.entity.ContractProduct;
import com.jx.back.entity.Factory;
import com.jx.back.service.ContractProductService;
import com.jx.back.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ContractProductController extends BaseController{

    @Resource
    private ContractProductService contractProductService;

    @Resource
    private FactoryService factoryService;

    //转向新增页面
    @RequestMapping("/cargo/contractproduct/tocreate.action")
    public String tocreate(String contractId, Model model){ //传递主表的id
        model.addAttribute("contractId",contractId);
        //准备生产厂家的下拉列表
        List<Factory> factoryList = factoryService.getFactoryList();
        model.addAttribute("factoryList",factoryList);
        //某个合同下的货物
        Map paraMap = new HashMap();
        paraMap.put("contractId",contractId);
        List<ContractProduct> dataList = contractProductService.find(paraMap);
        model.addAttribute("dataList",dataList);
        return "/cargo/contract/jContractProductCreate.jsp";
    }

    //新增
    @RequestMapping("/cargo/contractproduct/insert.action")
    public String insert(ContractProduct contractProduct,Model model){
        model.addAttribute("contractId",contractProduct.getContractId());
        contractProductService.insert(contractProduct);
        return "redirect:/cargo/contractproduct/tocreate.action";
    }

    //转向修改页面
    @RequestMapping("/cargo/contractproduct/toupdate.action")
    public String toupdate(String id,Model model){
        //生产厂家的下拉列表
        List<Factory> factoryList = factoryService.getFactoryList();
        model.addAttribute("factoryList",factoryList);

        ContractProduct obj = contractProductService.get(id);
        model.addAttribute("obj",obj);
        return "/cargo/contract/jContractProductUpdate.jsp";
    }

    //修改保存
    @RequestMapping("/cargo/contractproduct/update.action")
    public String update(ContractProduct contractProduct){
        contractProductService.update(contractProduct);
        return "redirect:/cargo/contractproduct/tocreate.action";
    }

    //删除
    @RequestMapping("/cargo/contractproduct/deleteById.action")
    public String deleteById(String id){
        contractProductService.deleteById(id);
        return "redirect:/cargo/contractproduct/tocreate.action";
    }

}
