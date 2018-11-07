package com.itheima.web;

import com.itheima.domain.Account;
import com.itheima.domain.Result;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by crowndint on 2018/11/4.
 */
@RestController
@RequestMapping("account")
public class AccountJsonDataController {

    @Autowired
    private IAccountService accountService;

    /*
        @ModelAttribute注解配置作用，当用户提交表单的时候，会先获取请求参数id,从数据库查询数据
        ，来填充下面的update方法的的请求参数Account对象，
        注意：只能填充浏览器没有该请求参数的属性
     */
    @ModelAttribute
    public Account findById(Integer id) {

        Account account = accountService.findById(id);
        System.out.println("findById--->"+account);
        return account;
    }

    @RequestMapping("update")
    public Result update(Account account) {
        System.out.println("update--->"+account);
        accountService.update(account);
        return new Result(true, "更新成功");
    }


    @RequestMapping("add")
    public Result add(Account account) {

        accountService.add(account);
        return new Result(true, "添加成功");
    }

    @RequestMapping("addJsonParam")
    public Result addJsonParam(@RequestBody Account account) {

        accountService.add(account);
        return new Result(true, "添加成功");
    }



}
