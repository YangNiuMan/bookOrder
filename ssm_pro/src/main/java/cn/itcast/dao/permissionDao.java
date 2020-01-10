package cn.itcast.dao;

import cn.itcast.domain.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface permissionDao {

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionName,url) value(#{permissionName},#{url})")
    void save(Permission p);

    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findPermissionByRoleId(Integer roleId);

    @Select("select * from permission where id  not in(select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermission(Integer id);

    @Delete("delete from permission where id=#{id}")
    void delete(Integer id);

    @Select("select count(*) from permission where 1=1")
    int findTotal();

    @Select("select * from permission where permissionName=#{permissionName}")
    List<Permission> search(String sous);

    @Select("select count(*) from permission where permissionName=#{permissionName}")
    int findCount(String sous);

    @Select("select * from permission where id=#{id}")
    Permission findByPeId(Integer id);

    @Update("update permission set permissionName=#{permissionName},url=#{url} where id=#{id} ")
    void updated(@Param("id") Integer id,@Param("permissionName") String permissionName,@Param("url") String url);
}
