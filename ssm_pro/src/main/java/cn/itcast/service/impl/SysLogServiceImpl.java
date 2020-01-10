package cn.itcast.service.impl;

import cn.itcast.dao.sysLogDao;
import cn.itcast.domain.Syslog;
import cn.itcast.service.SysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("SysLogService")
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private sysLogDao dao;

    @Override
    public void save(Syslog syslog) {
        dao.save(syslog);
    }

    @Override
    public List<Syslog> findAll(/*Integer page,Integer pageSize*/) {
        /*PageHelper.startPage(page, pageSize);*/
        return dao.findAll();
    }

    @Override
    public int findTotal() {
        return dao.findTotal() ;
    }

    @Override
    public int findCount(String sous) {
        return dao.findCount(sous) ;
    }

    @Override
    public List<Syslog> search(String sous) {
        return dao.search(sous);
    }
}
