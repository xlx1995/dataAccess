package com.xlx.shiro;

import com.xlx.db.pojo.User;
import com.xlx.service.master.UserService;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/27
 */
public class MyRealm extends AuthorizingRealm {

    @Override
    public void setName(String name) {
        super.setName("MyRealm");
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取已认证的用户
//        User primaryPrincipal = (User) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roleSet = new HashSet<>();
        Set<String> rolePermission = new HashSet<>();
        simpleAuthorizationInfo.setRoles(roleSet);
        simpleAuthorizationInfo.setStringPermissions(rolePermission);
        return simpleAuthorizationInfo;
    }

    @Autowired
    private UserService userService;

    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String password = new String((char[])usernamePasswordToken.getPassword());
        User user = userService.findByUsername(username);
        String password1 = user.getPassword();
        if(username == null){
            throw new AuthenticationException("没有这个用户");
        }else if(!password.equals(password1)){
            throw new AuthenticationException("密码错误");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,password1,this.getName());
        return simpleAuthenticationInfo;
    }
}
