package com.buildwx.buildwx.config;

import com.buildwx.buildwx.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addExposedHeader("token");
        config.setMaxAge(60 * 60 * 24L);
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
        // 加载顺序
        bean.setOrder(FilterRegistrationBean.HIGHEST_PRECEDENCE);
        return bean;

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(tokenInterceptor);
        //拦截配置
        registration.addPathPatterns("/system/**");
        //排除配置
        registration.excludePathPatterns("/system/sys/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        告知系统static 当成 静态资源访问/**/
//        生产模式下地址
//        registry.addResourceHandler("/images/**").addResourceLocations("file:C:\\www\\upload\\images\\");
    }


    /**
     * ServerEndpointExporter 作用
     * <p>
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
