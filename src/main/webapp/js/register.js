$(function($){
	$("#btnSendCode").click(function(){
		var phonenumber = jQuery.trim($("#phonenumber").val());
		if(!validatePhoneNum(phonenumber)) {
			alert('请输入有效的手机号码！'); 
		    return false;
		}
		time(this);
		$.ajax({
			url:context+"/ui/verificationCode",
			data:{
				phonenumber:phonenumber
			},
			dataType:"json",
			success:function(data){
				if(data.error=="0"){
					alert("发送成功");
				}else if(data.error=="50"){
					alert("服务器异常");
				}
			}
			
			
		});
	});
	
	$("#login-button").click(function(){
		var phonenumber = jQuery.trim($("#phonenumber").val());
		var username = jQuery.trim($("#username").val());
		var password = jQuery.trim($("#password").val());
		var password2 = jQuery.trim($("#password2").val());
		var verificationcode = jQuery.trim($("#verificationcode").val());
		
		if(!validateUsername(username)) {
			alert('请输入有效的用户名！'); 
		    return false;
		}
		if(!validatePhoneNum(phonenumber)) {
			alert('请输入有效的手机号码！'); 
		    return false;
		}
		if(!validateVerificationcode(verificationcode)) {
        	alert('验证码格式不正确');
            return false;
        }
		if(!validatePwd(password)) {
			alert('请输入有效的密码！'); 
		    return false;
		}
		
		if(jQuery.trim(password)!=jQuery.trim(password2)){
			 alert('两次输入的密码不一致'); 
			 return false; 
		}
		
		
		$.ajax({
			url:context+"/ui/register",
			data:{
				phonenumber:phonenumber,
				username:username,
				password:password,
				verificationcode:verificationcode
			},
			type:"POST",
			dataType:"json",
			success:function(data){
				if(data.error=="0"){
					alert("注册成功");
					location.href = context+"/ui/loginPage";
				}else if(data.error=="1"){
					alert("验证码错误");
				}else if(data.error=="2"){
					alert("验证码过期");
				}else if(data.error=="14"){
					alert("该账户已存在");
				}else if(data.error=="50"){
					alert("服务器异常");
				}
			}
			
			
		});
	});
	
	
	var wait = 60;
	function time(o) {  
		
        if (wait == 0) {  
            o.removeAttribute("disabled");            
            $(o).html("获取验证码");  
            wait = 60;  
        } else {  
            o.setAttribute("disabled", true);  
            $(o).html("重新发送(" + wait + ")");  
            wait--;  
            setTimeout(function() {  
                time(o)  
            },  
            1000)  
        }  
    }  
	
	
	
});









