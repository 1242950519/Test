package com.buildwx.buildwx.admin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Comment)实体类
 *
 * @author makejava
 * @since 2020-12-02 14:58:07
 */
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = -13355249900728552L;
    /**
     * 用户Id
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
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 评论标题
     */
    private String commentTitle;
    /**
     * 评论时间
     */
    private String commentDate;
    /**
     * 评论状态
     */
    private String commentState;
    /**
     * 活动ID
     */
    private Integer activityId;
    /**
     * 活动名
     */
    private String activityName;

}