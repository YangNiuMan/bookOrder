package cn.itcast.controller;

import cn.itcast.domain.Category;
import cn.itcast.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<Category> categories = service.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("categories",categories);
        mv.setViewName("Category-list");
        return mv;
    }
    @RequestMapping("/findByLbId.do")
    public ModelAndView  findByLbId(@RequestParam("id") Integer id){
        Category categories = service.findByLbId(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("categories",categories);
                mv.setViewName("Category-update");
        return mv;
    }

    @RequestMapping("/update.do")
    public String  update(@RequestParam("id") Integer id,@RequestParam("name") String  name){
        service.update(id,name);
        return "redirect:findAll.do";
    }

    @RequestMapping("/delete.do")
    public String  delete(@RequestParam("id") Integer id){
        service.delete(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/add.do")
    public String  add(@RequestParam("name") String  name){
        service.add(name);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView  findById(@RequestParam("id") Integer id){
        Category categories = service.findByLbId(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("categories",categories);
        mv.setViewName("Category-update");
        return mv;
    }
}
