package com.hfut.controller.user;

import com.alibaba.fastjson.JSON;
import com.hfut.entity.AjaxResult;
import com.hfut.entity.User;
import com.hfut.service.UserService;
import com.hfut.util.ToolKit;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RoleController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/user/list",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String getList(@RequestParam(name = "page") Integer page, @RequestParam(name = "limit") Integer limit) throws Exception {
        AjaxResult<User> result = new AjaxResult<>();

        result.setData(userService.getList(page, limit));
        result.ok();
        return result.toString();
    }

    @RequestMapping(value = "/user/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String updateUser(User user) throws Exception {
        AjaxResult<User> result = new AjaxResult<>();
        userService.updateUser(user);
        result.ok();
        return result.toString();
    }

    @RequestMapping(value = "/user/delete",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String deleteUser(User user) throws Exception {
        AjaxResult<User> result = new AjaxResult<>();
        if (userService.removeById(user.getId())) {
            result.ok();
        } else {
            result.failed();
        }
        return result.toString();
    }

    @RequestMapping(value = "/user/delete/list",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String deleteTeacher(@RequestParam(name = "data") String s) {
        ArrayList<Integer> list = (ArrayList<Integer>) JSON.parseArray(s, Integer.class);
        AjaxResult result = new AjaxResult();
        if (userService.removeUser(list)) {
            result.ok();
        } else {
            result.failed();
            result.setMsg("用户不存在");
        }
        return result.toString();
    }

    @RequestMapping(value = "/user/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String addUser(User account) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.hasRole("超级管理员")) {
            account.setLevel(0);
        }
        AjaxResult result = new AjaxResult();
        account.setPassword(ToolKit.psw2pwd(account.getPassword()));

        if (!userService.register(account)) {
            result.failed();
            result.setMsg("注册失败");
        } else {
            result.ok();
        }
        return result.toString();
    }

    @RequestMapping(value = "/user/search",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String searchUser(@RequestParam(name = "s") String s,
                             @RequestParam(name = "page") Integer page,
                             @RequestParam(name = "limit") Integer limit) throws Exception {
        AjaxResult result = new AjaxResult();
        List<User> list = userService.selectLike(s, page, limit);
        result.setData(list);
        result.setCount(userService.countLike(s));
        result.ok();
        return result.toString();
    }


}
