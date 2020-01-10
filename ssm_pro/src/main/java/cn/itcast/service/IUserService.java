package cn.itcast.service;

import cn.itcast.domain.Role;
import cn.itcast.domain.users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService{


    public List<users> findAll(int page,int pageSize);

    void save(users user);

    users findByUserId(Integer id);


    List<Role> findOtherRole(Integer id);

    void addRoleToUser(Integer userId, Integer[] ids);


    public users findByUsername(String username);

   public void updatePassword(String username,String password1);

    void delete(Integer id);

    int findTotal();

    List<users> search(String sous,int page,int pageSize);

    int findCount(String sous);

    void register(String username, String password, String email, String phoneNum, String status);
}
