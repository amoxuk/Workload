package com.hfut.controller.findPsw;

import com.hfut.entity.User;
import com.hfut.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FindPsw {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/password/getQuestion",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String getQuestion(User user) throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        if (session.getAttribute("rand") == null || !session.getAttribute("rand").toString().equalsIgnoreCase(user.getMail())) {
            return "{\"status\":1,\"msg\":\"请重新输入验证码！\"}";
        }
        User nUser =  userService.findByName(user.getUser());
        if (nUser != null) {
            return "{\"status\":0,\"msg\":\"" + nUser.getQuestion() + "\"}";
        } else {
            return "{\"status\":1,\"msg\":\"请检查用户名！\"}";
        }
    }
    @RequestMapping(value = "/password/resetPsw",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String resetPsw(User user) throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        if (session.getAttribute("rand") == null || !session.getAttribute("rand").toString().equalsIgnoreCase(user.getMail())) {
            return "{\"status\":1,\"msg\":\"请重新输入验证码！\"}";
        }
        String retErr = "{\"status\":1,\"msg\":\"请检查用户名！\"}";

        User nUser =  userService.findByName(user.getUser());
        if (nUser != null) {
            if (nUser.getQuestion() != user.getQuestion()) {
                return retErr;
            }
            return "{\"status\":0,\"msg\":\"" + nUser.getQuestion() + "\"}";
        } else {
            return retErr;
        }
    }
}
