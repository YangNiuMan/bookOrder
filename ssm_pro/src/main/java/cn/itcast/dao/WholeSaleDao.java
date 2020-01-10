package cn.itcast.dao;


import cn.itcast.domain.WholeSale;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WholeSaleDao {

    @Select("select * from wholesale")
    List<WholeSale> findAll();

    @Select("select count(*) from wholesale")
    int findTotal();

    @Insert("insert into wholesale (id,cover,name,producter,number,submit) values(#{id},#{cover},#{name},#{producter},#{number},#{submit})" )
    void add(@Param("id") Integer id,@Param("cover") String cover,@Param("name") String name,@Param("producter") String producter,@Param("number") Integer number,@Param("submit") Integer submit);

    @Update("update wholesale set submit=1 where id=#{id}")
    void update(Integer id);

    @Select("select * from wholesale where submit=1")
    List<WholeSale> findBySubmit();

    @Select("select * from wholesale where submit=0")
    List<WholeSale> findByNoSubmit();

    @Select("select count(*) from wholesale where submit=1")
    int findTotal1();

    @Select("select count(*) from wholesale where submit=0")
    int findTotal0();

    @Select("select * from wholesale where id=#{id} and submit=0")
    WholeSale findByIdAndSubmit(Integer id);
}
