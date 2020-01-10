package cn.itcast.utils;


import cn.itcast.domain.users;
import cn.itcast.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/common")
public class commonUserLogin {

    @Autowired
    private IUserService service;

    @Autowired
     private HttpServletRequest request;

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password){
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        users user = service.findByUsername(username);

        String username1=null;
        String password1=null;
        if(user!=null) {
             username1 = user.getUsername();
             password1 = user.getPassword();
        }
        if(user!=null) {
            if (bc.matches(password, password1)) {
                request.getSession().setAttribute("username1", username1);
                request.getSession().setAttribute("password1", password1);
                int length = password1.length();
                request.getSession().setAttribute("length", length);
                Integer userId = user.getId();
                request.getSession().setAttribute("userId", userId);
                return "index2";
            }
        }
        request.getSession().setAttribute("username1","null");
        return "failer1";
    }

    @RequestMapping("/lyout")
    public String lyout(){
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("username1");
        request.getSession().removeAttribute("password1");
        request.getSession().removeAttribute("length");
        request.getSession().removeAttribute("userId");
      return "index2";
    }

}
