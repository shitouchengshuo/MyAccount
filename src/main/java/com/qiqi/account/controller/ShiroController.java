package com.qiqi.account.controller;

import com.qiqi.account.service.ShiroService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/ui/")
public class ShiroController{

	@Autowired
	private ShiroService shiroService;

//	@Autowired
//	private SysUserService sysUserService;

	private static final Logger logger = Logger.getLogger(ShiroController.class);


	/**
	 * 登录入口,跳转到login.jsp
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		return "login";
	}

	/**
	 * 登录成功跳转到success.jsp
	 */
	@RequestMapping("success")
	public String success(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		System.out.println("++++++++++登录成功++++++++++");
		return "success";
	}

	/**
	 * 用于测试
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		return "login";
	}

	/**
	 * 用于测试权限
	 */
	@RequestMapping("admin")
    public String admin() throws Exception {
        return "admin";
    }

	/**
	 * 用于测试权限
	 */
	@RequestMapping("user")
	public String user(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		return "user";
	}

	//没有权限时跳转的页面
	@RequestMapping("unauthorized")
	public String unauthorized(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		return "unauthorized";
	}

	//测试Shiro Service层的权限注解@RequiresRoles({"admin"})
	@RequestMapping("testShiroAnnocation")
	public String testShiroAnnocation(HttpSession session) throws Exception {
		session.setAttribute("test", "Hello1234");
		shiroService.testMethod();
		return "success";
	}
	//testShiroAnnocation
	/**
	 * 登录认证：验证用户名和密码
	 * @return
	 */
	@RequestMapping(value = "checkLogin", method = RequestMethod.POST)
	@ResponseBody
	public String login(String username, String password){
		//获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		//测试当前用户是否已经被认证(即是否已经登录)
		if (!currentUser.isAuthenticated()){
			//将用户名与密码封装为UsernamePasswordToken对象
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			//设置rememberMe记录用户
			token.setRememberMe(true);
			try {
				//调用Subject的login方法执行登录
				currentUser.login(token);
			} catch (UnknownAccountException uae) {
				logger.warn("不存在用户 " + token.getPrincipal());
				return "{\"error\":\"7\"}";
			} catch (IncorrectCredentialsException ice) {
				logger.warn("用户 " + token.getPrincipal() + " 密码错误!");
				return "{\"error\":\"8\"}";
			} catch (LockedAccountException lae) {
				logger.warn("用户 " + token.getPrincipal() + " 被锁定!");
				return "{\"error\":\"15\"}";
			} catch (AuthenticationException ae) {
				logger.warn("用户:" + token.getPrincipal() + " 登录失败!");
			}
		}
		//登录成功
		return "{\"error\":\"0\"}";
	}

	/**
	 *  退出登录
	 */
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	@ResponseBody
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
		return "{\"error\":\"0\"}";
	}
}
