package com.buildwx.buildwx.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.buildwx.buildwx.admin.entity.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT的token，区分大小写
 */
@Slf4j
@Component
public class JwtUtils {

    /**
     * 签名 此签名为 rayfoo 的16位 大写 MD5
     */
    private static final String SIGN_KEY = "5A1332068BA9FD17";

    /**
     * 过期时间为一天
     * TODO 正式上线更换为15分钟
     */
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

    /**
     * token默认的长度
     */
    private static final Integer DEFAULT_TOKEN_SIZE = 4;

    /**
     * 生成token
     *
     * @param userName
     * @return
     */
    public String createAdminToken(String userName) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + EXPIRE_TIME);//过期时间
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("type", "JWT");
        header.put("Algorithm", "HMAC256");
        return JWT.create()
                .withExpiresAt(expireDate)
                .withClaim("userName", userName)
                .withHeader(header)
                .sign(Algorithm.HMAC256(SIGN_KEY));
    }

    /**
     * 校验token并解析token
     *
     * @return
     */
    public Map<String, Claim> verifyToken(String token) throws Exception {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SIGN_KEY)).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaims();
        } catch (TokenExpiredException e) {
            log.error("token已过期");
            throw new Exception("token已过期");
        } catch (JWTVerificationException e) {
            log.error("token不存在或不正确");
            throw new Exception("token不存在或不正确");
        }
    }
}