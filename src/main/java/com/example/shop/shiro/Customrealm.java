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
    /**
     * 根据用户名获取角色
     * */
    private Set<String> getRolesByName(String username) {
        List<UserRole> userRoleList=roleService.selectRolesByUserName(username);
        Set<String> set = new HashSet<>();
        if(userRoleList != null){
            for(UserRole userRole:userRoleList){
                set.add(userRole.getRolename());
            }
            return set;
        }
        return null;
    }
    /**
     * 根据用户名获取权限
     * */
    private Set<String> getPermissonsByName(String username) {
        List<RolePermission> permissionList=permissionService.selectPermissionsByUserName(username);
        if(permissionList != null) {
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
        String password= getPswdByUserName(username);
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
    /**
    * 根据用户名获取用户密码
    * */
    private String getPswdByUserName(String username) {
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


    /**
     * 重写方法,清除当前用户的的 授权缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 重写方法，清除当前用户的 认证缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}