package cn.itcast.service;

import cn.itcast.domain.WholeSale;

import java.util.List;

public interface WholeSaleService {

    List<WholeSale> findAll(int page,int pageSize);

    int findTotal();

    void add(Integer id, String cover, String name, String producter, Integer number,Integer submit);

    void update(Integer id);

    List<WholeSale> findBySubmit(Integer page, Integer pageSize);

    List<WholeSale> findByNoSubmit(Integer page, Integer pageSize);

    int findTotal1();

    int findTotal0();

    WholeSale findByIdAndSubmit(Integer id);
}
