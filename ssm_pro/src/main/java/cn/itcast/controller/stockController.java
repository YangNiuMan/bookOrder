package cn.itcast.controller;

import cn.itcast.domain.stock;
import cn.itcast.service.WholeSaleService;
import cn.itcast.service.stockService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/stock")
public class stockController {

    @Autowired
    private stockService service;

    @Autowired
    private WholeSaleService WService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "3") Integer pageSize) {
        List<stock> stocks = service.findAll(page, pageSize);
        ModelAndView mv = new ModelAndView();
        int totalCount = service.findTotal();
        int pages = (totalCount % pageSize) == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        PageInfo pageInfo = new PageInfo(stocks);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount", totalCount);
        mv.addObject("pages", pages);
        mv.setViewName("stock-list");
        return mv;
    }

    @RequestMapping("/update.do")
    public String update(@RequestParam("id") Integer id,@RequestParam("number") Integer number){
        WService.update(id);
        service.update(id,number);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam("id") String id){
        stock st=service.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("st",st);
        mv.setViewName("stock-add");
        return mv;
    }
    }
