package com.evan.wj.controller;

import com.evan.wj.mapper.UserMapper;
import com.evan.wj.pojo.User;
import com.evan.wj.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
@Controller
public class LoginController {

    @Resource
    UserMapper userMapper;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String userName = requestUser.getUserName();
        userName = HtmlUtils.htmlEscape(userName);
        User user = userMapper.getByUserNameAndPassword(userName, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {

            session.setAttribute("user", user);
//            System.out.println(user);
            return new Result(200);
        }
    }
}
