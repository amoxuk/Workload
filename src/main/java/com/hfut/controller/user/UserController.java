package com.hfut.controller.user;

import com.alibaba.fastjson.JSON;
import com.hfut.entity.AjaxResult;
import com.hfut.entity.User;
import com.hfut.exception.CustomException;
import com.hfut.service.UserService;
import com.hfut.util.Encryp;
import com.hfut.util.ToolKit;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/logout", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "../auth/author.html";
    }

    //登录表单处理
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String login(User user) throws Exception {
        //Shiro实现登录
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();

        if (session.getAttribute("rand") == null || !session.getAttribute("rand").toString().equalsIgnoreCase(user.getMail())) {
            return "{\"status\":1,\"msg\":\"请重新输入验证码！\"}";
        }
        System.out.println(user.getUser() + " " + user.getPassword());

        String psw = ToolKit.psw2pwd(user.getPassword());

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUser(),
                psw);
        Subject subject = SecurityUtils.getSubject();

        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        subject.login(token);

        if (subject.hasRole("教师")) {
            return "{\"status\":0,\"msg\":\"/teacher/myzone.html\"}";
        } else if (subject.hasRole("超级管理员")) {
            return "{\"status\":0,\"msg\":\"/Admin/index.html\"}";
        }

        return "{\"status\":1,\"msg\":\"/author.html\"}";
    }

    @RequestMapping(value = "/user/password",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            method = {RequestMethod.POST})
    @ResponseBody
    //修改密码
    public String password(@RequestParam(name = "name") String name,
                           @RequestParam(name = "oldPsw") String old,
                           @RequestParam(name = "newPsw") String newpsw
                           ) throws Exception {
        Subject currentUser = SecurityUtils.getSubject();


        old = ToolKit.psw2pwd(old);

        newpsw = ToolKit.psw2pwd(newpsw);


        AjaxResult result = new AjaxResult();
        String username = currentUser.getPrincipal().toString();
        User user = userService.findByName(username);
        if (null == user || !username.equals(name)) {
            result.failed();
            result.setMsg("修改用户名与当前用户名不匹配。");
            return JSON.toJSONString(result);
        } else if (!user.getPassword().equals(old)) {
            result.failed();
            result.setMsg("旧密码不正确。");
            return JSON.toJSONString(result);
        }

        try {

            user.setPassword(newpsw);
            System.out.println(user);

            userService.alterPassword(user);
            result.ok();
            result.setMsg("修改成功，重新登录。");
            return JSON.toJSONString(result);
        } catch (Exception e) {

            throw new CustomException("请检查数据是否正确");
        }

    }

    /*   @RequestMapping(value = "/register",
               produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8",
               method = {RequestMethod.POST})
       @ResponseBody
       //注册
       public String register(User account) throws Exception {
           //System.out.println(account.getName() + " " + account.getPsw() + " " + account.getMail());
           account.setLevel(0);



           //解密DES
           account.setPsw(new DesUtil().strDec(account.getPsw(), "amoxu", "amoxu", "amoxu"));
           //加密MD5 32
           System.out.println(account.getPsw());
           account.setPsw(new Encryption().encryptionStr(account.getPsw() + "amoxu", "MD5"));
           System.out.println(account.getPsw());
           userService.register(account);
           UsernamePasswordToken token = new UsernamePasswordToken(account.getName(),
                   account.getPsw());
           Subject subject = SecurityUtils.getSubject();
           //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
           subject.login(token);
           if (subject.hasRole("用户")) {
               return "{\"status\":\"success\",\"result\":\"/index.html\"}";
           }

           return "{\"status\":\"failed\",\"result\":\"注册失败\"}";
       }*/
    @RequestMapping(value = "/auth/find",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            method = {RequestMethod.POST})
    @ResponseBody
    //注册
    public String forget(HttpServletRequest request) throws Exception {
        //System.out.println(account.getName() + " " + account.getPsw() + " " + account.getMail());

        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        String username = request.getParameter("user");
        String captcha = request.getParameter("captcha");
        if (session.getAttribute("rand") == null || !session.getAttribute("rand").toString().equalsIgnoreCase(captcha)) {
            return "{\"status\":1,\"msg\":\"请重新输入验证码！\"}";
        }

        AjaxResult result = new AjaxResult();
        User user = userService.findByName(username);
        if (null != user) {
            result.ok();
            String md5 = Encryp.encryptionStr(new Random().nextInt(256) + new Date().getTime() + username, Encryp.MD5);
            result.setMsg(md5);
            session.setAttribute("md5", md5);
            session.setAttribute("anser", user.getAnswer());
            List list = new ArrayList();
            list.add(user.getQuestion());
            result.setData(list);
        }
        return JSON.toJSONString(result);

    }

    @RequestMapping(value = "/auth/anser",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            method = {RequestMethod.POST})
    @ResponseBody
    //重置密码
    public String reset(HttpServletRequest request) throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        String username = request.getParameter("user");
        String captcha = request.getParameter("captcha");
        String md5 = request.getParameter("md5");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        String password = request.getParameter("password");

        if (session.getAttribute("rand") == null || !session.getAttribute("rand").toString().equalsIgnoreCase(captcha)) {
            return "{\"status\":1,\"msg\":\"请重新输入验证码！\"}";
        }
        boolean ss = !session.getAttribute("md5").toString().equals(md5);
        System.out.println(session.getAttribute("md5").toString());
        System.out.println(request.getParameter("md5"));

        if (session.getAttribute("MD5") != null && ss) {
            return "{\"status\":1,\"msg\":\"请刷新重试！\"}";
        }

        String psw = Encryp.strDec(password, "amoxu", "amoxu", "amoxu");

        System.out.println(psw);
        //加密MD5 32
        psw = Encryp.encryptionStr(psw + "amoxu", Encryp.MD5);
        AjaxResult result = new AjaxResult();

        try {
            User user = userService.findByName(username);

            if (user.getAnswer() != null && user.getAnswer().equals(answer) && user.getQuestion().equals(question)) {
                user.setPassword(psw);
                userService.updateUser(user);
                currentUser.logout();
                System.out.println(psw);
                result.ok();
                result.setMsg("修改成功，重新登录。");
                return JSON.toJSONString(result);

            } else {
                result.failed();
                result.setMsg("答案错误。");
                return JSON.toJSONString(result);
            }

        } catch (Exception e) {
            throw new CustomException("请检查数据是否正确");
        }

    }

    @RequestMapping(value = "/zone/getDetail",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            method = {RequestMethod.GET})
    @ResponseBody
    //获取当前用户信息
    public String getDetail() throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        AjaxResult ajaxResult = new AjaxResult();
        User user = userService.findByName(currentUser.getPrincipal().toString());
        if (user != null) {
            List list = new ArrayList();
            user.setPassword(user.getPassword().replaceAll("\\S", "*"));
            user.setAnswer(user.getAnswer().replaceAll("\\S", "*"));
            list.add(user);
            ajaxResult.setData(list);
            ajaxResult.ok();
        } else {
            ajaxResult.failed();
            ajaxResult.setMsg("请重新登录重试。");
        }
        return JSON.toJSONString(ajaxResult);
    }



    @RequestMapping(value = "/zone/update",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            method = {RequestMethod.POST})
    @ResponseBody
    //重置密码
    public String update(HttpServletRequest request) throws Exception {
        Subject currentUser = SecurityUtils.getSubject();

        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");


        AjaxResult result = new AjaxResult();
        String username = currentUser.getPrincipal().toString();
        User user = userService.findByName(username);
        if (null == user) {
            result.failed();
            result.setMsg("请重新登录后重试。");
            return JSON.toJSONString(result);
        }

        user.setQuestion(question);
        user.setAnswer(answer);
        user.setMail(mail);
        user.setUser(name);


        try {

            userService.updateUser(user);
            currentUser.logout();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUser(),
                    user.getPassword());

            Subject subject = SecurityUtils.getSubject();

            //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
            subject.login(token);

            result.ok();
            result.setMsg("修改成功。");
            return JSON.toJSONString(result);
        } catch (Exception e) {
            e.printStackTrace();

            throw new CustomException("请重新登录后重试。");
        }

    }


}