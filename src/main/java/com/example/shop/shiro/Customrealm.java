package com.example.shop.shiro;

import com.example.shop.dao.UserExample;
import com.example.shop.entity.User;
import com.example.shop.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Customrealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获得用户名/手机号/邮箱
        String username= (String) authenticationToken.getPrincipal();
        //通过用户名到数据库获取凭证
        String password= getPswdByName(username);
        if(password == null){
            return null;
        }

        //加盐
        String salt="shop2020";
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
                username,password,"customRealm"
        );
        authenticationInfo.setCredentialsSalt((ByteSource.Util.bytes(salt)));
        return authenticationInfo;
    }

    private String getPswdByName(String username) {
        UserExample userExample=new UserExample();
        userExample.or().andUnameEqualTo(username);
        userExample.or().andUtelEqualTo(username);
        userExample.or().andUemlEqualTo(username);
        User user=userService.selectByName(userExample);
        if(user != null){
          return user.getUpswd();
        }
        return null;
    }
}