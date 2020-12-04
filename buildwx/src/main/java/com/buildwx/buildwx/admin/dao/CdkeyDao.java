package com.buildwx.buildwx.admin.dao;

import com.buildwx.buildwx.admin.entity.Cdkey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Cdkey)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-02 16:29:58
 */
@Mapper
@Component(value = "CdkeyDao")
public interface CdkeyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cdkeyid 主键
     * @return 实例对象
     */
    Cdkey queryById(Integer cdkeyid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Cdkey> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param cdkey 实例对象
     * @return 对象列表
     */
    List<Cdkey> queryAll(Cdkey cdkey);

    /**
     * 新增数据
     *
     * @param cdkey 实例对象
     * @return 影响行数
     */
    int insert(Cdkey cdkey);

    /**
     * 修改数据
     *
     * @param cdkey 实例对象
     * @return 影响行数
     */
    int update(Cdkey cdkey);

    /**
     * 通过主键删除数据
     *
     * @param cdkeyid 主键
     * @return 影响行数
     */
    int deleteById(Integer cdkeyid);

}