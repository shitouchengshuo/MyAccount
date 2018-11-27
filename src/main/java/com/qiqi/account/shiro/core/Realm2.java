package com.qiqi.account.shiro.core;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * 权限检查类
 */
public class Realm2 extends AuthorizingRealm {
	private static final Logger logger = Logger.getLogger(Realm2.class);
//	@Autowired
//	private SysUserService sysUserService;
//	@Autowired
//	private SysSessionService sysSessionService;
//	@Autowired
//	private SysAuthorizeService sysAuthorizeService;

	// 权限
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		//从request.getSession()  session中取SysUser
//		Integer userId = WebUtil.getCurrentUser();
//		//从sys_user表中取
//		SysUser sysUser = sysUserService.queryById(userId);
//		if (sysUser.getUserType() != 1) {
//			userId = null;
//		}
//		List<String> list = sysAuthorizeService.queryPermissionByUserId(userId);
//		for (String permission : list) {
//			if (StringUtils.isNotBlank(permission)) {
//				// 添加基于Permission的权限信息
//				info.addStringPermission(permission);
//			}
//		}
//		// 添加用户权限
//		info.addStringPermission("user");
		return info;
	}

	// 登录验证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("countSql", 0);
		params.put("enable", 1);
		params.put("account", token.getUsername());
//		PageInfo<SysUser> pageInfo = sysUserService.query(params);
//		if (pageInfo.getSize() == 1) {
//			SysUser user = pageInfo.getList().get(0);
//			StringBuilder sb = new StringBuilder(100);
//			for (int i = 0; i < token.getPassword().length; i++) {
//				sb.append(token.getPassword()[i]);
//			}
//			if (user.getPassword().equals(sb.toString())) {
//				WebUtil.saveCurrentUser(user.getId());
//				saveSession(user.getAccount());
//				AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(),
//						user.getUserName());
//				return authcInfo;
//			}
//			logger.warn("USER"+token.getUsername()+" PASSWORD IS WRONG:"+sb.toString());
			return null;
//		} else {
//			logger.warn("No user: "+ token.getUsername());
//			return null;
//		}
	}

	/** 保存session */
	private void saveSession(String account) {
		// 踢出用户--删除sys_session及从sessionRedisOperations删除
//		sysSessionService.deleteByAccount(account);
//		SysSession record = new SysSession();
//		record.setAccount(account);
//		Subject currentUser = SecurityUtils.getSubject();
//		Session session = currentUser.getSession();
//		record.setSessionId(session.getId().toString());
//		String host = (String) session.getAttribute("HOST");
//		record.setIp(StringUtils.isBlank(host) ? session.getHost() : host);
//		record.setStartTime(session.getStartTimestamp());
//		sysSessionService.update(record);
	}
}
