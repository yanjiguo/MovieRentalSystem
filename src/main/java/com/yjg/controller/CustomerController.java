package com.yjg.controller;

import com.yjg.service.CustomerService;
import com.yjg.vo.AddressListVO;
import com.yjg.vo.CustomerVO;
import com.yjg.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/27
 *  @Description: 处理对客户信息操作请求
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    /**
     *跳转到index页面
     * @param model
     * @return
     */
    @RequestMapping("/customerIndex")
    public String showIndexPage(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("username")!=null){
            List<AddressListVO> all =  customerService.selectAddressList();
            model.addAttribute("all",all);
            return "index";
        }else{
            return "redirect:/";
        }
    }
    /**
     *查询客户的所有信息并且分页
     * @param pageNow
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/customerList")
    public Result selectAllCustomers(@RequestParam("pageNow") int pageNow,@RequestParam("limit") int limit){
            Result result = null;
            if(pageNow>0&&limit>0){
                result = customerService.selectAllCustomInfo(pageNow, limit);
            }else{
                result.setCode(500101);
                result.setMsg("参数校验异常");
            }
            return result;
    }

    /**
     * 删除客户
     * @param customerId
     * @return
     */
    @ResponseBody
    @RequestMapping("/customerDeleteByCusId")
    public int deleteCustomerById(@RequestParam("customerId") int customerId){
        int msg ;
        if(customerId>0){
            msg = customerService.deleteCustomerById(customerId);
            if(msg==1){
                return msg;
            }else{
                return  msg;
            }
        }else{
            return -1;
        }
    }

    /**
     * 更新客户
     * @param customerVO
     * @return
     */
    @ResponseBody
    @RequestMapping("/customerUpdateByCusId")
    public int updateCustomerById(CustomerVO customerVO){
        int msg = -1;
        if(customerVO != null){
            msg = customerService.updateCustomerById(customerVO);
            if(msg==1){
                return msg;
            }else{
                return msg;
            }
        }
        System.out.println(msg);
        return msg;
    }

    /**
     * 跳转到新建页面
     * @return
     */
    @RequestMapping("/newCustomer")
    public String showNewCustomer(Model model,HttpServletRequest request){
        if(request.getSession().getAttribute("username")!=null){
            List<AddressListVO> all =  customerService.selectAddressList();
            model.addAttribute("all",all);
            return "newCustomer";
        }else{
            return "redirect:/";
        }
    }
    /**
     * 添加客户
     * @param customerVO
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/addCustomer")
    public int addCustomer(CustomerVO customerVO) {
        int msg = -1;
        if (customerVO != null) {
            msg = customerService.addCustomer(customerVO);
            if (msg == 1) {
                System.out.println(msg);
                return msg;
            } else {
                System.out.println(msg);
                return msg;
            }
        } else {
            System.out.println(msg);
            return msg;
        }
    }

    /**
     * 点击customer管理跳转到index
     * @param model
     * @return
     */
    @RequestMapping("/customIndex")
    public String showIndex(Model model){
        List<AddressListVO> all =  customerService.selectAddressList();
        model.addAttribute("all",all);
        return "index";
    }
}
