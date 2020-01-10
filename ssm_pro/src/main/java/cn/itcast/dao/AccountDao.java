package cn.itcast.dao;

import cn.itcast.domain.product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {

    @Select("select * from product")
    public List<product> findAll();

    @Select("select * from product where id = #{id}")
    public List<product> findById( Integer id);

    @Insert("insert into product (productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{DepartureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void SaveAccount(product pro);
}
