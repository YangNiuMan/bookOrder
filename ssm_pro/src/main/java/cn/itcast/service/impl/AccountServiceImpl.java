package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.product;
import cn.itcast.service.AccountService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<product> findAll(int page,int pageSize) {
        PageHelper.startPage(page, pageSize);
        return accountDao.findAll();
    }

    @Override
    public void SaveAccount(product pro) {
        accountDao.SaveAccount(pro);
    }
}
