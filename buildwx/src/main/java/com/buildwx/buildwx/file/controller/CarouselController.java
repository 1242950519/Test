package com.buildwx.buildwx.file.controller;

import com.buildwx.buildwx.file.entity.Carousel;
import com.buildwx.buildwx.file.service.CarouselService;
import com.buildwx.buildwx.utils.AxiosResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Carousel)表控制层
 *
 * @author makejava
 * @since 2020-11-20 14:49:35
 */
@Slf4j
@RestController
@RequestMapping("/system/carousel")
public class CarouselController {

    /**
     * 服务对象
     */
    @Resource
    private CarouselService carouselService;

    /**
     * 通过主键查询单条数据
     *
     * @param carousel 轮播图
     * @return 单条数据
     */
    @RequestMapping("insertCarousel")
    public AxiosResult selectOne(Carousel carousel) {
        log.info("添加轮播图,活动ID：{}，图片路径：{}",carousel.getActivityId(),carousel.getCarouselUrl());
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功",200);
        return axiosResult;
    }



}