package com.qiqi.account.shiro.core;

import com.qiqi.account.exception.AccountNotExistException;
import com.qiqi.account.shiro.model.User;
import com.qiqi.account.utils.MD5Util;
import com.qiqi.account.utils.SaltAndMD5Util;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.*;

/**
 * 权限检查类
 */
public class Realm extends AuthorizingRealm {

	private static final Logger logger = Logger.getLogger(Realm.class);


	private static Map<String,User> userMap = new HashMap<String,User>();
	static{
		//使用Map模拟数据库获取User表信息
		userMap.put("admin", new User("admin","123456",false));
		userMap.put("qiqi", new User("qiqi","123456",false));
		userMap.put("77", new User("77","123456",false));
		userMap.put("qq", new User("qq","123456",true));
	}

	/*
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		//1.从principals中获取登录用户的信息
		Object principal = principals.getPrimaryPrincipal();

		//2.利用登录用户的信息获取当前用户的角色（有数据库的话，从数据库中查询）
		Set<String> roles = new HashSet<String>();//放置用户角色的set集合(不重复)
		roles.add("user");//为所有用户添加user角色
		if("admin".equals(principal)){
			roles.add("admin");//为用户名为admin的用户添加admin角色
		}

		//3.创建SimpleAuthorizationInfo，并设置其roles属性
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

		//4.返回SimpleAuthorizationInfo对象
		return info;

	}

	/*
	 * 登录验证  只有调用自己调用Subject subject.login(token)才会调用该方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {

		//1.把AuthenticationToken转换为UsernamePasswordToken
		UsernamePasswordToken userToken = (UsernamePasswordToken) authcToken;

		//2.从UsernamePasswordToken中获取username
		String username = userToken.getUsername();

		//3.调用数据库的方法，从数据库中查询Username对应的用户记录
		System.out.println("从数据库中获取用户："+username+"所对应的信息。");
		//Map模拟数据库取数据
		User user = userMap.get(username);

		//4.若用户不行存在，可以抛出UnknownAccountException
		if(user==null){
			System.out.println("用户："+username+"不存在");
			throw new UnknownAccountException("用户："+username+"不存在");
		}

		//5.若用户被锁定，可以抛出LockedAccountException
		if(user.isLocked()){
			System.out.println("用户："+username+"不存在");
			System.out.println("用户："+username+"被锁定");
			throw new LockedAccountException("用户："+username+"被锁定");
		}

		//6.根据用户的情况，来构建AuthenticationInfo对象,通常使用的实现类为SimpleAuthenticationInfo
		//以下信息是从数据库中获取的
		//1)principal ：认证的实体信息，这里使用username，也可以是数据库表对应的用户的实体对象
		Object principal  = user.getUsername();

		//2)credentials：密码
		// 2.1 不加密
		//Object credentials = user.getPassword();
		// 2.2 MD5加密
		Object credentials = MD5Util.ShiroMD5(user.getPassword());
		// 2.3 MD5加盐加密
		//Object credentials = SaltAndMD5Util.SaltAndMD5(user.getUsername(),user.getPassword());

		//3)realmName：当前realm对象的name，调用父类的getName()方法即可
		String realmName = getName();

		//4)credentialsSalt盐值，这里使用账号作为盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(principal);

        //5)构建SimpleAuthenticationInfo对象
		// 5.1 credentials可以为不加密或者MD5加密后的密码
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal ,credentials,realmName);
		// 5.2 使用MD5加盐加密的方式
		//SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);

		return info;
	}

}
