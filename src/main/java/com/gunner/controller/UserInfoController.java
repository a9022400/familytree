package com.gunner.controller;

import com.gunner.model.dto.UserInfoDTO;
import com.gunner.model.pojo.UserInfo;
import com.gunner.model.vo.UserInfoVO;
import com.gunner.service.UserInfoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserInfo)表控制层
 *
 * @author Sunmz
 * @since 2019-04-02 09:29:19
 */
@Controller
@RequestMapping("userInfo")
public class UserInfoController {
    ModelAndView mv=new ModelAndView();
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;


    /**
     * 登录
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("login")
    public ModelAndView login(UserInfoDTO userInfoDTO) {
        mv.setViewName("allUser");
        mv.addObject("list",this.userInfoService.queryAllByLimit(userInfoDTO));
        return mv;
    }

    /**
     * 跳转
     */
    @RequestMapping("jump")
    public ModelAndView jump(String jspName) {
        mv.setViewName(jspName);
        return mv;
    }

    /**
     * 通过主键查询所有数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ResponseBody
    @RequestMapping("lists")
    public List<UserInfoVO> select(UserInfoDTO userInfoDTO) {
        return this.userInfoService.queryAllByLimit(userInfoDTO);
    }
    
    /**
     * 新增数据
     *
     * @param userInfo 主键
     * @return 单条数据
     */
    @RequestMapping("insert")
    public UserInfo insert(UserInfo userInfo) {
        return this.userInfoService.insert(userInfo);
    }
        
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("remove")
    public UserInfo delete(Integer id) {
        return this.userInfoService.queryById(id);
    }
            
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("update")
    public UserInfo update(UserInfo userInfo) {
        return this.userInfoService.update(userInfo);
    }
}