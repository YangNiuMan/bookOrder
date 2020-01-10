package cn.itcast.service.impl;

import cn.itcast.dao.WholeSaleDao;
import cn.itcast.domain.WholeSale;
import cn.itcast.service.WholeSaleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("WholeSaleService")
public class WholeSaleServiceImpl implements WholeSaleService {

    @Autowired
    private WholeSaleDao dao;

    @Override
    public List<WholeSale> findAll(int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.findAll();
    }

    @Override
    public int findTotal() {
        return dao.findTotal();
    }

    @Override
    public void add(Integer id, String cover, String name, String producter, Integer number,Integer submit) {
        dao.add(id,cover,name,producter,number,submit);
    }

    @Override
    public void update(Integer id) {
        dao.update(id);
    }

    @Override
    public List<WholeSale> findBySubmit(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.findBySubmit();
    }

    @Override
    public List<WholeSale> findByNoSubmit(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.findByNoSubmit();
    }

    @Override
    public int findTotal1() {
        return dao.findTotal1();
    }

    @Override
    public int findTotal0() {
        return dao.findTotal0();
    }

    @Override
    public WholeSale findByIdAndSubmit(Integer id) {

        return dao.findByIdAndSubmit(id);
    }
}
