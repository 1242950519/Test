package com.buildwx.buildwx.config;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Objects;

/**
 * @author tianYa
 * date 2020-11-19
 * user Tianya
 * packetName  com.buildwx.buildwx.config
 * projectName  buildwx
 */
@Component
public class MyConfig {

    /*项目路径*/
    private final static String classPath;

    static {
        //获取的是classpath路径，适用于读取resources下资源
        classPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
    }

    /**
     * 项目根目录
     */
    public  String getRootPath() {
        return RootPath("");
    }

    /**
     * 自定义追加路径
     */
    public  String getRootPath(String u_path) {
        return RootPath("/" + u_path);
    }

    /**
     * 私有处理方法
     */
    private static String RootPath(String u_path) {
        String rootPath = "";
        //windows下
        if ("\\".equals(File.separator)) {
            //System.out.println(classPath);
            rootPath = classPath + u_path;
            rootPath = rootPath.replaceAll("/", "\\\\");
            if (rootPath.substring(0, 1).equals("\\")) {
                rootPath = rootPath.substring(1);
            }
        }
        //linux下
        if ("/".equals(File.separator)) {
            //System.out.println(classPath);
            rootPath = classPath + u_path;
            rootPath = rootPath.replaceAll("\\\\", "/");
        }
        return rootPath;
    }


}
