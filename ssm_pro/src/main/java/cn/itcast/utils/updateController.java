package cn.itcast.utils;

import cn.itcast.domain.Role;
import cn.itcast.domain.users;
import cn.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/change")
public class updateController {

    @Autowired
    private IUserService service;

    @RequestMapping("/updatePwd")
    public String  updatePwd(@RequestParam("oldpassword") String oldpassword, @RequestParam("password1") String password1,HttpServletRequest request){
    //获取session
    HttpSession session = request.getSession();
    //获取session域用户名
        User  user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username = user.getUsername();
    //获取用户输入的原密码
     oldpassword = request.getParameter("oldpassword");
    //获取用户输入的新密码
     password1 = request.getParameter("password1");
    //根据名字获取用户
        users username1 = service.findByUsername(username);
        //获取用户加密后的原密码
    String password = username1.getPassword();

    //判断加密后的原密码和输入的是否一致
    BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
    //获取用户加密后的新密码



    boolean matches = bc.matches(oldpassword, password);
        if(matches){
            String Pass = bc.encode(password1);
            password1=Pass;
        service.updatePassword(username,password1);
        return "main";
    }else{
        session.setAttribute("login_msg","密码修改失败,請重新修改或退出");
    }
        return "changePwd";
}
}
