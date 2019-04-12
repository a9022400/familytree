package com.gunner.controller;

import com.gunner.model.pojo.User;
import com.gunner.service.UserService;
import com.gunner.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * (User)表控制层
 *
 * @author Sunmz
 * @since 2019-04-08 09:52:35
 */
@Controller
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 用户登录
     *
     * @param user 主键
     * @return 登录是否成功
     */
    @ResponseBody
    @RequestMapping("login")
    public HashMap login(User user, HttpServletRequest request, HttpServletResponse response) {
        HashMap map = null;
        try {
            HttpSession session = request.getSession();
            map = userService.login(user);
            HashMap data=(HashMap)map.get("data");
            session.setAttribute("Token",data.get("Token"));
            session.setAttribute("Id",data.get("Id"));
        } catch (Exception e) {
            logger.info("userObject:" + ExceptionUtils.getStackTraceString(e));
            e.printStackTrace();
        }
        return map;
    }

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