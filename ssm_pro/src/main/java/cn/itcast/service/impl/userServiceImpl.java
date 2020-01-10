package cn.itcast.service.impl;

import cn.itcast.dao.userDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.users;
import cn.itcast.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class userServiceImpl implements IUserService {
    @Autowired
    private userDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        users users=null;
        users = dao.findByUsername(username);

        //处理自己的对象封住成UserDetails
        User user = new User(users.getUsername(),  users.getPassword(), users.getStatus() == 0 ? false : true, true, true, true, getAuthority(users.getRoles()));
        return user;
    }
    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
            System.out.println(list);
        }

        return list;
    }

    @Override
    public List<users> findAll(int page,int pageSize) {
        PageHelper.startPage(page, pageSize);
        return dao.findAll();
    }

    @Override
    public void save(users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
         dao.save(user);
    }

    @Override
    public users findByUserId(Integer id) {
        return dao.findByUserId(id);
    }


    @Override
    public List<Role> findOtherRole(Integer id) {
        return dao.findOtherRole(id);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] ids) {
        for (Integer roleId : ids) {
            dao.addRoleToUser(userId,roleId);
        }

    }

    @Override
    public users findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public void updatePassword(String username,String password1) {
        dao.updatePassword(username,password1);
    }

    @Override
    public void delete(Integer id) {
            dao.delete(id);
    }

    @Override
    public int findTotal() {
        return dao.findTotal();
    }

    @Override
    public List<users> search(String sous,int page,int pageSize) {
        PageHelper.startPage(page, pageSize);
        return dao.search(sous);
    }

    @Override
    public int findCount(String sous) {
        return dao.findCount(sous);
    }

    @Override
    public void register(String username, String password, String email, String phoneNum, String status) {
        dao.register(username,password,email,phoneNum,status);
    }
}
