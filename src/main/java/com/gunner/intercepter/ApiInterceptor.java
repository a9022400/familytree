package com.gunner.intercepter;

import com.gunner.model.dto.Token;
import com.gunner.util.TokenUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Msater Zg on 2017/4/5.
 * 拦截器
 */
@Component
public class ApiInterceptor implements HandlerInterceptor {

    /**
     * 在执行Handler之前进行，即Controller方法调用之前执行，主要进行初始化操作。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Token token= (Token) request.getSession().getAttribute("Token");
        Integer Id= (Integer) request.getSession().getAttribute("Id");
        if(!TokenUtils.volidateToken(token.getSignature(),Id)){
            System.out.println("preHandle：拦截了");
            return false;
        }
        return true;
    }

    /**
     * 在执行Handler之后进行，即Controller 方法调用之后执行，主要对ModelAndView对象进行操作。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle:拦截了");
    }

    /**
     * 在整个请求结束之后，即渲染对应的视图之后执行, 主要进行资源清理工作。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion:拦截了");
    }
}