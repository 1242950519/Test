package com.buildwx.buildwx.admin.dao;

import com.buildwx.buildwx.admin.entity.Replay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Replay)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-02 15:17:08
 */
@Mapper
@Component(value = "ReplayDao")
public interface ReplayDao {

    /**
     * 通过ID查询单条数据
     *
     * @param replayid 主键
     * @return 实例对象
     */
    Replay queryById(Integer replayid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Replay> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param replay 实例对象
     * @return 对象列表
     */
    List<Replay> queryAll(Replay replay);

    /**
     * 新增数据
     *
     * @param replay 实例对象
     * @return 影响行数
     */
    int insert(Replay replay);

    /**
     * 修改数据
     *
     * @param replay 实例对象
     * @return 影响行数
     */
    int update(Replay replay);

    /**
     * 通过主键删除数据
     *
     * @param replayid 主键
     * @return 影响行数
     */
    int deleteById(Integer replayid);

}