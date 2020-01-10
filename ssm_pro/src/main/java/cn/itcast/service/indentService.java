package cn.itcast.service;

import cn.itcast.domain.Indent;

import java.util.Date;
import java.util.List;

public interface indentService {
    void save(String name, String phone, String address, Double total, Date systime, Integer status,Integer userId);

    List<Indent> untreated(Integer page, Integer pageSize);

    int findTotal();

    int findTotal1();

    List<Indent> treated(Integer page, Integer pageSize);

    void update(Integer id);

    List<Indent> findAll(Integer id);

    void delete(Integer id);
}
