package com.buildwx.buildwx.admin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Replay)实体类
 *
 * @author makejava
 * @since 2020-12-02 15:17:07
 */
@Data
public class Replay implements Serializable {
    private static final long serialVersionUID = -71255454411132591L;
    /**
     * 回复id
     */
    private Integer replayId;
    /**
     * 回复内容
     */
    private String replayContent;
    /**
     * 回复时间
     */
    private String replayDate;
    /**
     * 回复状态
     */
    private Object replayState;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 评论id
     */
    private Integer commentId;
}