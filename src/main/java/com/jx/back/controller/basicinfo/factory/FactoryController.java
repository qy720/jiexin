package com.jx.back.controller.basicinfo.factory;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.jx.back.controller.BaseController;
import com.jx.back.entity.Factory;
import com.jx.back.service.FactoryService;
import com.jx.back.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FactoryController extends BaseController {
	@Resource
	FactoryService factoryService;
	
	//列表
	@RequestMapping("/basicinfo/factory/list.action")
	public String list(Model model){
		List<Factory> dataList = factoryService.find(null);
		model.addAttribute("dataList", dataList);			//将数据传递到页面
		return "/basicinfo/factory/jFactoryList.jsp";		//转向页面
	}

	//转向新增页面
	@RequestMapping("/basicinfo/factory/tocreate.action")
	public String toCreate(){
		return "/basicinfo/factory/jFactoryCreate.jsp";
	}

	//新增保存
	@RequestMapping("/basicinfo/factory/insert.action")
	public String insert(Factory factory){
		factoryService.insert(factory);
		return "redirect:/basicinfo/factory/list.action";//转向列表的action
	}

	//转到新增页面
	@RequestMapping("/basicinfo/factory/toupdate.action")
	public String toUpdate(String id,Model model){
		Factory obj = factoryService.get(id);
		model.addAttribute("obj",obj);
		return "/basicinfo/factory/jFactoryUpdate.jsp";
	}

	//修改保存
	@RequestMapping("/basicinfo/factory/update.action")
	public String update(Factory factory){
		factoryService.update(factory);
		return "redirect:/basicinfo/factory/list.action";
	}

	//删除一个厂家
	@RequestMapping("/basicinfo/factory/deleteById.action")
	public String deleteById(String id){
		factoryService.deleteById(id);
		return "redirect:/basicinfo/factory/list.action";
	}

	//批量删除
	@RequestMapping("/basicinfo/factory/delete.action")
	public String delete(@RequestParam("id") String[] ids){
		factoryService.delete(ids);
		return "redirect:/basicinfo/factory/list.action";
	}
	//查看厂家信息
    @RequestMapping("/basicinfo/factory/toview.action")
    public String toview(String id,Model model){
	    Factory obj =  factoryService.get(id);
	    model.addAttribute("obj",obj);
	    return "/basicinfo/factory/jFactoryView.jsp";
    }

    //批量启用
    @RequestMapping("/basicinfo/factory/start.action")
    public String start(@RequestParam("id") String[] ids){
        factoryService.start(ids);
        return "redirect:/basicinfo/factory/list.action";
    }
    //批量停用
    @RequestMapping("/basicinfo/factory/stop.action")
    public String stop(@RequestParam("id") String[] ids){
        factoryService.stop(ids);
        return "redirect:/basicinfo/factory/list.action";
    }


    //导出Excel
    @RequestMapping("/basicinfo/factory/toExcel.action")
    public String toExcel(){
		// 初始化HttpServletResponse对象
		HttpServletResponse response = null;
    	String fileName = "厂家信息"+System.currentTimeMillis()+".xls";
        String sheetName = "厂家信息";
        String[] title = {"序号","厂家名称","简称","联系人","电话","手机","传真","验货员","排序号","备注"};
        List<Factory> dataList = factoryService.find(null);
        String[][] values = new String[dataList.size()][];
        for(int i=0;i<dataList.size();i++){
        	values[i] = new String[title.length];
        	Factory obj = dataList.get(i);
        	values[i][0] = obj.getId();
        	values[i][1] = obj.getFullName();
        	values[i][2] = obj.getFactoryName();
        	values[i][3] = obj.getContacts();
        	values[i][4] = obj.getPhone();
        	values[i][5] = obj.getMobile();
        	values[i][6] = obj.getFax();
        	values[i][7] = obj.getCnote();
		}
		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName,title,values,null);

		try {
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        return "redirect:/basicinfo/factory/list.action";
    }


}
