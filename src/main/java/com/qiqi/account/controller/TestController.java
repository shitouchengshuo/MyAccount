package com.qiqi.account.controller;

import com.qiqi.account.common.CommonResponse;
import com.qiqi.account.service.TestService;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Api(value = "swagger测试接口", description = "swagger测试接口")
public class TestController{

	@Autowired
	private TestService testService;

	private static final Logger logger = Logger.getLogger(TestController.class);

	public final static String authorizationcode = "";



	/**
	 * 登录入口,跳转到login.jsp
	 */
	@RequestMapping("/login")
	@ApiOperation("登录入口")
	@ApiResponses(value = {
			@ApiResponse(code = 0, message = "正常情况", response = CommonResponse.class),
			@ApiResponse(code = 2, message = "数据格式错误", response = CommonResponse.class),
			@ApiResponse(code = 14, message = "用户未绑定异常", response = CommonResponse.class),
			@ApiResponse(code = 35, message = "解绑一个没有权限的userId和Mac异常", response = CommonResponse.class),
	})
	public String login(HttpServletRequest request, HttpServletResponse response, Model model,
						@ApiParam(required = false, value = "verificationcode")
						@RequestParam(value = "verificationcode", required = false) String verificationcode) throws Exception {
		return "login";
	}

	/**
	 * swagger登录
	 */
	@RequestMapping("swagger_login")
	@ApiOperation("swagger登录入口")
	public String swaggerLoginPage(HttpServletRequest request, Model model) throws Exception {
		return "swagger_login";
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
	 * 注册
	 */
	@RequestMapping("registerPage")
	@ApiOperation("注册入口")
	public String registerPage(HttpServletRequest request, Model model) throws Exception {
		return "register";
	}

}
