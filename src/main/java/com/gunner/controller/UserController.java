package com.gunner.controller;

import com.gunner.model.pojo.User;
import com.gunner.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author Sunmz
 * @since 2019-04-03 17:59:04
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
    @RequestMapping("lists")
    public User select(Integer id) {
        return this.userService.queryById(id);
    }
    
    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 执行结果
     */
    @RequestMapping("insert")
    public User insert(User user) {
        return this.userService.insert(user);
    }
        
    /**
     * 删除数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("remove")
    public User delete(Integer id) {
        return this.userService.queryById(id);
    }
            
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("update")
    public User update(User user) {
        return this.userService.update(user);
    }
}