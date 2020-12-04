package com.buildwx.buildwx.utils;

import java.util.UUID;

/**
 * @author tianYa
 * date 2020-11-12
 * user Tianya
 * packetName  com.buildwx.buildwx.utils
 * projectName  buildwx
 */
public class IdUtils {
    /**
     * 获取随机UUID
     *
     * @return 随机UUID
     */
    public static String randomUUID()
    {
        return com.buildwx.buildwx.utils.UUID.randomUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID()
    {
        return com.buildwx.buildwx.utils.UUID.randomUUID().toString(true);
    }

    /**
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 随机UUID
     */
    public static String fastUUID()
    {
        return com.buildwx.buildwx.utils.UUID.fastUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String fastSimpleUUID()
    {
        return com.buildwx.buildwx.utils.UUID.fastUUID().toString(true);
    }
}
