package com.qiqi.account.shiro.core;

import com.qiqi.account.utils.MD5Util;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.*;

/**
 * 权限检查类
 */
public class Realm extends AuthorizingRealm {

	private static final Logger logger = Logger.getLogger(Realm.class);
	//这里因为没有调用后台，直接默认只有一个用户("qiqi"，"123456")
	private static final String USER_NAME = "qiqi";
	private static final String PASSWORD = "123456";

	/*
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		/**
		 * 从数据库加载当前用户的角色，例如：[admin]
		 * authorizationInfo.setRoles(new HashSet<String>(sysusersservice.getSysRoles(username)));
		 * 从数据库加载当前用户可以访问的资源，例如：[index.jsp, abc.jsp]
		 *  authorizationInfo.setStringPermissions(new HashSet<String>(sysusersservice.getSysResource(username)));
		 */
		Set<String> roleNames = new HashSet<>();
		Set<String> permissions = new HashSet<String>();
		roleNames.add("administrator");//添加角色
		permissions.add("newPage.jhtml");  //添加权限
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
		info.setStringPermissions(permissions);
		return info;
	}

	/*
	 * 登录验证  只有调用自己调用Subject subject.login(token)才会调用该方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		if(token.getUsername().equals(USER_NAME)){
			return new SimpleAuthenticationInfo(USER_NAME, MD5Util.MD5(PASSWORD), getName());
		}else{
			throw new AuthenticationException();
		}
	}

}
