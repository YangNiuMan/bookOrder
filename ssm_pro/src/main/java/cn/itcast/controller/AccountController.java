package cn.itcast.controller;


import cn.itcast.domain.product;
import cn.itcast.service.AccountService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")

public class AccountController {
    @Autowired
    private AccountService service;

    @RequestMapping("/findAllAccount")
    @Secured("ROLE_guest")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "3") Integer pageSize)throws Exception {
        List<product> products = service.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(products);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list1");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveAccount(product pro) {
        service.SaveAccount(pro);
        return "redirect:findAllAccount";
    }

}
