package cn.itcast.dao;


import cn.itcast.domain.Indent;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IndentDao {

    @Insert("insert into indent (name,phone,address,total,systime,status,user_id) values(#{name},#{phone},#{address},#{total},#{systime},#{status},#{userId})")
    void save(@Param("name") String name,@Param("phone") String phone,@Param("address") String address,@Param("total") Double total,@Param("systime") Date systime,@Param("status") Integer status,@Param("userId") Integer userId);

    @Select("select * from indent where status=0")
    List<Indent> untreated();

    @Select("select count(*) from indent where status=0")
    int findTotal();

    @Select("select * from indent where status=1")
    List<Indent> treated();

    @Select("select count(*) from indent where status=1")
    int findTotal1();

    @Update("update indent set status=1 where id=#{id}")
    void update(Integer id);

    @Select("select * from indent where user_id=#{id}")
    List<Indent> findAll(Integer id);

    @Delete("delete from indent where id=#{id}")
    void delete(Integer id);
}
