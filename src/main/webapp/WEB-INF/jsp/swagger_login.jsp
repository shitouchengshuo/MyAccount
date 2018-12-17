<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns:wb="http://open.weibo.com/wb">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link href="../public/images/phicomm.png" type="image/x-icon" rel=icon>
	<link href="../public/images/phicomm.png" type="image/x-icon">
	<link rel="stylesheet" href="../public/css/bootstrap.min.css">
	<link rel="stylesheet" href="../public/css/swagger/metisMenu.min.css">
	<link rel="stylesheet" href="../public/css/swagger/sb-admin-2.css">
	<link rel="stylesheet" href="../public/css/swagger/font-awesome.min.css" type="text/css">
	<link rel="stylesheet" href="../public/css/common.css">
	<link rel="stylesheet" href="../public/css/login.css">
	<script src="../public/js/jquery-1.11.1.min.js"></script>
	<script src="../public/js/bootstrap.min.js"></script>
	<script src="../public/js/common.js"></script>
	<script src="../public/js/jqueryCookie.js"></script>
<title>Swagger-登录</title>
</head>

<body>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Please Sign In</h3>
				</div>
				<div class="panel-body">
					<form role="form">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Username" name="username" type="text" id="username" autofocus>
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password" name="password" type="password" id="password" value="">
							</div>
							<div class="form-group" id="verifyCodeContain">
								<input class="form-control" placeholder="Verify Code" maxlength="4" name="verify code" type="text" id="verifyCode" style="float: left;width: 61%">
								<img src="${pageContext.request.contextPath}/swagger/verify/code" id="verifyCodeImage" style="float: right" onclick='freshVerifyCode()'>
							</div>
							<div class="form-group" style="height: 37px">
							</div>
							<!-- Change this to a button or input when using this as a form -->
							<a class="btn btn-lg btn-success btn-block" onclick="login()">Login</a>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/public/js/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/public/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="${pageContext.request.contextPath}/public/js/metisMenu.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/public/js/sb-admin-2.js"></script>
<script>
    order = 1;
    lastFreshTime = new Date();
    function login() {
        var username = $("#username").val();
        if(username.length < 1) {
            $("#username").focus();
            return;
        }
        var password = $("#password").val();
        if(password.length < 1) {
            $("#password").focus();
            return;
        }
        try {
            window.btoa(password);
        } catch (error) {
            $("#password").val("");
            return;
        }
        var verifyCode =  $("#verifyCode").val();
        if(verifyCode.length < 1) {
            $("#verifyCode").focus();
            return;
        }
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/swagger/login/check",
            dataType: "json",
            data: {
                "username": username,
                "password": password,
                "verifyCode": verifyCode
            }, success: function (data) {
                console.log(data);
                if(data.status == 0) {
                    window.location.href="${pageContext.request.contextPath}/swagger-ui.html";
                } else {
                    $("#password").val("");
                    $("#verifyCode").val("");
                    freshVerifyCode(true);
                }
            }
        });
    }
    function freshVerifyCode() {
        $("#verifyCodeImage").remove();
        var html = "<img src='${pageContext.request.contextPath}/swagger/verify/code?#seed#' id='verifyCodeImage' style='float: right' onclick='freshVerifyCode()'>";
        html = html.replace(/#seed#/g, order++);
        $("#verifyCodeContain").append(html);
    }
</script>
</body>
</html>