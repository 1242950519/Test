package com.buildwx.buildwx.admin.service;

import com.buildwx.buildwx.admin.entity.Replay;

import java.util.List;

/**
 * (Replay)表服务接口
 *
 * @author makejava
 * @since 2020-12-02 15:17:08
 */
public interface ReplayService {

    /**
     * 通过ID查询单条数据
     *
     * @param replayid 主键
     * @return 实例对象
     */
    Replay queryById(Integer replayid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Replay> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param replay 实例对象
     * @return 实例对象
     */
    Replay insert(Replay replay);

    /**
     * 修改数据
     *
     * @param replay 实例对象
     * @return 实例对象
     */
    Replay update(Replay replay);

    /**
     * 通过主键删除数据
     *
     * @param replayid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer replayid);

}