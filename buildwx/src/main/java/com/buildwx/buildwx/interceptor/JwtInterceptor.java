package com.buildwx.buildwx.interceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author tianYa
 * date 2020-11-12
 * user Tianya
 * packetName  com.buildwx.buildwx.interceptor
 * projectName  buildwx
 */
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    /**
     * 请求处理之前进行调用，
     */
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{

//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("aName");
//        log.info("拦截器拦截，{}",user);
//        if(user == null||"".equals(user.getUsername())){
//            return false;
//        }else {
//            return true;
//        }
        return true;
    }
    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,  ModelAndView modelAndView) throws Exception {
    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行
     * （主要是用于进行资源清理工作）
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,  Exception ex) throws Exception {
    }
}
