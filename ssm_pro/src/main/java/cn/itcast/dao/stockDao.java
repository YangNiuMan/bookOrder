package cn.itcast.dao;

import cn.itcast.domain.stock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface stockDao {

    @Select("select * from stock")
    List<stock> findAll();

    @Select("select count(*) from stock")
    int findTotal();

    @Select("select * from stock where id=#{id}")
    stock findById(String id);

    @Update("update stock set number=number+#{number} where id=#{id}")
    void update(@Param("id") Integer id,@Param("number") Integer number);
}
