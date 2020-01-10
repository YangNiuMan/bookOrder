package cn.itcast.controller;


import cn.itcast.domain.Indent;
import cn.itcast.service.indentService;
import cn.itcast.service.shopCartService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/indent")
public class indentController {

    @Autowired
    private indentService service;

    @Autowired
    private shopCartService SCservice;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam("id") Integer id){
        ModelAndView mv = new ModelAndView();
        List<Indent> indents=service.findAll(id);
        mv.addObject("indents",indents);
        mv.setViewName("order");
        return mv;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        service.delete(id);
        return "order";
    }

    @RequestMapping("add.do")
    public String save(@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address,
                       @RequestParam("idss") Integer idss[], @RequestParam("systime") Date systime, @RequestParam("status") Integer status, @RequestParam("userId") Integer userId){
        double total=0;
        for (Integer id : idss) {
            double money=SCservice.findtotalById(id,userId);
            total+=money;
            SCservice.delete(id,userId);
        }

                service.save(name,phone,address,total,systime,status,userId);
                return "index2";
    }

    @RequestMapping("/untreated")
    public ModelAndView untreated(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                  @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize){
        List<Indent> indents = service.untreated(page, pageSize);
        int totalCount=service.findTotal();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        PageInfo pageInfo = new PageInfo(indents);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("untreatedIndent-list");
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        return mv;
    }

    @RequestMapping("/treated")
    public ModelAndView treated(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                  @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize){
        List<Indent> indents = service.treated(page, pageSize);
        int totalCount=service.findTotal1();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        PageInfo pageInfo = new PageInfo(indents);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("treatedIndent-list");
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        return mv;
    }

    @RequestMapping("update.do")
    public String update(@RequestParam("id") Integer id){
        service.update(id);
        return "main";
    }
}
