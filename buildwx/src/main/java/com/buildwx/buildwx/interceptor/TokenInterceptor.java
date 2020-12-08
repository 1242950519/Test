package com.buildwx.buildwx.interceptor;
/**
 * @author tianYa
 * date 2020-12-07
 * user Tianya
 * packetName  com.buildwx.buildwx.interceptor
 * projectName  buildwx
 */

import com.auth0.jwt.interfaces.Claim;
import com.buildwx.buildwx.utils.JwtUtils;
import com.buildwx.buildwx.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @description：TODO
 * @author     ：tianYa
 * @date       ：2020/12/7 20:01
 */
@Component
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    JwtUtils jwtUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        log.info("token:{}",token);
        //token验证
        if (!StringUtils.isEmpty(token)) {
            Map<String, Claim> claimMap = jwtUtils.verifyToken(token);
            if (claimMap!=null){
                //账户操作...
                log.info("token验证成功，404");
                return true;
            } else {
                //验证错误,跳转到错误页面
//                response.sendRedirect(request.getContextPath()+"/twjd/error");
                log.info("token验证错误，404");
                return false;
            }
        }else {
            log.info("token不存在，404");
            return false;
        }
    }
}
