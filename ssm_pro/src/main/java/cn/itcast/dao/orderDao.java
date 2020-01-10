package cn.itcast.dao;

import cn.itcast.domain.Order;
import cn.itcast.domain.product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface orderDao {

    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "id",javaType = product.class,one = @One(select = "cn.itcast.dao.AccountDao.findById")),

    })
    public List<Order> findAll();

    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "id",javaType = product.class,one = @One(select = "cn.itcast.dao.AccountDao.findById")),
            @Result(property = "travellers",column = "id",many = @Many(select="cn.itcast.dao.TravellerDao.findById")),
            @Result(property = "member" ,column = "memberId",one = @One(select = "cn.itcast.dao.MemberDao.findById")),
    })

    Order findById(Integer id);

    @Select("select count(*) from orders where 1=1")
    int findTotal();
}
