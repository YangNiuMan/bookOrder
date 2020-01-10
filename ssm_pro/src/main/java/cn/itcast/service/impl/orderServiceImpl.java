package cn.itcast.service.impl;

import cn.itcast.dao.orderDao;
import cn.itcast.domain.Order;
import cn.itcast.service.orderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional
public class orderServiceImpl implements orderService {

    @Autowired
    private orderDao dao;

    @Override
    public List<Order> findAll(int page,int pageSize) {
        PageHelper.startPage(page, pageSize);
        return dao.findAll();
    }

    @Override
    public Order findById(Integer id){
        return dao.findById(id);
    }

    @Override
    public int findTotal() {

        return dao.findTotal();
    }
}
