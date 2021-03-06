package com.gunner.service;

import com.gunner.model.pojo.User;

import java.util.HashMap;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author Sunmz
 * @since 2019-04-08 09:52:35
 */
public interface UserService {

    /**
     * 登录
     *
     * @param user 主键
     * @return 实例对象
     */
    HashMap login(User user);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(User user,int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}