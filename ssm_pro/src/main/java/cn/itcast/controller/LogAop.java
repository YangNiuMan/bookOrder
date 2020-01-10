package cn.itcast.controller;

import cn.itcast.domain.Syslog;
import cn.itcast.service.SysLogService;
import com.sun.org.apache.regexp.internal.RE;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService service;

    private Date visitTime;//开始的时间
    private Class clazz;//访问的类
    private Method method;//访问的方法

    //前置通知主要获取开始的时间，执行的类，执行的方法
    @Before("execution(* cn.itcast.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws Exception {
        visitTime = new Date();//当前时间就是开始访问的时间
        clazz = jp.getTarget().getClass();//具体要访问的类
        String methodName = jp.getSignature().getName();//访问方法的名称
        Object[] args = jp.getArgs();//获取访问的方法的参数

        //获得具体执行的方法的Method对象
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);//只能获取无参数的方法
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName, classArgs);

        }
    }

    //后置通知
    @After("execution(* cn.itcast.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        long time = new Date().getTime()-visitTime.getTime();

        String url="";
        //获取url
        if (clazz!=null&&method!=null&&clazz!=LogAop.class){
            //获取类上的@RequesrMapping（“/order”）
            RequestMapping classAnnotation = (RequestMapping)clazz.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null){
                String[] classValue = classAnnotation.value();
                //获取方法上的@RequestMaapping
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation!=null){
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];

                    //获取访问的ip
                    String ip = request.getRemoteAddr();
                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User)context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog
                    Syslog syslog = new Syslog();
                    syslog.setExecutionTime(time);
                    syslog.setIp(ip);
                    syslog.setMethod("[类名] "+clazz.getName()+"[方法名] "+method.getName());
                    syslog.setUrl(url);
                    syslog.setUsername(username);
                    syslog.setVisitTime(visitTime);

                    //调用Service完成操作
                    service.save(syslog);

                }
            }
        }
    }
}
