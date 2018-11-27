<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta property="wb:webmaster" content="61c1eb1341ed7181" />
<link href="/public/images/phicomm.png" type="image/x-icon" rel=icon>
<link href="/public/images/phicomm.png" type="image/x-icon">
<link rel="stylesheet" href="/public/css/bootstrap.min.css">
<link rel="stylesheet" href="/public/css/common.css">
<link rel="stylesheet" href="/public/css/index.css">
<script src="/public/js/phi_redirect.js"></script>
<script type="text/javascript">phi_redirect("${pageContext.request.contextPath}/wap/index");</script>
<script src="/public/js/jquery-1.11.1.min.js"></script>
<script src="/public/js/bootstrap.min.js"></script>
<script src="/public/js/common.js"></script>
<script src="/public/js/jqueryCookie.js"></script>
<title>斐讯账户</title>
</head>
<body>
	<div class="containt">
        <jsp:include page="common.jsp"/>
 		<div class="content">
 			<h1>
 				无所不能的斐讯云帐户
 			</h1>
 			<h4 class="mrg_top">
 				登录以管理你的信息、设备、安全和隐私。你的斐讯云帐户将它们集合在一处。
 			</h4>
 			<input onclick="javascript:location.href='${pageContext.request.contextPath}/ui/loginPage'" class="btn btn_orange" id="login-button" type="button" value="立即登录">
 			<input onclick="javascript:location.href='${pageContext.request.contextPath}/ui/registerPage'" class="btn btn_gray" id="createAccount-button" type="button" value="创建账户">
 		</div>
 		<footer>
 			版权所有 © 上海斐讯数据通信技术有限公司
 		</footer>
	</div>
</body>
</html>