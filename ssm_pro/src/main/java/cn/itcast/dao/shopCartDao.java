package cn.itcast.dao;


import cn.itcast.domain.shopCart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface shopCartDao {

    @Insert("insert into shopCart (id,cover,name,price,amount,total,user_Id) values(#{id},#{cover},#{name},#{price},#{amount},#{total},#{userId})")
    void add(@Param("id") Integer id,@Param("cover") String cover,@Param("name") String name,@Param("price") Double price,@Param("amount") Integer amount,@Param("total") Double total,@Param("userId") Integer userId);

    @Select("select * from shopCart where user_id=#{id}")
    List<shopCart> findAll1(Integer id);

    @Select("select * from shopCart where id=#{id}")
    shopCart findById(Integer id);

    @Update("update shopCart set amount=#{amount},total=#{total} where id=#{id}")
    void update(@Param("id") Integer id,@Param("amount") Integer amount,@Param("total") Double total);

    @Select("select * from shopCart where user_id=#{userId}")
    List<shopCart> findByUserId(Integer userId);

    @Select("select count(*) from shopCart where user_id=#{id}")
    int findCount(Integer id);

    @Select("select * from shopCart")
    List<shopCart> findAll();

    @Delete("delete from shopCart where id=#{id} and user_id=#{userId}")
    void delete(@Param("id") Integer id,@Param("userId") Integer userId);

    @Select("select total from shopCart where id=#{id} and user_id=#{userId}")
    double findtotalById(@Param("id") Integer id,@Param("userId") Integer userId);

    @Select("select * from shopCart where id=#{bookId} and user_id=#{userId}")
    shopCart findByBookIduserId(@Param("bookId") Integer bookId,@Param("userId") Integer userId);

    @Update("update shopCart set amount=amount+1 where id=#{id}")
    void incress(Integer id);

    @Update("update shopCart set amount=amount-1 where id=#{id}")
    void reduce(Integer id);

    @Delete("delete from shopCart where id=#{id}")
    void delete1(Integer id);
}
