package cn.itcast.service.impl;

import cn.itcast.dao.shopCartDao;
import cn.itcast.domain.shopCart;
import cn.itcast.service.shopCartService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopCartService")
public class shopCartServiceImpl implements shopCartService {

    @Autowired
    private shopCartDao dao;

    @Override
    public void add(Integer id,String cover, String name, Double price, Integer amount, Double total,Integer userId) {
        dao.add(id,cover,name,price,amount,total,userId);
    }

    @Override
    public List<shopCart> findAll1(Integer id) {

        return dao.findAll1(id);
    }

    @Override
    public List<shopCart> findAll() {
        return dao.findAll();
    }

    @Override
    public shopCart findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public void update(Integer id, Integer amount, Double total) {
        dao.update(id,amount,total);
    }

    @Override
    public List<shopCart> findByUserId(Integer userId) {
        return dao.findByUserId(userId);
    }

    @Override
    public int findCount(Integer id) {
        return dao.findCount(id);
    }

    @Override
    public void delete(Integer id,Integer userId) {
        dao.delete(id,userId);
    }

    @Override
    public double findtotalById(Integer id,Integer userId) {
        return dao.findtotalById(id,userId);
    }

    @Override
    public shopCart findByBookIduserId(Integer bookId, Integer userId) {
        return dao.findByBookIduserId(bookId,userId);
    }

    @Override
    public void incress(Integer id) {
        dao.incress(id);
    }

    @Override
    public void reduce(Integer id) {
        dao.reduce(id);
    }

    @Override
    public void delete1(Integer id) {
        dao.delete1(id);
    }
}
