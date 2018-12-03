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
    <script src="${pageContext.request.contextPath}/js/logout.js"></script>
    <script>
    var context = "${pageContext.request.contextPath}";
    </script>
    <title>登录成功</title>
</head>
<body>
<div class="wrapper">
    <div class="wrap">
        <div class="layout">
            <div class="login_area">
                <form action="${pageContext.request.contextPath}/ui/logout" method="POST" id="login-main-form">
                    <div class="loginbox">
                        <div class="btns_bg">
                            <input onclick="submitLogout()" style="margin-left:0px!important" class="btn btnadpt btn_orange" id="logout-button" type="button" value="退出登录">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="n_links_area">
    <a class="outer-link" href="${pageContext.request.contextPath}/ui/admin">Admin Page</a>
    <span>|</span>
    <a class="outer-link" href="${pageContext.request.contextPath}/ui/user">User Page</a>
    <span>|</span>
    <a class="outer-link" href="${pageContext.request.contextPath}/ui/testShiroAnnocation">Test ShiroAnnocation</a>
</div>
</body>
</html>