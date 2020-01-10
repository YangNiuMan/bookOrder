package cn.itcast.service;

import cn.itcast.domain.Syslog;

import java.util.List;

public interface SysLogService {


    public  void save(Syslog syslog);

    List<Syslog> findAll(/*Integer page,Integer pageSize*/);

    int findTotal();

    int findCount(String sous);

    List<Syslog> search(String sous);
}
