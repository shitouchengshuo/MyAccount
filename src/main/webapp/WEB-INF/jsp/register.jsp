<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link href="../public/images/phicomm.png" type="image/x-icon" rel=icon>
<link href="../public/images/phicomm.png" type="image/x-icon">
<link rel="stylesheet" href="../public/css/bootstrap.min.css">
<link rel="stylesheet" href="../public/css/common.css">
<link rel="stylesheet" href="../public/css/login.css">
<link rel="stylesheet" href="../public/css/register.css">
<script src="../public/js/jquery-1.11.1.min.js"></script>
<script src="../public/js/bootstrap.min.js"></script>
<script src="../public/js/common.js"></script>
<script src="../public/js/jqueryCookie.js"></script>
<script>var context = "${pageContext.request.contextPath}";</script>
<script src="../js/register.js"></script>
<title>账户-注册</title>
</head>
<body>
	<div class="wrapper">
		<div class="wrap">
			<div class="layout">
				<div class="header_tit t_c">
					<img src="../public/images/logo_old.png" class="login_logo">
					<h4 class="header_tit_txt" id="login-title">注册帐号</h4>
				</div>
				<div class="login_area">
					<form action="/pass/serviceLoginAuth2" method="POST" id="login-main-form">
						<div class="loginbox">
							<input id="username" name="username" value="" placeholder="用户名"  class="login_input"/>
							<input type="text" id="phonenumber" name="phonenumber" value="" placeholder="手机号"  class="login_input mrg_top"/>
							<div>
							<input id="verificationcode" name="verificationcode"  placeholder="验证码"  class="login_input mrg_top code"/>
							<button style="background:#fff" class="getCodeDiv disabled mrg_top" id="btnSendCode">
				                获取验证码
				            </button>
							</div>
							<input type="password" id="password" name="password" value="" placeholder="密码"  class="login_input mrg_top"/>
							<input type="password" id="password2" name="confirmpassword" value="" placeholder="确认密码"  class="login_input mrg_top"/>
							<div class="btns_bg">
		                    	<input style="margin-left:0px" class="btn btnadpt btn_orange" id="login-button" type="button" value="立即注册">		                      
		                    </div>
						</div>
					</form>
				</div>				
				<!--<div class="voice_tip">
					收不到短信？请使用<span class="orange"  id="voiceVerfy">语音验证</span>
				</div>-->
				<div class="copyright">
				</div>
			</div>
		</div>
	</div>
</body>
</html>