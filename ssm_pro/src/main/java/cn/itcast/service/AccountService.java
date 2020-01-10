package cn.itcast.service;

import cn.itcast.domain.product;

import java.util.List;

public interface AccountService {


    public List<product> findAll(int page,int pageSize);

    public void SaveAccount(product pro);
}
