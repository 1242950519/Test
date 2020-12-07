package com.buildwx.buildwx.file.controller;

import com.buildwx.buildwx.config.MyConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author tianYa
 * date 2020-11-19
 * user Tianya
 * packetName  com.buildwx.buildwx.file.controller
 * projectName  buildwx
 */
@Slf4j
@RestController
@RequestMapping(value = "/fileSys")
public class FileUploader {

    @RequestMapping(value = "/uploadFile")
    public String UploadFile(MultipartFile file){
        log.info("上传文件名：{}",file.getOriginalFilename());

        MyConfig myConfig =new MyConfig();
        String rootPath = myConfig.getRootPath();
        ApplicationHome home = new ApplicationHome(getClass());
        File jarF = home.getSource();
        log.info("项目路径为：{}",jarF.getParentFile().toString());
        return "uploadFile";
    }
}
