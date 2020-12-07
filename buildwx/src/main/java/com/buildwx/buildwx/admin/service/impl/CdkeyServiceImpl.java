package com.buildwx.buildwx.admin.service.impl;

import com.buildwx.buildwx.admin.dao.CdkeyDao;
import com.buildwx.buildwx.admin.entity.Cdkey;
import com.buildwx.buildwx.admin.service.CdkeyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cdkey)表服务实现类
 *
 * @author makejava
 * @since 2020-12-02 16:29:58
 */
@Service("cdkeyService")
public class CdkeyServiceImpl implements CdkeyService {
    @Resource
    private CdkeyDao cdkeyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cdkeyid 主键
     * @return 实例对象
     */
    @Override
    public Cdkey queryById(Integer cdkeyid) {
        return this.cdkeyDao.queryById(cdkeyid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Cdkey> queryAllByLimit(int offset, int limit) {
        return this.cdkeyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param cdkey 实例对象
     * @return 实例对象
     */
    @Override
    public Cdkey insert(Cdkey cdkey) {
        this.cdkeyDao.insert(cdkey);
        return cdkey;
    }

    /**
     * 修改数据
     *
     * @param cdkey 实例对象
     * @return 实例对象
     */
    @Override
    public Cdkey update(Cdkey cdkey) {
        this.cdkeyDao.update(cdkey);
        return this.queryById(cdkey.getCdkeyId());
    }

    /**
     * 通过主键删除数据
     *
     * @param cdkeyid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer cdkeyid) {
        return this.cdkeyDao.deleteById(cdkeyid) > 0;
    }
}