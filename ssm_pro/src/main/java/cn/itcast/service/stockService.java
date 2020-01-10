package cn.itcast.service;

import cn.itcast.domain.stock;

import java.util.List;

public interface stockService {
    
    
    List<stock> findAll(int page,int pageSize);

    int findTotal();

    stock findById(String id);

    void update(Integer id, Integer number);
}
