<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns:wb="http://open.weibo.com/wb">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<link href="../public/images/phicomm.png" type="image/x-icon" rel=icon>
	<link href="../public/images/phicomm.png" type="image/x-icon">
	<link rel="stylesheet" href="../public/css/bootstrap.min.css">
	<link rel="stylesheet" href="../public/css/common.css">
	<link rel="stylesheet" href="../public/css/login.css">
	<script src="../public/js/jquery-1.11.1.min.js"></script>
	<script src="../public/js/bootstrap.min.js"></script>
	<script src="../public/js/common.js"></script>
	<script src="../public/js/jqueryCookie.js"></script>
	<script src="${pageContext.request.contextPath}/js/login.js"></script>
	<script>
var context = "${pageContext.request.contextPath}";
window.onload=function () {
    var type = "${type}";
    if(type == 'thirdParty'){
        $('#pass-phoenix-login').hide();
        alert("尚未与账户绑定,请先注册或者绑定账户");
    }
}
</script>
<title>账户-登录</title>
</head>
<body>
	<div class="wrapper">
		<div class="wrap">
			<div class="layout">
				<div class="header_tit t_c">
					<img src="../../public/images/logo_old.png" class="login_logo">
					<h4 class="header_tit_txt" id="login-title">帐号登录</h4>
				</div>
				<div class="login_area">
					<form action="${pageContext.request.contextPath}/ui/checkLogin" method="POST" id="login-main-form">
						<div class="loginbox">
							<input id="username" type="text" name="username" value="" placeholder="邮箱/手机号/帐号"  class="login_input"/>
							<input id="password" type="password" name="password" value="" placeholder="密码"  class="login_input mrg_top"/>
							<div class="btns_bg">
		                    	<input onclick="submitLogin()" style="margin-left:0px!important" class="btn btnadpt btn_orange" id="login-button" type="button" value="立即登录">		                      
		                    </div>
						</div>
					</form>
				</div>				
				<div class="n_links_area">
					<a class="outer-link" href="${pageContext.request.contextPath}/ui/registerPage">注册帐号</a>
					<span>|</span>
					<a class="outer-link" href="${pageContext.request.contextPath}/ui/resetpswPage">忘记密码？</a>
				</div>
                <div id="pass-phoenix-login" class="tang-pass-login-phoenix">
                    <div class="pass-phoenix-title">可以使用以下方式登录<span class="pass-phoenix-note"></span></div>
                    <div id="pass-phoenix-list-login" class="pass-phoenix-list clearfix pass-phoenix-list-second">
                        <div class="pass-phoenix-btn clearfix" id="pass_phoenix_btn">
                            <ul class="bd-acc-list">
                                <li class="bd-acc-tsina" id>
                                    <a class="phoenix-btn-item" title="新浪微博" onclick="forwardUrl('${pageContext.request.contextPath}/bind/sina')" href="javascript:;" >
                                        <img src="${pageContext.request.contextPath}/public/images/associate/weibo.jpg" alt="新浪微博" title="新浪微博" class="bd-acc-img">
                                    </a>
                                </li>
                                <li class="bd-acc-tsina" id>
                                    <a class="phoenix-btn-item" title="QQ帐号" onclick="forwardUrl('${pageContext.request.contextPath}/bind/qq')" href="javascript:;">
                                        <img src="${pageContext.request.contextPath}/public/images/associate/qq.jpg" alt="腾讯" title="腾讯" class="bd-acc-img">
                                    </a>
                                </li>
                                <li class="bd-acc-tsina" id>
                                    <a class="phoenix-btn-item" title="微信帐号" onclick="forwardUrl('${pageContext.request.contextPath}/bind/sina')" href="javascript:;">
                                        <img src="${pageContext.request.contextPath}/public/images/associate/weixin.jpg" alt="微信" title="微信" class="bd-acc-img">
                                    </a>
                                </li>

                            </ul>
                        </div>
                    </div>
                   <%-- <a href="javascript:;" onclick="forwardUrl('${pageContext.request.contextPath}/bind/sina')">微博登录</a>--%>
                </div>
				<div class="copyright"></div>
			</div>
		</div>
	</div>
</body>
</html>