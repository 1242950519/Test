package com.buildwx.buildwx.admin.entity;

import lombok.Data;

/**
 * @author tianYa
 * date 2020-11-30
 * user Tianya
 * packetName  com.buildwx.buildwx.admin.entity
 * projectName  buildwx
 */
@Data
public class SearchInfo {

    private String startTime;
    private String endTime;
    private String data;
    private String type;
}
