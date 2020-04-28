package com.example.shop.shiro;

import com.example.shop.dao.RolePermissionExample;
import com.example.shop.dao.UserExample;
import com.example.shop.entity.RolePermission;
import com.example.shop.entity.User;
import com.example.shop.entity.UserRole;
import com.example.shop.service.PermissionService;
import com.example.shop.service.RoleService;
import com.example.shop.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Customrealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username= (String) principalCollection.getPrimaryPrincipal();
        //从数据库或者缓存中获取角色数据
        Set<String> roles = getRolesByName(username);
        //从数据库或者缓存中获取权限数据
        Set<String> permissions = getPermissonsByName(username);
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    private Set<String> getRolesByName(String username) {
        List<UserRole> userRoleList=roleService.selectByName(username);
        Set<String> set = new HashSet<>();
        if(userRoleList != null){
            for(UserRole userRole:userRoleList){
                set.add(userRole.getRolename());
            }
            return set;
        }
        return null;
    }

    private Set<String> getPermissonsByName(String username) {
        //可能有多个角色
        List<UserRole> userRoleList=roleService.selectByName(username);
        if(userRoleList != null) {
            RolePermissionExample example = new RolePermissionExample();
            example.setDistinct(true);
            example.setOrderByClause("pid asc");
            for(UserRole userRole:userRoleList){
                example.or().andRolenameEqualTo(userRole.getRolename());
            }
            //查询所有角色包含的所有权限
            List<RolePermission> permissionList = permissionService.selectByExample(example);
            Set<String> set = new HashSet<>();
            if (permissionList != null) {
                for (RolePermission permission : permissionList) {
                    set.add(permission.getPermission());
                }
                return set;
            }
        }
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
        //authenticationInfo.setCredentialsSalt((ByteSource.Util.bytes(salt)));
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