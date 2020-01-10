package cn.itcast.service;

import cn.itcast.domain.shopCart;

import java.util.List;

public interface shopCartService {
    void add(Integer id,String cover, String name, Double price, Integer amount, Double total,Integer userId);

    List<shopCart> findAll1(Integer id);

    List<shopCart> findAll();

    shopCart findById(Integer id);

    void update(Integer id, Integer amount, Double total);

    List<shopCart> findByUserId(Integer userId);

    int findCount(Integer id);

    void delete(Integer id,Integer userId);

    double findtotalById(Integer id,Integer userId);

    shopCart findByBookIduserId(Integer bookId, Integer userId);

    void incress(Integer id);

    void reduce(Integer id);

    void delete1(Integer id);
}
