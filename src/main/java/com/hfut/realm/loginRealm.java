package com.hfut.realm;

import com.hfut.entity.User;
import com.hfut.exception.CustomException;
import com.hfut.service.UserRoleService;
import com.hfut.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jacey on 2017/6/30.
 */

@Component
public class loginRealm extends AuthorizingRealm{
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Resource(name = "userRoleServiceImpl")
    private UserRoleService userRoleService;

    /**
     * 获取身份信息，我们可以在这个方法中，从数据库获取该用户的权限和角色信息
     *     当调用权限验证时，就会调用此方法
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String teacherName = (String) getAvailablePrincipal(principalCollection);
        com.hfut.entity.UserRole role = null;

        try {

            User userlogin = userService.findByName(teacherName);

            //获取角色对象
            role = userRoleService.findByid(userlogin.getLevel());
        } catch (Exception e) {
            try {
                throw new CustomException("用户不存在或密码错误");
            } catch (CustomException e1) {
                e1.printStackTrace();
            }
        }
        //通过用户名从数据库获取权限/角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<String>();
        if (role != null) {
            r.add(role.getName());
            info.setRoles(r);
        }

        return info;

    }

    /**
     * 在这个方法中，进行身份验证
     *         login时调用
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户名
        String username = (String) token.getPrincipal();
        //密码
        String password = new String((char[])token.getCredentials());
       User userlogin = null;
        try {
            userlogin = userService.findByName(username);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userlogin == null) {
            //没有该用户名
            throw new UnknownAccountException();
        } else if (!password.equals(userlogin.getPassword())) {
            //密码错误
            throw new IncorrectCredentialsException();
        }
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username,password,getName());

        //身份验证通过,返回一个身份信息

        return aInfo;
    }
}
