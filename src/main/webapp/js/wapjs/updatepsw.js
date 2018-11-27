$(function($){

	// alert(getCookie("access_token"));
	//提交重置密码按钮
	$("#login-button").click(function(){
        var oldpassword = jQuery.trim($("#oldpassword").val());
		var newpassword = jQuery.trim($("#newpassword").val());
		var newpassword2 = jQuery.trim($("#newpassword2").val());


		if(!validatePwd(oldpassword)) {
			alert('旧密码格式不正确！'); 
		    return false;
		}
		if(!validatePwd(newpassword)) {
			alert('新密码格式不正确！'); 
		    return false;
		}
		if(!validatePwd(newpassword2)) {
			alert('新密码格式不正确！'); 
		    return false;
		}
		if(jQuery.trim(newpassword)!=jQuery.trim(newpassword2)){
			 alert('两次输入的密码不一致');
			 return false; 
		}
		

		$.ajax({
			url:context+"/wap/updatepsw",
			data:{
				oldpassword:oldpassword,
				newpassword:newpassword
			},
			headers:{
				"Authorization":getCookie("access_token")
			},
			type:"POST",
			dataType:"json",
			success:function(data){

				if(data.error=="0"){
					alert("修改密码成功");
					delCookie("access_token");
					location.href = context+"/wap/index";
				}else if(data.error=="8"){
                    alert("密码错误")
                }else if(data.error=="5"){
                    alert("token");
                }else{
                    alert(data.error+" 修改密码失败");
                }
			}
		});
	});

});














