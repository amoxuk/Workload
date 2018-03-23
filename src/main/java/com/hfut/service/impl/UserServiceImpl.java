package com.hfut.service.impl;

import com.hfut.entity.User;
import com.hfut.entity.UserExample;
import com.hfut.exception.CustomException;
import com.hfut.mapper.UserMapper;
import com.hfut.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

 /*   private SimpleMailMessage mailMessage;
    private JavaMailSender mailSender;*/

    @Override
    public User findByName(String name) throws Exception {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserEqualTo(name);
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }

    }

    @Override
    public boolean register(User user) throws Exception {

        System.out.println("user register:" + user.getUser() + " " + user.getPassword() + " " + user.getMail());
        if (StringUtils.isEmpty(user.getUser()) || StringUtils.isEmpty(user.getPassword())) {
            throw new CustomException("用户或密码不能为空！");
        } else if (StringUtils.isEmpty(user.getMail())) {
            throw new CustomException("邮箱不能为空！");
        } else if (user.getPassword().length() < 6) {
            throw new CustomException("密码过短！");
        }

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserEqualTo(user.getUser());
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size() != 0) {
            throw new CustomException("账号已存在！");
        }
        userExample = new UserExample();
        criteria = userExample.createCriteria();
        criteria.andMailEqualTo(user.getMail());
        list = userMapper.selectByExample(userExample);
        if (list.size() != 0) {
            throw new CustomException("邮箱已存在！");
        }
        int ret = userMapper.insert(user);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean removeById(int id) throws Exception {
        if (10000 == id) {
            return false;
        }

        if (userMapper.deleteByPrimaryKey(id) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Transient
    @Override
    public void updateUser(User user) throws CustomException {
        user.setPassword(userMapper.selectByPrimaryKey(user.getId()).getPassword());
        user.setAnswer(userMapper.selectByPrimaryKey(user.getId()).getAnswer());

        Subject subject = SecurityUtils.getSubject();
        int ret;
        if (10000 == user.getId()) {
            if (subject.hasRole("超级管理员")) {
                ret = userMapper.updateByPrimaryKey(user);
            } else {
                throw new CustomException("权限不足");
            }
        } else {
            ret = userMapper.updateByPrimaryKey(user);
        }

        if (ret == 1) {
            return;
        } else {
            throw new CustomException("更新失败，请联系管理员。");
        }
    }

    @Transient
    @Override
    public void alterPassword(User user) throws CustomException {
        user.setAnswer(userMapper.selectByPrimaryKey(user.getId()).getAnswer());
        int ret = userMapper.updateByPrimaryKey(user);
        if (ret == 1) {
            return;
        } else {
            throw new CustomException("更新失败，请联系管理员。");
        }
    }


    @Override
    public List<User> getList(Integer page, Integer limit) throws Exception {
        UserExample example = new UserExample();
        example.setLimit(limit);
        if (page != 0) {
            page -= 1;
        }
        example.setOffset(page);
        List<User> list = userMapper.selectByExample(example);
        for (User user : list) {
            user.setPassword("*****");
            user.setAnswer("****");
        }
        return list;
    }

    @Override
    public List<User> getList(int typeId, int page, int limit) throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andLevelEqualTo(typeId);
        example.setLimit(limit);
        if (page != 0) {
            page -= 1;
        }
        example.setOffset(page);
        List<User> list = userMapper.selectByExample(example);
        for (User user : list) {
            user.setPassword("*****");
            user.setAnswer("****");
        }
        return list;
    }


    @Override
    public boolean addUser(User user) {
        Subject subject = SecurityUtils.getSubject();

        int ret;

        if (subject.hasRole("超级管理员")) {
            ret = userMapper.insert(user);
        } else {
            if (user.getLevel() > 0) {
                return false;
            } else {
                ret = userMapper.insert(user);
            }
        }
        if (0 != ret) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean removeUser(ArrayList<Integer> list) {
        boolean re = false;
        try {
            for (int i : list) {
                removeById(i);
            }
            re = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return re;
    }

    @Override
    public List<User> selectLike(String s, Integer page, Integer limit) {
        if (page != 0) {
            page -= 1;
        }
        List<User> list = userMapper.selectByLike(s, page, limit);
        System.out.println(list);
        return list;
    }

    @Override
    public int countLike(String s) {
        return userMapper.countByLike(s);
    }

   /* public void setMailMessage(SimpleMailMessage mailMessage) {
        this.mailMessage = mailMessage;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void saveOrUpdate(final User entity) {


        //final就是延长对象的生命周期，不然entity只能在saveOrUpdate中使用，使用完成后方法弹栈，而run方法内就无法再使用之前定义好的entity。
        //使用spring与javaMail实现新员工入职时邮件的发送
        //使用线程并try-catch的目的就是如果邮件发送失败，也不影响信息保存到数据库。邮件发送成为了一个独立的过程。
        Thread th = new Thread(new Runnable() {
            public void run() {
                try {
                    mailMessage.setTo(new String());
                    mailMessage.setSubject(new String());
                    mailMessage.setText(new String());
                    mailSender.send(mailMessage);
                } catch (MailException e) {
                    e.printStackTrace();
                }
            }
        });
        th.start();


    }*/
}

