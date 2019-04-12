package com.gunner.service.impl;

import com.gunner.model.dto.Token;
import com.gunner.model.pojo.User;
import com.gunner.dao.mapper.UserDao;
import com.gunner.service.UserService;
import com.gunner.util.MD5Utils;
import com.gunner.util.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author Sunmz
 * @since 2019-04-08 09:52:35
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param user 主键
     * @return 实例对象
     */
    @Override
    public HashMap login(User user) {
        //System.out.println(MD5Utils.encode2hex(user.getLoginPassword()));
        user.setLoginPassword(MD5Utils.encode2hex(user.getLoginPassword()));
        HashMap map = new HashMap();
        HashMap data = new HashMap();
        HashMap lists = new HashMap();
        ArrayList rows = new ArrayList();
        String code;
        String msg;
        User ruser = this.userDao.login(user);
        if (ruser == null) {
            code = "1";
            msg = "用户名密码错误，请重新输入！";
            data.put("msg", msg);
            data.put("lists", null);
            map.put("code", code);
            map.put("data", data);
            return map;
        }
        if ("0".equals(ruser.getStatus())) {
            code = "1";
            msg = "该用户已被禁止登录，请联系管理员";
        } else if ("1".equals(ruser.getStatus()) || "2".equals(ruser.getStatus())) {
            if ("1".equals(ruser.getStatus())) {
                msg = "登录成功！";
            } else {
                msg = "请先修改密码！";
            }
            code = "0";
            rows.add(ruser);
            lists.put("rows", rows);
            data.put("lists", lists);
            data.put("Token", TokenUtils.generateToken(ruser.getUuid(), ruser.getId()));
            data.put("Id", ruser.getId());
        } else {
            code = "1";
            msg = "未知的错误！";
        }
        data.put("msg", msg);
        map.put("code", code);
        map.put("data", data);
        return map;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(User user, int offset, int limit) {
        return this.userDao.queryAllByLimit(user, offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.remove(id) > 0;
    }
}