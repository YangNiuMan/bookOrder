package cn.itcast.utils;

import cn.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class register {

    @Autowired
    private IUserService service;

    @RequestMapping("/register.do")
    public String register(@RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password,
                           @RequestParam(name = "email", required = true) String email, @RequestParam(name = "phoneNum", required = true) String phoneNum,
                           @RequestParam(name = "status", required = true) String status) {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        password= bc.encode(password);
        service.register(username,password,email,phoneNum,status);
        return "index2";
    }

}
