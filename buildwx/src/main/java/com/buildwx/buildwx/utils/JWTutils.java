package com.buildwx.buildwx.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.buildwx.buildwx.admin.entity.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author tianYa
 * date 2020-11-10
 * user Tianya
 * packetName  com.buildwx.buildwx.JwtUtil
 * projectName  buildwx
 */
@Service
@Slf4j
public class JWTutils {
    public String createAdminToken(Admin admin) {
        String token =IdUtils.fastUUID();
        Date start = new Date();
        //一小时有效时间
        long currentTime = System.currentTimeMillis()+60*60*1000;
        Date end= new Date(currentTime);
        try {
            token = JWT.create().withAudience(admin.getUsername()).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(admin.getPassword()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("生成的token值为：{}", token);
        return token;
    }
//    public String createUserToken(User user) {
//        String token =IdUtils.fastUUID();
//        Date start = new Date();
//        //一小时有效时间
//        long currentTime = System.currentTimeMillis()+60*60*1000;
//        Date end= new Date(currentTime);
//        try {
//            token = JWT.create().withAudience(user.getUsername()).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(user.getPassword()));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        log.info("生成的token值为：{}", token);
//        return token;
//    }
}
