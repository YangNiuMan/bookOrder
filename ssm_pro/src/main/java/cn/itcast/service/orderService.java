package cn.itcast.service;

import cn.itcast.domain.Order;

import java.util.List;

public interface orderService {

    public List<Order> findAll(int page,int pagesize);



    Order findById(Integer id);

    int findTotal();
}
