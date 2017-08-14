package com.jx.back.controller.cargo.contract;

import com.jx.back.controller.BaseController;
import com.jx.back.entity.ExtCproduct;
import com.jx.back.entity.Factory;
import com.jx.back.service.ExtCProductService;
import com.jx.back.service.FactoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExtCproductController extends BaseController {
    @Resource
    ExtCProductService extCProductService;
    @Resource
    FactoryService factoryService;

    @RequestMapping("/cargo/extcproduct/tocreate.action")
    public String tocreate(String contractProductId, Model model){
        model.addAttribute("contractProductId",contractProductId);//传递主表id
        //准备数据
        Map paraMap = new HashMap();
        paraMap.put("contractProductId",contractProductId);
        List<ExtCproduct> dataList= extCProductService.find(paraMap);
        model.addAttribute("dataList",dataList);
        //生产厂家
        List<Factory> factoryList = factoryService.getFactoryList();
        model.addAttribute("factoryList",factoryList);

        return "/cargo/contract/jExtCproductCreate.jsp";
    }

    @RequestMapping("/cargo/extcproduct/insert.action")
    public String insert(ExtCproduct extCProduct, Model model){
        extCProductService.insert(extCProduct);
        model.addAttribute("contractProductId",extCProduct.getContractProductId());
        return "redirect:/cargo/extcproduct/tocreate.action";
    }
}
