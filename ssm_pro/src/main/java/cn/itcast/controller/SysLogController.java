package cn.itcast.controller;


import cn.itcast.domain.Syslog;
import cn.itcast.service.SysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService service;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Syslog> sysLogs = service.findAll(/*page,pageSize*/);
        int totalCount=service.findTotal();
        mv.addObject("sysLogs", sysLogs);
        mv.addObject("totalCount",totalCount);
        mv.setViewName("syslog-list");
        return mv;
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(name = "sous",required = true) String sous){
        ModelAndView mv = new ModelAndView();
        List<Syslog> sysLogs =service.search(sous);
        int totalCount=service.findCount(sous);
        mv.addObject("sysLogs", sysLogs);
        mv.addObject("totalCount",totalCount);
        mv.setViewName("syslog-list");
        return mv;
    }
}
