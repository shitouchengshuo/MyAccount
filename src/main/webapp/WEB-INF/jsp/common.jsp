<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="header">
    <img src="${pageContext.request.contextPath}/public/images/logo.png" class="login_logo" width="160px">
</div>
<div class="menue">
    <ul>
        <li class="active" onclick="forwardUrl('${pageContext.request.contextPath}/ui/index')">账号设置</li>
        <li onclick="forwardUrl('${pageContext.request.contextPath}/ui/loginHistory')">登录记录</li>
        <li onclick="forwardUrl('${pageContext.request.contextPath}/ui/deviceManage')">设备管理</li>
        <li onclick="forwardUrl('${pageContext.request.contextPath}/ui/accountBind')">绑定授权</li>
        <li onclick="forwardUrl('${pageContext.request.contextPath}/ui/serviceAndSubscription')">服务</li>
    </ul>
</div>
