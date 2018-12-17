package com.qiqi.account.controller;

import com.google.common.base.Strings;
import com.qiqi.account.common.CommonResponse;
import com.qiqi.account.filter.SwaggerUIFilter;
import com.qiqi.account.utils.RandomValidateCodeUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * swagger-ui登陆页面
 *
 */
@Controller
public class SwaggerLoginController {

    private String username;

    private String password;

    /**
     * 是否是本地测试状态
     */
    private boolean local;

    public SwaggerLoginController() {
        this.username = "admin";
        this.password = "admin";
        this.local = "admin".equals(this.password);
    }

    /**
     * 展示登陆页面
     *
     * @return 页面
     */
    @RequestMapping(value = "swagger/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage() {
        return new ModelAndView("swagger_login");
    }

    /**
     * 请求验证码，并将验证码写到session中
     */
    @RequestMapping(value = "swagger/verify/code", method = RequestMethod.GET)
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    @ResponseBody
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
        randomValidateCode.getRandCode(request, response);
    }

    /**
     * 登陆验证
     */
    @RequestMapping(value = "swagger/login/check", method = RequestMethod.POST)
    @ApiOperation(value = "登陆验证", notes = "登陆验证", response = CommonResponse.class)
    @ResponseBody
    public CommonResponse loginCheck(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     @RequestParam("verifyCode") String verifyCode,
                                     HttpSession session) {
        if (local) {
            session.setAttribute(SwaggerUIFilter.SWAGGER_LOGIN_FLAG, username);
            return CommonResponse.ok();
        }
        String currentVerifyCode = (String) session.getAttribute(RandomValidateCodeUtil.RANDOM_CODE_KEY);
        if (Strings.isNullOrEmpty(currentVerifyCode)) {
            return CommonResponse.error();
        }
        if (this.username.equals(username)
                && this.password.equals(password)
                && currentVerifyCode.equalsIgnoreCase(verifyCode)) {
            session.setAttribute(SwaggerUIFilter.SWAGGER_LOGIN_FLAG, username);
            return CommonResponse.ok();
        }
        return CommonResponse.error();
    }

}
