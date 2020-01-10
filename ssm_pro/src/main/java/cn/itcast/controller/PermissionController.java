package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService service;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize){
       ModelAndView mv = new ModelAndView();
       List<Permission> permissionList= service.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(permissionList);
        int totalCount=service.findTotal();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(name = "sous",required = true) String sous,@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList= service.search(sous,page,pageSize);
        PageInfo pageInfo = new PageInfo(permissionList);
        int totalCount=service.findCount(sous);
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("totalCount",totalCount);
        mv.addObject("pages",pages);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission p){
        service.save(p);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deletePermission.do")
    public String delete(@RequestParam(name = "id",required = true) Integer id){
        service.delete(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findByPeId.do")
    public ModelAndView findByPeId(@RequestParam(name = "id",required = true) Integer id){
        ModelAndView mv = new ModelAndView();
        Permission permission=service.findByPeId(id);
        mv.addObject("permission",permission);
        mv.setViewName("permission-update");
        return mv;
    }

    @RequestMapping("/findDetail.do")
    public ModelAndView findDetail(@RequestParam(name = "id",required = true) Integer id){
        ModelAndView mv = new ModelAndView();
        Permission permission=service.findByPeId(id);
        mv.addObject("permission",permission);
        mv.setViewName("permission-detail");
        return mv;
    }

    @RequestMapping("/update.do")
    public String  update(@RequestParam(name = "id",required = true) Integer id,@RequestParam(name = "permissionName",required = true) String permissionName,
                               @RequestParam(name = "url",required = true) String url){

        service.updated(id,permissionName,url);
        return "redirect:findAll.do";
    }
}
