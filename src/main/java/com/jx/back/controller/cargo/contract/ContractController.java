package com.jx.back.controller.cargo.contract;

import com.jx.back.controller.BaseController;
import com.jx.back.entity.Contract;
import com.jx.back.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ContractController extends BaseController{
    @Resource
    ContractService contractService;

    @RequestMapping("/cargo/contract/list.action")
    public String list(Model model){
        List<Contract> dataList = contractService.find(null);
        model.addAttribute("dataList",dataList);
        return "/cargo/contract/jContractList.jsp";
    }


    @RequestMapping("/cargo/contract/tocreate.action")
    public String tocreate(){

        return "/cargo/contract/jContractCreate.jsp";
    }

    @RequestMapping("/cargo/contract/insert.action")
    public String insert(Contract contract){
        contractService.insert(contract);
        return "redirect:/cargo/contract/list.action";
    }

    @RequestMapping("/cargo/contract/toupdate.action")
    public String toupdate(String id,Model model){
        Contract obj =  contractService.get(id);
        model.addAttribute("obj",obj);
        return "/cargo/contract/jContractUpdate.jsp";
    }

    @RequestMapping("/cargo/contract/update.action")
    public String update(Contract contract){
        contractService.update(contract);
        return "redirect:/cargo/contract/list.action";
    }

    @RequestMapping("/cargo/contract/delete.action")
    public String delete(String[] id){
        contractService.delete(id);
        return "redirect:/cargo/contract/list.action";
    }

    @RequestMapping("/cargo/contract/toview.action")
    public String toview(String id,Model model){
        Contract obj = contractService.get(id);
        model.addAttribute("obj",obj);
        return "/cargo/contract/jContractView.jsp";
    }

    //上报
    @RequestMapping("/cargo/contract/submit.action")
    public String submit(String[] id){
        contractService.submit(id);
        return "redirect:/cargo/contract/list.action";
    }

    //取消
    @RequestMapping("/cargo/contract/cancel.action")
    public String cancel(String[] id){
        contractService.cancel(id);
        return "redirect:/cargo/contract/list.action";
    }

}
