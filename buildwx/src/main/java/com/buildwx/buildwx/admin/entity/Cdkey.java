package com.buildwx.buildwx.admin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Cdkey)实体类
 *
 * @author makejava
 * @since 2020-12-02 16:29:57
 */
@Data
public class Cdkey implements Serializable {
    private static final long serialVersionUID = 236071108942286944L;
    /**
     * cdkID
     */
    private Integer cdkeyId;
    /**
     * cdkey内容
     */
    private String cdkeyData;
    /**
     * 生成日期
     */
    private String cdkeyCreateDate;
    /**
     * 使用日期
     */
    private String cdkeyCostDate;
    /**
     * 店铺id
     */
    private Integer shopId;
    /**
     * 店铺名
     */
    private String shopName;
    /**
     * 店铺状态
     */
    private boolean shopState;

}