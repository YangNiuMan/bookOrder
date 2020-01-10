package cn.itcast.dao;

import cn.itcast.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface roleDao {

    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.dao.permissionDao.findPermissionByRoleId"))
    })
    public List<Role> findByUserId(Integer userId);

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.dao.permissionDao.findPermissionByRoleId"))
    })
    public Role findById(Integer userId);

    @Select("select * from role ")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) value(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id=#{roleId}")
    Role findByRoleId(Integer roleId);

    @Insert("insert into role_permission (roleId,permissionId) values (#{roleId},#{id})")
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("id")Integer id);

    @Select("select count(*) from role where 1=1")
    int findTotal();

    @Delete("delete from role where id=#{roleId}")
    void delete(Integer roleId);

    @Select("select * from role where roleName=#{sous}")
    List<Role> search(String sous);

    @Select("select count(*) from role where roleName=#{sous}")
    int findCount(String sous);

    @Update("update role set roleName=#{roleName},roleDesc=#{roleDesc} where id=#{roleId} ")
    void updated(@Param("roleId") Integer roleId,@Param("roleName") String roleName, @Param("roleDesc") String roleDesc);
}
