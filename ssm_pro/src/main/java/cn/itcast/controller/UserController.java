package cn.itcast.controller;

import cn.itcast.domain.Role;
import cn.itcast.domain.Syslog;
import cn.itcast.domain.users;
import cn.itcast.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "3") Integer pageSize) {
        ModelAndView mv = new ModelAndView();
        List<users> users = service.findAll(page,pageSize);
        int totalCount=service.findTotal();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        PageInfo pageInfo = new PageInfo(users);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(name = "sous",required = true) String sous,@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                               @RequestParam(name = "pageSize",required = true,defaultValue = "3") Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<users> users =service.search(sous,page,pageSize);
        int totalCount=service.findCount(sous);
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        PageInfo pageInfo = new PageInfo(users);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(users user) {
        service.save(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) Integer id) {
        ModelAndView mv = new ModelAndView();
        users user = service.findByUserId(id);
        mv.addObject("user", user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) Integer id) {
        users user = service.findByUserId(id);
        List<Role> roleList = service.findOtherRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.addObject("roleList", roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) Integer userId, @RequestParam(name = "ids", required = true) Integer[] ids) {
        service.addRoleToUser(userId, ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/delSelected")
    public String deleted(@RequestParam(name = "id", required = true) Integer  id){
        service.delete(id);
        return "redirect:findAll.do";
    }


}
