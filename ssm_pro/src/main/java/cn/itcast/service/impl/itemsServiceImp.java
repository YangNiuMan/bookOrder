package cn.itcast.service.impl;

import cn.itcast.dao.itemsDao;
import cn.itcast.service.itemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemsService")
public class itemsServiceImp implements itemsService {
    @Autowired
    private itemsDao dao;
    @Override
    public void update(Integer id) {
        dao.update(id);
    }
}
