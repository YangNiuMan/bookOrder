package cn.itcast.dao;

import cn.itcast.domain.Role;
import cn.itcast.domain.users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository("userDao")
public interface userDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id" ,javaType = java.util.List.class,many = @Many(select="cn.itcast.dao.roleDao.findByUserId"))

    })
    public users findByUsername(String username);

    @Select("select * from users")
    public List<users> findAll();

    @Insert("insert into users (email,username,password,phoneNum,status) value(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(users user);

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id" ,javaType = java.util.List.class,many = @Many(select="cn.itcast.dao.roleDao.findByUserId"))
    })
    users findByUserId(Integer id);

    @Select("select * from role where id not in(select roleId from users_role where userId=#{id})")
    List<Role> findOtherRole(Integer id);

    @Insert("insert into users_role (userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
    @Select("select password from users where username=#{username}" )
    String checkPwd(String username);

    @Update("update users set password=#{password1} where username=#{username}")
    public void updatePassword(@Param("username") String username, @Param("password1")String password1);

    @Delete("delete from users where id=#{id}")
    void delete(Integer id);

    @Select("select count(*) from users where 1=1")
    int findTotal();

    @Select("select * from users where username=#{sous}")
    List<users> search(String sous);

    @Select("select count(*) from users where username=#{sous}")
    int findCount(String sous);

    @Insert("insert into users (username,password,email,phoneNum,status) values(#{username},#{password},#{email},#{phoneNum},#{status})")
    void register(@Param("username") String username,@Param("password") String password,@Param("email") String email,@Param("phoneNum") String phoneNum,@Param("status") String status);
}
