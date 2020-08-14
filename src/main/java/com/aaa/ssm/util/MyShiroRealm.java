package com.aaa.ssm.util;

import com.aaa.ssm.service.RoleService;
import com.aaa.ssm.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * fileName:MyShiroRealm
 * description:
 * author:zz
 * createTime:2019/11/23 15:21
 * version:1.0.0
 */
//本身已经在spring整合shiro中配置为bean 不需要注解
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取认证成功后保存的用户信息
        Map userMap  = (Map)principalCollection.getPrimaryPrincipal();
        //获取该用户拥有的所有角色列表
        List<Map> roleMapList = roleService.getListByUserId(Integer.valueOf(userMap.get("USER_ID") + ""));
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if(roleMapList!=null&&roleMapList.size()>0){
            for (Map map : roleMapList) {
                simpleAuthorizationInfo.addRole(map.get("ROLE_NAME")+"");
            }
        }
        //如果权限表已经做了
      //  simpleAuthorizationInfo.addStringPermission(); //或者
       // simpleAuthorizationInfo.addObjectPermissions();
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取controller中收集到的用户名
        Object userName = authenticationToken.getPrincipal();
        Map map  = new HashMap<>();
        map.put("userN",userName);
        //根据用户名查询用户信息
        List<Map> userMapList = userService.getList(map);
        if(userMapList!=null&&userMapList.size()>0){
            Map userMap = userMapList.get(0);
            return  new SimpleAuthenticationInfo(userMap,userMap.get("PASSWORD")+"",getName());
        }
        return null;
    }
}
