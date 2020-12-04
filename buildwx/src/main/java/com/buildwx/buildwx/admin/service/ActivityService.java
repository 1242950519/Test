package com.buildwx.buildwx.admin.service;

import com.buildwx.buildwx.admin.entity.Activity;

import java.util.List;

/**
 * (Activity)表服务接口
 *
 * @author makejava
 * @since 2020-12-02 10:26:17
 */
public interface ActivityService {

    /**
     * 通过ID查询单条数据
     *
     * @param activityid 主键
     * @return 实例对象
     */
    Activity queryById(Integer activityid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Activity> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    Activity insert(Activity activity);

    /**
     * 修改数据
     *
     * @param activity 实例对象
     * @return 实例对象
     */
    Activity update(Activity activity);

    /**
     * 通过主键删除数据
     *
     * @param activityid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer activityid);

}