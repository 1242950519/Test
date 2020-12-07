package com.buildwx.buildwx.admin.service.impl;

import com.buildwx.buildwx.admin.dao.AdminDao;
import com.buildwx.buildwx.admin.entity.Admin;
import com.buildwx.buildwx.admin.service.AdminService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2020-11-27 15:00:01
 */
@Service("adminService")
@CacheConfig(cacheNames = "admin")
public class AdminServiceImpl implements AdminService {

    /**
     * @Cacheable 缓存有数据时，从缓存获取；没有数据时，执行方法，并将返回值保存到缓存中
     * @Cacheable 一般在查询中使用
     * 1) cacheNames 指定缓存区，没有配置使用@CacheConfig指定的缓存区
     * 2) key 指定缓存区的key
     * 3) 注解的值使用SpEL表达式
     * eq ==
     * lt <
     * le <=
     * gt >
     * ge >=
     */
    /**
     * condition 满足条件缓存数据
     * @Cacheable(key = "#id", condition = "#number ge 20") // >= 20
     */

    /**
     * unless 满足条件时否决缓存数据
     *  @Cacheable(key = "#id", unless = "#number lt 20") // < 20
     */

    /**
     * @CachePut 一定会执行方法，并将返回值保存到缓存中
     * @CachePut 一般在新增和修改中使用
     * @CachePut(key = "#user.id")
     */

    /**
     * 根据key删除缓存区中的数据
     * @CacheEvict(key = "#id")
     */

    /**
     * allEntries = true ：删除整个缓存区的所有值，此时指定的key无效
     * beforeInvocation = true ：默认false，表示调用方法之后删除缓存数据；true时，在调用之前删除缓存数据(如方法出现异常)
     * @CacheEvict(key = "#id", allEntries = true)
     */
    @Resource
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(cacheNames = "admin", key = "#username")
    public Admin login(String username) {
        return this.adminDao.login(username);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Admin> queryAllByLimit(int offset, int limit) {
        return this.adminDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.login(admin.getUsername());
    }

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String username) {
        return this.adminDao.deleteById(username) > 0;
    }
}