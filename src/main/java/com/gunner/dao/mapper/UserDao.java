package com.gunner.dao.mapper;

import com.gunner.model.pojo.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author Sunmz
 * @since 2019-04-03 17:59:26
 */
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);
 
    /**
     * 查询指定行数据
     *
     * @param user 实例对象
     * @param offset 当前页面
     * @param limit 每页条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(User user, @Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询,判断是否存在该实体
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int remove(Integer id);
}