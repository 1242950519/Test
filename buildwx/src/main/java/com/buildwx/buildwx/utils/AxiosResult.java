package com.buildwx.buildwx.utils;

import com.buildwx.buildwx.Constants.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author tianYa
 * date 2020-11-11
 * user Tianya
 * packetName  com.buildwx.buildwx.JwtUtil
 * projectName  buildwx
 */
@Component
public class AxiosResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;
    /* 状态码 */
    private static final String CODE_TAG ="code";

    /* 返回值内容 */
    private static final String MSG_TAG ="msg";

    /* 数据对象 */
    private static final String DATA_TAG ="data";

    /* 空对象 */
    public AxiosResult() {

    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     */
    public AxiosResult(int code,String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }
    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public AxiosResult(int code, String msg, Object data)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data))
        {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AxiosResult success()
    {
        return AxiosResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static AxiosResult success(Object data)
    {
        return AxiosResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static AxiosResult success(String msg)
    {
        return AxiosResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static AxiosResult success(String msg, Object data)
    {
        return new AxiosResult(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static AxiosResult error()
    {
        return AxiosResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AxiosResult error(String msg)
    {
        return AxiosResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static AxiosResult error(String msg, Object data)
    {
        return new AxiosResult(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg 返回内容
     * @return 警告消息
     */
    public static AxiosResult error(int code, String msg)
    {
        return new AxiosResult(code, msg, null);
    }
}
