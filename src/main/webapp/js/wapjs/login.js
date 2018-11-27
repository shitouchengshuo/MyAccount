$(document).ready(function() {
	document.getElementById("login_button").addEventListener("click", submitLogin);
});

function submitLogin(){
	var username = jQuery.trim($("#username").val());
	var password = jQuery.trim($("#password").val());
	var openid = document.getElementById("openid").value;
	var access_url = document.getElementById("access_url").value;
	var client_id = document.getElementById("client_id").value;
	var scope = document.getElementById("scope").value;
	var redirect_url = document.getElementById("redirect_url").value;
	var state = document.getElementById("state").value;
	
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
		url:context+"/ui/login",
		data:{
			username:username,
			password:password,
			openid:openid,
			client_id:client_id
		},
		dataType:"json",
		cache:false,
		async:false,
		success:function(data){
			if(data.error=="0"){
				if(client_id != ""){
					// 跑团小程序
					if(client_id == "8605274"){
						location.href=context+"/wap/runRedirect?"+
							"uid="+data.uid+
							"&access_token="+data.access_token+
							"&access_token_expire="+data.access_token_expire+
							"&refresh_token="+data.refresh_token+
							"&refresh_token_expire="+data.refresh_token_expire+
							"&openid="+openid+
							"&state="+state;
					}else{
						location.href=context+"/wap/implicitGrant?"+
							"&access_token="+data.access_token+
							"&access_token_expire="+data.access_token_expire +
							"&state="+state;
					}
				}
				else{
				setCookies("access_token",data.access_token);
				location.href=context+"/wap/index";
				}
			}else if(data.error=="7"){
				alert("用户名不存在");
			}else if(data.error=="8"){
				alert("密码错误");
			}else if(data.error=="15"){
				alert("密码未设置");
			}else {
				alert(data.error+"服务器异常");
			}
			
		}
	});
	
}

function setCookies(name,value){
	var exp = new Date();
	exp.setTime(exp.getTime() + 30*60*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

















