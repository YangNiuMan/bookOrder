package cn.itcast.dao;


import cn.itcast.domain.Supplier;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierDao {

    @Select("select * from supplier")
    List<Supplier> findAll();

    @Select("select count(*) from supplier")
    int findTotal();

    @Select("select * from supplier where id=#{id}")
    Supplier findByLbId(Integer id);

    @Update("update supplier set name=#{name},email=#{email},address=#{address},phoneNum=#{phoneNum},status=#{status} where id=#{id}")
    void update(@Param("id") Integer id,@Param("name") String name,@Param("email") String email,@Param("address") String address,@Param("phoneNum") String phoneNum,@Param("status") String status);

    @Delete("delete from supplier where id=#{id}")
    void delete(Integer id);

    @Insert("insert into supplier (name,email,address,phoneNum,status) values(#{name},#{email},#{address},#{phoneNum},#{status})")
    void add(@Param("name") String name,@Param("email") String email,@Param("address") String address,@Param("phoneNum") String phoneNum,@Param("status") String status);

    @Select("select * from supplier where name like CONCAT('%',#{sous},'%')")
    List<Supplier> search(String sous);

    @Select("select count(*) from supplier where name like CONCAT('%',#{sous},'%')")
    int findAllCount1(String sous);
}
