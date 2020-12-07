package com.buildwx.buildwx.file.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Carousel)实体类
 *
 * @author makejava
 * @since 2020-11-20 14:49:30
 */
@Data
public class Carousel implements Serializable {
    private static final long serialVersionUID = 773085627016253686L;
    /**
     * 轮播图ID
     */
    private Integer carouselId;
    /**
     * 轮播图URL
     */
    private String carouselUrl;
    /**
     * 轮播图说明
     */
    private String carouselAnontion;
    /**
     * 活动ID
     */
    private Integer activityId;
    /**
     * 商铺ID
     */
    private Integer shopId;



}