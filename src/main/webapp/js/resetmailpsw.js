$(function($){
	
	//提交重置密码按钮
	$("#login-button").click(function(){
		var mailaddress = jQuery.trim($("#mailaddress").val());
		var password = jQuery.trim($("#password").val());
		var password2 = jQuery.trim($("#password2").val());
		var verificationcode = jQuery.trim($("#verificationcode").val());
		
		if(!validateMail(mailaddress)) {
			alert('请输入正确格式的邮箱');
			return false;
		}
		if(!validateVerificationcode(verificationcode)) {
        	alert('验证码格式不正确');
            return false;
        }
		if(!validatePwd(password)) {
			alert('请输入正确格式的密码');
			return false;
		}
		if(jQuery.trim(password)!=jQuery.trim(password2)){
			alert('两次密码不相同'); 
			 return false; 
		}
		
		
		$.ajax({
			url:context+"/ui/resetmailpsw",
			data:{
				mailaddress:mailaddress,
				password:password,
				verificationcode:verificationcode
			},
			type:"POST",
			dataType:"json",
			success:function(data){
				console.log(data);
				if(data.error=="0"){
					alert("重置密码成功");
					delCookie("access_token");
					location.href = context+"/ui/index";
				}else if(data.error=="4"){
					alert("验证码错误");
				}else if(data.error=="2"){
					alert("验证码过期");
				}else if(data.error=="7"){
					alert("该账户不存在");
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

function getCookie(name) 
{ 
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
 
    if(arr=document.cookie.match(reg))
 
        return unescape(arr[2]); 
    else 
        return null; 
} 

//删除cookies 
function delCookie(name) 
{ 
    var exp = new Date(); 
    exp.setTime(exp.getTime() - 1); 
    var cval=getCookie(name); 
    if(cval!=null) 
        document.cookie= name + "="+cval+";expires="+exp.toGMTString(); 
} 













