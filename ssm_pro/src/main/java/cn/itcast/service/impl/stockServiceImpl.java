package cn.itcast.service.impl;

import cn.itcast.dao.stockDao;
import cn.itcast.domain.stock;
import cn.itcast.service.stockService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stockService")
public class stockServiceImpl implements stockService {
    @Autowired
    private stockDao dao;
    @Override
    public List<stock> findAll(int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.findAll();
    }

    @Override
    public int findTotal() {
        return dao.findTotal();
    }

    @Override
    public stock findById(String id) {
        return dao.findById(id);
    }

    @Override
    public void update(Integer id, Integer number) {
        dao.update(id,number);
    }
}
