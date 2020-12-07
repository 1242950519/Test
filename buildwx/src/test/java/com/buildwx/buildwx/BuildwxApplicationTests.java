package com.buildwx.buildwx;

import com.buildwx.buildwx.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class BuildwxApplicationTests {

    @Autowired
    RedisUtil redisUtil;

    @Test
    void contextLoads() {
        boolean chenzhen = redisUtil.set("chenzhen", 18);
        log.info("获取到的key的值为：{}",redisUtil.get("chenzhen"));
    }



}
