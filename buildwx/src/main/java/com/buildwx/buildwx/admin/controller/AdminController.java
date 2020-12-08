package com.buildwx.buildwx.admin.controller;

import com.buildwx.buildwx.admin.entity.*;
import com.buildwx.buildwx.admin.service.ActivityService;
import com.buildwx.buildwx.admin.service.AdminService;
import com.buildwx.buildwx.admin.service.CdkeyService;
import com.buildwx.buildwx.file.entity.Carousel;
import com.buildwx.buildwx.utils.AxiosResult;
import com.buildwx.buildwx.utils.RedisUtil;
import com.buildwx.buildwx.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import com.buildwx.buildwx.utils.JwtUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-11-27 15:00:01
 */
@RestController
@RequestMapping("/system/sys/")
@Slf4j
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    @Resource
    private ActivityService activityService;

    @Resource
    private CdkeyService cdkeyService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtil redisUtil;
    /**
     * 通过主键查询单条数据
     *
     * @param admin
     * @return token code msg
     */
    @RequestMapping("login")
    public AxiosResult login(Admin admin) {
        log.info("管理员{}登陆中", admin);
        Admin login = adminService.login(admin.getUserName());
        log.info("账户信息：{}", login);
        if (!StringUtils.isNull(login)) {
            if (admin.getPassWord().equals(login.getPassWord())) {
                AxiosResult axiosResult = AxiosResult.success();
                String token = jwtUtils.createAdminToken(admin.getUserName());
                log.info("用户：{}生成的token值为：{}", admin.getUserName(), token);
                axiosResult.put("token", token);
                return axiosResult;
            } else {
                return AxiosResult.error("密码错误");
            }
        }else {
            return AxiosResult.error("账户不存在");
        }
    }

    @RequestMapping("getDaliyRate")
    public AxiosResult AxiosResult() {
        log.info("获取近日流量信息");
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }

    @RequestMapping("getChartDataInfo/{type}")
    public AxiosResult getChartDataInfo(@PathVariable String type) {
        log.info("获取访问数据统计,流量类型{}", type);
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }

    @RequestMapping("getAccessDataInfo")
    public AxiosResult getAccessDataInfo() {
        log.info("获取数据分析,访问数据，接口值：/sys/getAccessDataInfo");
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }

    @RequestMapping("getTrendData")
    public AxiosResult getTrendData() {
        log.info("获取数据分析,访问数据，接口值：/sys/getTrendData");
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }


    @RequestMapping("getChartsData")
    public AxiosResult getChartsData(SearchInfo searchInfo) {
        log.info("获取数据分析,搜索查询，接口值：/sys/getChartsData。起始日期:{},截止日期:{}", searchInfo.getStartTime(), searchInfo.getEndTime());
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }

    @RequestMapping("getDataSum")
    public AxiosResult getDataSum() {
        log.info("获取数据分析,搜索查询，接口值：/sys/getDataSum");
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }

    @RequestMapping("getDataSumRate")
    public AxiosResult getDataSumRate(SearchInfo searchInfo) {
        log.info("获取数据分析,搜索查询，接口值：/sys/getDataSumRate,查询日期：{}", searchInfo.getStartTime());
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }


    @RequestMapping("getSeachTypeData")
    public AxiosResult getSeachTypeData(SearchInfo searchInfo) {
        log.info("获取数据分析,搜索查询，接口值：/sys/getDataSumRate,查询时间：{}，查询类型:{}", searchInfo.getData(), searchInfo.getType());
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }


    /*轮播接口
     * 0 主页轮播
     * 1 美食轮播
     * 2 购物轮播
     * 3 游玩轮播
     * */
    @RequestMapping("getCarousel/{type}")
    public AxiosResult getCarousel(@PathVariable int type, PageInfo pageInfo) {
        log.info("获取数据分析,搜索查询，接口值：/sys/getCarousel/{},分页参数：{}", type, pageInfo);
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }


    @RequestMapping("saveEditCarousel")
    public AxiosResult saveEditCarousel() {
        log.info("获取数据分析,搜索查询，接口值：/sys/saveEditCarousel");
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }


    @RequestMapping("getGradeInfo")
    public AxiosResult getGradeInfo(PageInfo pageInfo) {
        log.info("获取数据分析,搜索查询，接口值：/sys/getGradeInfo,参数：{}", pageInfo);
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }


    @RequestMapping("saveRanking")
    public AxiosResult saveRanking(Object gradeInfo) {
        log.info("获取数据分析,搜索查询，接口值：/sys/saveRanking,参数: {}", gradeInfo.toString());
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }


    @RequestMapping("searchActivity/{activityName}")
    public AxiosResult searchActivity(@PathVariable String activityName, PageInfo pageInfo) {
        log.info("获取数据分析,搜索查询，接口值：/sys/searchActivity,参数 {}，分页参数 ：{}", activityName, pageInfo);
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }


    @RequestMapping("deleteActivity/{activityId}")
    public AxiosResult deleteActivity(@PathVariable String activityId) {
        log.info("删除活动，接口值：/sys/deleteActivity,参数: {}", activityId);
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }


    @RequestMapping("getActivityTableInfo")
    public AxiosResult getActivityTableInfo(PageInfo pageInfo) {
        log.info("获取数据分析,搜索查询，接口值：/sys/getActivityTableInfo,分页参数:{}", pageInfo);
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }

    @RequestMapping("insertCarousel")
    public AxiosResult insertCarousel(Carousel carousel) {
        log.info("添加轮播图,活动ID：{}，图片路径：{}", carousel.getActivityId(), carousel.getCarouselUrl());
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }


    @RequestMapping("getHistoryActivityInfo/{shopId}")
    public AxiosResult getHistoryActivityInfo(@PathVariable int shopId, PageInfo pageInfo) {
        log.info("获取历史活动，接口值：/sys/getHistoryActivityInfo,参数：{},分页：{}", shopId, pageInfo);
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }


    @RequestMapping("saveAddCarousel")
    public AxiosResult saveAddCarousel(Activity activity) {
        log.info("添加活动管理，接口值：/sys/saveAddCarousel, 活动信息：{}", activity);
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }

    @RequestMapping("editActivityInfo")
    public AxiosResult editActivityInfo(Activity activity) {
        log.info("修改活动管理，接口值：/sys/editActivityInfo, 活动信息：{}", activity);
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }


    @RequestMapping("searchUserInfoByTel/{tel}")
    public AxiosResult searchUserInfoByTel(@PathVariable String tel, PageInfo pageInfo) {
        log.info("查询用户信息，接口值：/sys/searchUserInfoByTel/{}，分页信息：{}", tel, pageInfo);
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }

    @RequestMapping("searchUserInfoByName/{Name}")
    public AxiosResult searchUserInfoByName(@PathVariable String Name, PageInfo pageInfo) {
        log.info("查询用户信息，接口值：/sys/searchUserInfoByName/{}，分页信息：{}", Name, pageInfo);
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }

    @RequestMapping("saveChangedUserRemark")
    public AxiosResult saveChangedUserRemark(User user) {
        log.info("查询用户信息，接口值：/sys/saveChangedUserRemark,用户信息: {}，", user.getUserRemark());
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }


    @RequestMapping("getUserInfo")
    public AxiosResult getUserInfo(PageInfo pageInfo) {
        log.info("查询用户信息，接口值：/sys/getUserInfo,分页信息: {}，", pageInfo);
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }


    @RequestMapping("searchUserCommentByTel/{tel}")
    public AxiosResult searchUserCommentByTel(@PathVariable String tel, PageInfo pageInfo) {
        log.info("查询用户信息，接口值：/sys/searchUserCommentByTel/{}，分页信息：{}", tel, pageInfo);
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }

    @RequestMapping("searchUserCommentByName/{Name}")
    public AxiosResult searchUserCommentByName(@PathVariable String Name, PageInfo pageInfo) {
        log.info("查询用户信息，接口值：/sys/searchUserCommentByName/{}，分页信息：{}", Name, pageInfo);
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }


    @RequestMapping("deleteUserComment/{commentId}")
    public AxiosResult deleteUserComment(@PathVariable int commentId) {
        log.info("删除活动，接口值：/sys/deleteUserComment,参数: {}", commentId);
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }

    @RequestMapping("changeCommentState")
    public AxiosResult changeCommentState(Comment comment) {
        log.info("查询用户信息，接口值：/sys/changeCommentState,评论信息: {}，", comment);
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }

    @RequestMapping("getUserCommentInfo")
    public AxiosResult getUserCommentInfo(PageInfo pageInfo) {
        log.info("查询用户信息，接口值：/sys/getUserCommentInfo，分页信息：{}", pageInfo);
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }


    @RequestMapping("getReplayCommentInfo/{commentId}")
    public AxiosResult getReplayCommentInfo(@PathVariable int commentId, PageInfo pageInfo) {
        log.info("查询用户信息，接口值：/sys/getUserCommentInfo，查询参数：{} ，分页信息：{}", commentId, pageInfo);
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }

    @RequestMapping("deleteReplay/{replayId}")
    public AxiosResult deleteReplay(@PathVariable int replayId) {
        log.info("删除活动，接口值：/sys/deleteReplay,参数: {}", replayId);
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }

    @RequestMapping("changeReplayState")
    public AxiosResult changeReplayState(Replay replay) {
        log.info("查询用户信息，接口值：/sys/changeCommentState,评论信息: {}，", replay);
        /*逻辑区域*/
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("保存成功", 200);
        return axiosResult;
    }


    @RequestMapping("getCdkeyInfo")
//    @Cacheable(cacheNames = "cdkey", key = "'cdkeyList'")
    public AxiosResult getCdkeyInfo(PageInfo pageInfo) {
        log.info("查询用户信息，接口值：/sys/getCdkeyInfo，分页信息：{}", pageInfo);
        /*逻辑区域*/
        int currentPage = (pageInfo.getCurrentPage() - 1) * pageInfo.getPageSize();
        List<Cdkey> cdkeys = cdkeyService.queryAllByLimit(currentPage, pageInfo.getPageSize());
        int totals = cdkeyService.selectTotals();
        AxiosResult axiosResult = AxiosResult.success();
        axiosResult.put("cdkeyInfo", cdkeys);
        axiosResult.put("保存成功", 200);
        axiosResult.put("totals", totals);
        return axiosResult;
    }


    @RequestMapping("changeShopState")
    public AxiosResult changeShopState(Cdkey cdkey) {
        log.info("查询用户信息，接口值：/sys/changeShopState, cdkey信息: {}，", cdkey);
        /*逻辑区域*/
        int update = cdkeyService.update(cdkey);
        if (update > 0) {
            return AxiosResult.success("修改成功");
        } else {
            return AxiosResult.error("修改失败");
        }
    }

    @RequestMapping("deleteCdkey/{cdkeyId}")
    public AxiosResult deleteCdkey(@PathVariable int cdkeyId) {
        log.info("删除活动，接口值：/sys/deleteCdkey,参数: {}", cdkeyId);
        boolean b = cdkeyService.deleteById(cdkeyId);
        int totals = cdkeyService.selectTotals();
        if (b) {
            return  AxiosResult.success(totals);
        } else {
            return  AxiosResult.error();
        }
    }


    @RequestMapping("createCdkeys")
    public AxiosResult createCdkeys() {
        log.info("生成CDkey，接口值：/sys/createCdkeys");
        AxiosResult axiosResult = AxiosResult.success();
        return axiosResult;
    }
}