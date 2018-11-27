package com.qiqi.account.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.qiqi.account.exception.AccountNotExistException;
import com.qiqi.account.utils.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/ui/")
public class WebController{

//	@Autowired
//	private WebService webService;
//	@Autowired
//	private SysUserService sysUserService;
//	public final static String authorizationcode = "SH_8";
//	private static final Logger logger = Logger.getLogger(WebController.class);
//
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		return "login";
	}

	@RequestMapping("/index.jhtml")
	public ModelAndView getIndex(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	//跳转到登录页面
	@RequestMapping("/login.jhtml")
	public ModelAndView login() throws Exception {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}


//	@RequestMapping("success")
//	public String success(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
//		System.out.println("++++++++++登录成功++++++++++");
//		return "login";
//	}


//    @RequestMapping("newPage")
//    public String newPage() throws Exception {
//        return "login";
//    }

	/**
	 * 验证用户名和密码
	 * @return
	 */
	@RequestMapping(value = "checkLogin.json", method = RequestMethod.POST)
	@ResponseBody
	public String login(String username, String password) throws AccountNotExistException {
        Map<String, Object> result = new HashMap<String, Object>();
	    try{
			UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Util.MD5(password));
			Subject currentUser = SecurityUtils.getSubject();
			if (!currentUser.isAuthenticated()){
				//使用shiro来验证
				token.setRememberMe(true);
				currentUser.login(token);//验证角色和权限
			}
		}catch(Exception ex){
			throw new AccountNotExistException("username:" + username + " not exist!");
		}
        result.put("error", 0);
        //return JSONUtils.toJSONString(result);
		return "{\"error\":\"0\"}";
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	@ResponseBody
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return JSONUtils.toJSONString(result);
	}
}
