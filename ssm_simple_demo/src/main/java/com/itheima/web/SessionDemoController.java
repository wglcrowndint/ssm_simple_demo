package com.itheima.web;

import com.itheima.domain.Account;
import com.itheima.domain.Result;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by crowndint on 2018/11/4.
 */
@Controller
@RequestMapping("demo")
//把request域key为acc的对象存放到session域
@SessionAttributes(value = "acc", types = Account.class)
public class SessionDemoController {

    @Autowired
    private IAccountService accountService;


    @RequestMapping("findById")
    public String findById(Integer id, Model model) {

        Account account = accountService.findById(id);
        System.out.println("findById--->"+account);
        model.addAttribute("acc", account);
        return "/success.jsp";
    }

    //从session域获取数据
    @RequestMapping("findFromSession")
    @ResponseBody
    public Account findById(ModelMap modelMap) {

        Account account = (Account) modelMap.get("acc");
        System.out.println(account);

        return account;
    }

    //清除session数据
    @RequestMapping(value="delSession")
    public String delSessionAttributes(SessionStatus status){
        status.setComplete();
        return "/success.jsp";
    }




}
