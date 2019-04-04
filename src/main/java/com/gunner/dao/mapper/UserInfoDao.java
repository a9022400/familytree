package com.gunner.dao.mapper;

import com.gunner.model.dto.UserInfoDTO;
import com.gunner.model.pojo.UserInfo;
import com.gunner.model.vo.UserInfoVO;

import java.util.List;

/**
 * (UserInfo)表数据库访问层
 *
 * @author Sunmz
 * @since 2019-04-02 09:41:48
 */
public interface UserInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserInfo queryById(Integer id);
 
    /**
     * 查询指定行数据
     *
     * @param userInfoDTO 实例对象
     * @return 对象列表
     */
    List<UserInfoVO> queryAllByLimit(UserInfoDTO userInfoDTO);

    /**
     * 通过实体作为筛选条件查询,判断是否存在该实体
     *
     * @param userInfo 实例对象
     * @return 对象列表
     */
    List<UserInfo> queryAll(UserInfo userInfo);

    /**
     * 新增数据
     *
     * @param userInfo 实例对象
     * @return 影响行数
     */
    int insert(UserInfo userInfo);

    /**
     * 修改数据
     *
     * @param userInfo 实例对象
     * @return 影响行数
     */
    int update(UserInfo userInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int remove(Integer id);
}