package com.buildwx.buildwx.admin.service;

import com.buildwx.buildwx.admin.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author makejava
 * @since 2020-12-02 14:58:07
 */
public interface CommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    Comment queryById(Integer userid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Comment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment insert(Comment comment);

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    Comment update(Comment comment);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userid);

}