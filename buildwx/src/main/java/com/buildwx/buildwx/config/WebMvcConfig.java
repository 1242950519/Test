package com.buildwx.buildwx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    告知系统static 当成 静态资源访问/**/
        //        生产模式下地址
//        registry.addResourceHandler("/images/**").addResourceLocations("file:C:\\www\\upload\\images\\");
//        registry.addResourceHandler("/carousel/**").addResourceLocations("file:C:\\www\\upload\\carousel\\");
//        registry.addResourceHandler("/video/**").addResourceLocations("file:C:\\www\\upload\\video\\");
//        registry.addResourceHandler("/jianli/**").addResourceLocations("file:C:\\www\\upload\\jianli\\");
    }




    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").
                        //允许跨域的域名，可以用*表示允许任何域名使用
                allowedOrigins("*").
                allowedMethods("*"). //允许任何方法（post、get等）
                allowedHeaders("*"). //允许任何请求头
                allowCredentials(true). //带上cookie信息
                exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
            }
        };
    }

    /**
     * ServerEndpointExporter 作用
     *
     * 这个Bean会自动注册使用@ServerEndpoint注解声明的websocket endpoint
     *
     * @return
     */
//    @Bean
//    public ServerEndpointExporter
//    serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }
}
