package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * Created by crowndint on 2018/11/10.
 */
public interface UserDao {

    public List<User> findAll();
}
