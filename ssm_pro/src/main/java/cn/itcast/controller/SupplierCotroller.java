package cn.itcast.controller;

import cn.itcast.domain.Supplier;
import cn.itcast.service.SupplierService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/Supplier")
public class SupplierCotroller {

    @Autowired
    private SupplierService service;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "3") Integer pageSize){
        List<Supplier> Suppliers = service.findAll(page,pageSize);
        ModelAndView mv = new ModelAndView();
        int totalCount=service.findTotal();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        PageInfo pageInfo = new PageInfo(Suppliers);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        mv.setViewName("Supplier-list");
        return mv;


    }
    @RequestMapping("/findByGyId.do")
    public ModelAndView  findByGyId(@RequestParam("id") Integer id){
        Supplier supplier = service.findByLbId(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("supplier",supplier);
        mv.setViewName("Supplier-update");
        return mv;
    }

    @RequestMapping("/update.do")
    public String  update(@RequestParam("id") Integer id,@RequestParam("name") String  name,@RequestParam("email") String  email,
                          @RequestParam("address") String  address,@RequestParam("phoneNum") String  phoneNum,@RequestParam("status") String  status
                          ){
        service.update(id,name,email,address,phoneNum,status);
        return "redirect:findAll.do";
    }

    @RequestMapping("/delete.do")
    public String  delete(@RequestParam("id") Integer id){
        service.delete(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/add.do")
    public String  add(@RequestParam("name") String  name,@RequestParam("email") String  email,
                       @RequestParam("address") String  address,@RequestParam("phoneNum") String  phoneNum,@RequestParam("status") String  status){
        service.add(name,email,address,phoneNum,status);
        return "redirect:findAll.do";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(name = "sous",required = true) String sous,@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                               @RequestParam(name = "pageSize",required = true,defaultValue = "3") Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<Supplier> books =service.search(sous,page,pageSize);
        int totalCount=service.findAllCount1(sous);
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        PageInfo pageInfo = new PageInfo(books);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        mv.setViewName("Supplier-SearchList");
        return mv;
    }

}
