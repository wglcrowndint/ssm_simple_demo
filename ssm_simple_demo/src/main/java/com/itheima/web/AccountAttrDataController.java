package com.itheima.web;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by crowndint on 2018/11/4.
 */
@Controller
@RequestMapping("accountList")
public class AccountAttrDataController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping("findAll")
    public String findAll(Model model) {

        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "/WEB-INF/pages/list.jsp";
    }

    @RequestMapping("findById")
    public ModelAndView findById(Integer id) {

        Account account = accountService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("account", account);
        modelAndView.setViewName("/WEB-INF/pages/edit.jsp");
        return modelAndView;
    }


    @RequestMapping("add")
    public String add(Account account) {

        accountService.add(account);
        return "redirect:findAll";
    }


    @RequestMapping("update")
    public String update(Account account) {

        accountService.update(account);
        return "redirect:findAll";
    }


    @RequestMapping("delete")
    public String delete(Integer id) {

        accountService.delete(id);
        return "redirect:findAll";
    }

}
