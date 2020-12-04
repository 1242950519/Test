package com.buildwx.buildwx.admin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Activity)实体类
 *
 * @author makejava
 * @since 2020-12-02 10:26:16
 */
@Data
public class Activity implements Serializable {
    private static final long serialVersionUID = 297396079373258870L;
    /**
     * 活动ID
     */
    private int activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动时间
     */
    private String[] activityTime;
    /**
     * 活动封面地址
     */
    private String activityCoverUrl;
    /**
     * 活动地址
     */
    private String activityAddress;
    /**
     * 活动状态
     */
    private boolean activityState;
    /**
     * 活动更新时间
     */
    private String activityUpdateTime;
    /**
     * 活动内容
     */
    private String activityContent;
    /**
     * 活动分享图片地址
     */
    private String activityShareImgUrl;
    /**
     * 分享活动文字
     */
    private String activityShareText;

}