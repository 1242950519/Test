package com.buildwx.buildwx.admin.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-11-27 15:00:00
 */
@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = -41672904135328829L;

    private int userId;
    /**
     * 管理员账号
     */
    private String userName;
    /**
     * 加密密码
     */
    private String passWord;
    /**
     * 账号状态
     */
    private boolean state;
}