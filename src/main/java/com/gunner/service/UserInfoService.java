package com.gunner.service;

import com.gunner.model.dto.UserInfoDTO;
import com.gunner.model.pojo.UserInfo;
import com.gunner.model.vo.UserInfoVO;

import java.util.List;

/**
 * (UserInfo)表服务接口
 *
 * @author Sunmz
 * @since 2019-04-02 09:29:19
 */
public interface UserInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserInfoVO> queryAllByLimit(UserInfoDTO userInfoDTO);

    /**
     * 新增数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    UserInfo insert(UserInfo userInfo);

    /**
     * 修改数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    UserInfo update(UserInfo userInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}