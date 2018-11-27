$(function($){

    $("#btn_bind").click(function(){
        var mailaddress = jQuery.trim($("#mailaddress").val());
        var verificationcode = jQuery.trim($("#verificationcode").val());
        if(!validateMail(mailaddress)) {
        	alert('请输入正确格式的邮箱！');
            return false;
        }
        if(!validateVerificationcode(verificationcode)) {
        	alert('验证码格式不正确');
            return false;
        }

        $.ajax({
            url:context+"/wap/bindPhoneMail",
            data:{
                mailaddress:mailaddress,
                verificationcode:verificationcode
            },
            headers:{
				"Authorization":getCookie("access_token")
		    },
            type:"POST",
            dataType:"json",
            success:function(data){
                var error = data.error;
                if(error=="0"){
                    alert("绑定邮箱成功");
                    location.href = context+"/wap/index";
                }else if(error=="25"){
                    alert("该邮箱已经被绑定");
                }else{
                    alert("绑定失败");
                }
            }
        });
    });

    $("#btn_validate").click(function(){

        var mailaddress = jQuery.trim($("#mailaddress").val());
        var verificationcode = jQuery.trim($("#verificationcode").val());
        if(!validateMail(mailaddress)) {
        	alert('请输入正确格式的邮箱！');
            return false;
        }
        if(!validateVerificationcode(verificationcode)) {
        	alert('验证码格式不正确');
            return false;
        }

        $.ajax({
            url:context+"/wap/validatePhoneMail",
            data:{
                mailaddress:mailaddress,
                verificationcode:verificationcode
            },
            headers:{
				"Authorization":getCookie("access_token")
		    },
            type:"POST",
            dataType:"json",
            success:function(data){
                var error = data.error;
                if(error=="0"){
                    location.href = context+"/wap/updateMailPage_2";
                }else if(error=="12"){
                    alert("邮箱错误");
                }else if(error=="1"){
                    alert("验证码错误");
                }else if(error=="23"){
                    alert("验证码已被使用");
                }else{
                    alert("验证失败");
                }
            }
        });
    });

    $("#btn_update").click(function(){

        var mailaddress = jQuery.trim($("#mailaddress").val());
        var verificationcode = jQuery.trim($("#verificationcode").val());
        if(!validateMail(mailaddress)) {
        	alert('请输入正确格式的邮箱！');
            return false;
        }
        if(!validateVerificationcode(verificationcode)) {
        	alert('验证码格式不正确');
            return false;
        }

        $.ajax({
            url:context+"/wap/bindPhoneMail",
            data:{
                mailaddress:mailaddress,
                verificationcode:verificationcode
            },
            headers:{
				"Authorization":getCookie("access_token")
		    },
            type:"POST",
            dataType:"json",
            success:function(data){
                var error = data.error;
                if(error=="0"){
                    alert("修改邮箱成功");
                    location.href = context+"/wap/index";
                }else if(error=="25"){
                    alert("该邮箱已经被绑定");
                }else if(error=="17"){
                    alert("原邮箱或者验证码错误");
                }else{
                    alert("绑定失败");
                }
            }
        });
    });


    //发送邮箱验证码，不需要链接
    $("#btnSendCode").click(function(){
        var mailaddress = jQuery.trim($("#mailaddress").val());
        var mailtype = '0';
        if(!validateMail(mailaddress)) {
        	alert('请输入正确格式的邮箱！');
            return false;
        }
        time(this);
        $.ajax({
            url:context+"/wap/verificationCode",
            data:{
                mailaddress:mailaddress,
                mailtype:mailtype
            },
            dataType:"json",
            success:function(data){
            	//console.log(data);
                if(data.error=="0"){
                    alert("发送成功");
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












