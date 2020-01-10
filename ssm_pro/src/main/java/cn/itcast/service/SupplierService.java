package cn.itcast.service;

import cn.itcast.domain.Supplier;

import java.util.List;

public interface SupplierService {


    List<Supplier> findAll(Integer page,Integer pageSize);

    int findTotal();

    Supplier findByLbId(Integer id);

    void update(Integer id, String name, String email, String address, String phoneNum, String status);

    void delete(Integer id);

    void add(String name, String email, String address, String phoneNum, String status);

    List<Supplier> search(String sous, Integer page, Integer pageSize);

    int findAllCount1(String sous);
}
