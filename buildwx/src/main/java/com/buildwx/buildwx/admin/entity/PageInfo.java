package com.buildwx.buildwx.admin.entity;

import lombok.Data;

/**
 * @author tianYa
 * date 2020-12-01
 * user Tianya
 * packetName  com.buildwx.buildwx.admin.entity
 * projectName  buildwx
 */
@Data
public class PageInfo {
    private int  totals;
    private int currentPage;
    private int pageSize;
}
