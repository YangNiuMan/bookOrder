package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import cn.itcast.service.PermissionService;
import cn.itcast.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/role")
public class roleController {

    @Autowired
    private RoleService service;
    @Autowired
    private PermissionService service1;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize) {
        List<Role> roleList = service.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(roleList);
        int totalCount=service.findTotal();
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("page", pages);
        mv.addObject("totalCount",totalCount);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(name = "sous",required = true) String sous,@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize",required = true,defaultValue ="3") Integer pageSize) {
        List<Role> roleList = service.search(sous,page,pageSize);
        PageInfo pageInfo = new PageInfo(roleList);
        int totalCount=service.findCount(sous);
        int pages= (totalCount % pageSize) ==0 ?totalCount/pageSize:(totalCount/pageSize)+1;
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("page", pages);
        mv.addObject("totalCount",totalCount);
        mv.setViewName("role-list");
        return mv;
    }

  @RequestMapping("/update.do")
    public String update(@RequestParam(name = "roleId",required = true) Integer roleId,@RequestParam(name = "roleName",required = true) String roleName,
                         @RequestParam(name = "roleDesc",required = true) String roleDesc){
        service.updated(roleId,roleName,roleDesc);
        return "redirect:findAll.do";
    }
/*    @RequestMapping("/update.do")
    public String update(HttpServletRequest request){
        String id = request.getParameter("id");
        int roleId = Integer.parseInt("id");
        String roleName = request.getParameter("roleName");
        String roleDesc = request.getParameter("roleDesc");
        service.updated(roleId,roleName,roleDesc);
        return "redirect:findAll.do";
    }*/
    @RequestMapping("/findByRoleId.do")
    public ModelAndView findByRoleId(@RequestParam(name = "id",required = true) Integer roleId){
        ModelAndView mv = new ModelAndView();
        Role role = service.findByRoleId(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-update");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer roleId){
        ModelAndView mv = new ModelAndView();
        Role role = service.findById(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/delete.do")
    public String delete(@RequestParam(name = "id",required = true) Integer roleId){
        service.delete(roleId);
        return "redirect:findAll.do";
    }
    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username=='admin'")
    public String save(Role role) {
        service.save(role);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) Integer roleId){
        ModelAndView mv = new ModelAndView();
        Role role = service.findByRoleId(roleId);
        System.out.println(role.getId());
        List<Permission> permissions=service1.findOtherPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissions",permissions);
        mv.setViewName("role-permission-add");
        return mv;
    }
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name="roleId",required = true) Integer roleId,
    @RequestParam(name="ids",required = true) Integer[] ids){
        service.addPermissionToRole(roleId,ids);
        return "redirect:findAll.do";
    }
}
