package cn.itcast.service.impl;

import cn.itcast.dao.SupplierDao;
import cn.itcast.domain.Supplier;
import cn.itcast.service.SupplierService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SupplierService")
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    private SupplierDao dao;

    @Override
    public List<Supplier> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.findAll();
    }

    @Override
    public int findTotal() {
        return dao.findTotal();
    }

    @Override
    public Supplier findByLbId(Integer id) {
        return dao.findByLbId(id);
    }

    @Override
    public void update(Integer id, String name, String email, String address, String phoneNum, String status) {
        dao.update(id,name,email,address,phoneNum,status);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

    @Override
    public void add(String name, String email, String address, String phoneNum, String status) {
        dao.add(name,email,address,phoneNum,status);
    }

    @Override
    public List<Supplier> search(String sous, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.search(sous);
    }

    @Override
    public int findAllCount1(String sous) {
        return dao.findAllCount1(sous);
    }
}
