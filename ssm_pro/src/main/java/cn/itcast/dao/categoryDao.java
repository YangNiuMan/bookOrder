package cn.itcast.dao;


import cn.itcast.domain.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface categoryDao {

    @Select("select * from category where id=#{category_id}")
    Category findById(Integer category_id);

    @Select("select * from category")
    List<Category> findAll();

    @Select("select * from category where id=#{id}")
    Category findByLbId(Integer id);

    @Update("update category set name=#{name} where id=#{id}")
    void update(@Param("id") Integer id,@Param("name") String name);

    @Delete("delete from category where id=#{id}")
    void delete(Integer id);

    @Insert("insert into category (name) values(#{name})")
    void add(String name);
}
