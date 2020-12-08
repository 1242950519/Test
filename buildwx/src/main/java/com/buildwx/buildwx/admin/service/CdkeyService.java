package com.buildwx.buildwx.admin.service;

import com.buildwx.buildwx.admin.entity.Cdkey;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;

/**
 * (Cdkey)表服务接口
 *
 * @author makejava
 * @since 2020-12-02 16:29:58
 */
public interface CdkeyService {

    /**
     * 通过ID查询单条数据
     *
     * @param cdkeyid 主键
     * @return 实例对象
     */
    Cdkey queryById(Integer cdkeyid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Cdkey> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param cdkey 实例对象
     * @return 实例对象
     */
    Cdkey insert(Cdkey cdkey);

    /**
     * 修改数据
     *
     * @param cdkey 实例对象
     * @return 实例对象
     */
    int update(Cdkey cdkey);

    /**
     * 通过主键删除数据
     *
     * @param cdkeyid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer cdkeyid);


    /**
     * 查询记录条数
     * @return 影响行数
     */
    int selectTotals();
}