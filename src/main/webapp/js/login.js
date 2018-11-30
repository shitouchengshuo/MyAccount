function submitLogin(){
	var username = jQuery.trim($("#username").val());
	var password = jQuery.trim($("#password").val());

	if(!validateUsername(username)&&!validatePhoneNum(username)&&!validateMail(username)) {
		alert("请输入有效的用户名！");
		return false;
	}
	if(!validatePwd(password)) {
		alert("请输入有效的密码！");
		return false;
	}
	
	
	
	$.ajax({
		type:"POST",
		url:context+"/ui/checkLogin",
		data:{
			username:username,
			password:password
		},
		dataType:"json",
		cache:false,
		async:false,
		success:function(data){
			if(data.error=="0"){
				setCookies("access_token",data.access_token);
                alert("登录成功");
				location.href=context+"/ui/success";

			}else if(data.error=="7"){
				alert("用户名不存在");
			}else if(data.error=="8"){
				alert("密码错误");
			}else if(data.error=="15"){
				alert("用户被锁定");
			}else if(data.error=="50"||data.error=="500"){
				alert("服务器异常");
			}
			
		}
	});
	
}

function setCookies(name,value){
　　 var exp = new Date();　　　　 //new Date("December 31, 9998");
　　 exp.setTime(exp.getTime() + 30*60*1000);
　　 document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

function wb_login() {
    alert("请求授权");
    window.open('https://api.weibo.com/oauth2/authorize?client_id=3400298650&response_type=code&redirect_uri=https://portrait.phicomm.com/v1/callback/sina');

}
function wb_logout() {
    alert("登录失败");
}

















