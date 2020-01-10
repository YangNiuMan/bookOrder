package cn.itcast.controller;


import cn.itcast.domain.WholeSale;
import cn.itcast.domain.stock;
import cn.itcast.service.WholeSaleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/WholeSale")
public class WholeSaleController {

    @Autowired
    private WholeSaleService service;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "3") Integer pageSize) {
        List<WholeSale> wholeSale = service.findAll(page, pageSize);
        ModelAndView mv = new ModelAndView();
        int totalCount = service.findTotal();
        int pages = (totalCount % pageSize) == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        PageInfo pageInfo = new PageInfo(wholeSale);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount", totalCount);
        mv.addObject("pages", pages);
        mv.setViewName("wholeSale-list");
        return mv;
    }

    @RequestMapping("/add.do")
    public String save(@RequestParam("StockId") Integer id,@RequestParam("StockCover") String cover,@RequestParam("StockName") String name,
                       @RequestParam("StockProducter") String producter,@RequestParam("StockNumber") Integer number,@RequestParam("submit") Integer submit){
        WholeSale wholeSale=service.findByIdAndSubmit(id);
        if(wholeSale==null) {
            service.add(id, cover, name, producter, number, submit);
            return "main";
        }
       return "failer2";
    }

    @RequestMapping("/findBySubmit")
    public ModelAndView findBySubmit(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                               @RequestParam(name = "pageSize",required = true,defaultValue = "3") Integer pageSize){

            List<WholeSale> wholeSale = service.findBySubmit(page, pageSize);
            ModelAndView mv = new ModelAndView();
            int totalCount = service.findTotal1();
            int pages = (totalCount % pageSize) == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
            PageInfo pageInfo = new PageInfo(wholeSale);
            mv.addObject("pageInfo", pageInfo);
            mv.addObject("totalCount", totalCount);
            mv.addObject("pages", pages);
            mv.setViewName("wSubmit-list");
            return mv;
        }
    @RequestMapping("/findByNoSubmit")
    public ModelAndView findByNoSubmit(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                     @RequestParam(name = "pageSize",required = true,defaultValue = "3") Integer pageSize){

        List<WholeSale> wholeSale = service.findByNoSubmit(page, pageSize);
        ModelAndView mv = new ModelAndView();
        int totalCount = service.findTotal0();
        int pages = (totalCount % pageSize) == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        PageInfo pageInfo = new PageInfo(wholeSale);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount", totalCount);
        mv.addObject("pages", pages);
        mv.setViewName("wNoSubmit-list");
        return mv;
    }
    }

