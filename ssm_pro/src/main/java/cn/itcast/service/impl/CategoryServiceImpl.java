package cn.itcast.service.impl;

import cn.itcast.dao.categoryDao;
import cn.itcast.domain.Category;
import cn.itcast.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private categoryDao dao;

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public Category findByLbId(Integer id) {
        return dao.findByLbId(id);
    }

    @Override
    public void update(Integer id, String name) {
        dao.update(id,name);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

    @Override
    public void add(String name) {
        dao.add(name);
    }
}
