package com.gunner.controller;

import com.gunner.model.pojo.User;
import com.gunner.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author Sunmz
 * @since 2019-04-01 11:25:22
 */
@Controller
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

}