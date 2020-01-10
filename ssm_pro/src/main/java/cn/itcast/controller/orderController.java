package cn.itcast.controller;

import cn.itcast.domain.Order;
import cn.itcast.domain.product;
import cn.itcast.service.AccountService;
import cn.itcast.service.orderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/orders")

public class orderController {
    @Autowired
    private orderService service;

    @RequestMapping("/findAllAccount")
    @RolesAllowed("guest")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize) {
        List<Order> ordersList = service.findAll(page,pageSize);
        int totalCount=service.findTotal();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        PageInfo pageInfo = new PageInfo(ordersList);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-page-list");
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(Integer id) {
        Order orders = service.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-show");
        mv.addObject("orders",orders);
        return mv;
    }
}