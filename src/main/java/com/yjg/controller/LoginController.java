package com.yjg.controller;

import com.yjg.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/27
 *  @Description: 处理对登录的处理
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/")
    public String showLoginPage(){
        return "login";
    }

    /**
     * 判断登录是否成功
     * @param username
     * @param password
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("customerLogin")
    public String login(String username, String password, Model model,HttpServletRequest request){
        if(username!="" &&username!=null){
            int i = loginService.selectCustomerByName(username);
            if(i==1){
                //如果成功将用户名保存在session中
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                return "redirect:/customerIndex";
            }else{
                model.addAttribute("str","用户名或密码错误");
                return "login";
            }
        }else{
            model.addAttribute("str","请输入用户或密码");
            return "login";
        }
    }

    /**
     * 退出系统
     * @param request
     * @return
     */
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        HttpSession session = request.getSession();
        //清除session中的所有信息
        session.removeAttribute("username");
        return "login";
    }
}
