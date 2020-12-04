package com.buildwx.buildwx.admin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-12-02 14:27:50
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -15244843682919726L;
    /**
     * 用户ID
     */
    private int userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户电话
     */
    private String userTel;
    /**
     * 用户性别
     */
    private int userAgent;
    /**
     * 所在省份
     */
    private String userProvince;
    /**
     * 所在城市
     */
    private String userCity;
    /**
     * 用户备注
     */
    private String userRemark;
    /**
     * 用户状态
     */
    private boolean userState;

}