package cn.itcast.service.impl;

import cn.itcast.dao.IndentDao;
import cn.itcast.domain.Indent;
import cn.itcast.service.indentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("indentService")
public class indentServiceImpl implements indentService {
    @Autowired
    private IndentDao dao;
    @Override
    public void save(String name, String phone, String address, Double total, Date systime, Integer status,Integer userId) {
        dao.save(name,phone,address,total,systime,status,userId);
    }

    @Override
    public List<Indent> untreated(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.untreated();
    }

    @Override
    public int findTotal() {
        return dao.findTotal();
    }

    @Override
    public int findTotal1() {
        return dao.findTotal1();
    }

    @Override
    public List<Indent> treated(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return dao.treated();
    }

    @Override
    public void update(Integer id) {
        dao.update(id);
    }

    @Override
    public List<Indent> findAll(Integer id) {
        return dao.findAll(id);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }


}
