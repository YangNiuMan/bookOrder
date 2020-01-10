package cn.itcast.dao;

import cn.itcast.domain.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sysLogDao {

    @Insert("insert into syslog (visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(Syslog log);

    @Select("select * from syslog")
    List<Syslog> findAll();

    @Select("select count(*) from syslog where 1=1")
    int findTotal();

    @Select("select count(*) from syslog where username=#{sous}")
    int findCount(String sous);

    @Select("select * from syslog where username=#{sous}")
    List<Syslog> search(String sous);
}
