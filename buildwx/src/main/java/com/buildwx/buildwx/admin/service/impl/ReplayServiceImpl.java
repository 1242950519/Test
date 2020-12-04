package com.buildwx.buildwx.admin.service.impl;

import com.buildwx.buildwx.admin.dao.ReplayDao;
import com.buildwx.buildwx.admin.entity.Replay;
import com.buildwx.buildwx.admin.service.ReplayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Replay)表服务实现类
 *
 * @author makejava
 * @since 2020-12-02 15:17:08
 */
@Service("replayService")
public class ReplayServiceImpl implements ReplayService {
    @Resource
    private ReplayDao replayDao;

    /**
     * 通过ID查询单条数据
     *
     * @param replayid 主键
     * @return 实例对象
     */
    @Override
    public Replay queryById(Integer replayid) {
        return this.replayDao.queryById(replayid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Replay> queryAllByLimit(int offset, int limit) {
        return this.replayDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param replay 实例对象
     * @return 实例对象
     */
    @Override
    public Replay insert(Replay replay) {
        this.replayDao.insert(replay);
        return replay;
    }

    /**
     * 修改数据
     *
     * @param replay 实例对象
     * @return 实例对象
     */
    @Override
    public Replay update(Replay replay) {
        this.replayDao.update(replay);
        return this.queryById(replay.getReplayId());
    }

    /**
     * 通过主键删除数据
     *
     * @param replayid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer replayid) {
        return this.replayDao.deleteById(replayid) > 0;
    }
}