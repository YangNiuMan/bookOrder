package cn.itcast.dao;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface itemsDao {

    @Update("update items set amount = 1 where id=#{id}")
    void update(Integer id);
}
