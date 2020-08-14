package com.aaa.ssm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * fileName:UserController
 * description:
 * author:zz
 * createTime:2019/11/23 15:52
 * version:1.0.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    /**
     * 跳转登录
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @Autowired
    private HttpSession session;
    /**
     * 登录
     * @param userName
     * @param passWord
     * @param model
     * @return
     */
    @RequestMapping("login")
    public String login(String userName, String passWord, Model model){
        //收集用户信息
        AuthenticationToken token = new UsernamePasswordToken(userName,passWord);
        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //登录
            currentUser.login(token);
            Map userMap   = (Map)currentUser.getPrincipal();
            //登录后存放Session
            currentUser.getSession().setAttribute("userInfo",userMap);
            System.out.println(userMap);
            //currentUser.logout();
        }catch (AccountException e){
            session.setAttribute("errorInfo","用户名错误");
        }catch (IncorrectCredentialsException e){
            session.setAttribute("errorInfo","密码错误");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            session.setAttribute("errorInfo","用户名或者密码错误");
        }
        return "redirect:/dept/list.do";
    }
}
