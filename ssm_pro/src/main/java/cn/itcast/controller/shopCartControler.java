package cn.itcast.controller;

import cn.itcast.domain.shopCart;
import cn.itcast.service.shopCartService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/shopCart")
public class shopCartControler {

    @Autowired
    private shopCartService service;

    @RequestMapping("/findAll1.do")
    public ModelAndView findAll1(@RequestParam("id") Integer id){
        ModelAndView mv = new ModelAndView();
        List<shopCart> shopCarts = service.findAll1(id);
        int totalCount=service.findCount(id);
        mv.addObject("shopCarts", shopCarts);
        mv.addObject("totalCount",totalCount);
        mv.setViewName("shopCart");
        return mv;
    }

    @RequestMapping("/add.do")
    public String incress(@RequestParam("id") Integer id){
        service.incress(id);
        return "shopCart";
    }

    @RequestMapping("/reduce.do")
    public String reduce(@RequestParam("id") Integer id){
        service.reduce(id);
        return "shopCart";
    }

    @RequestMapping("/delete.do")

    public String delete(@RequestParam("id") Integer id){
        service.delete1(id);
        return "shopCart";
    }
}
