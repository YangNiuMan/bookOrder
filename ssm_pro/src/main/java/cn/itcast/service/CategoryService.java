package cn.itcast.service;

import cn.itcast.domain.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findByLbId(Integer id);

    void update(Integer id, String name);

    void delete(Integer id);

    void add(String name);
}
