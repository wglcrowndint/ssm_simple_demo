package com.itheima.dao;

import com.itheima.domain.Items;

import java.util.List;

public interface ItemsDao {
    public Items findById(Integer id);
    public List<Items> findAll();
}
