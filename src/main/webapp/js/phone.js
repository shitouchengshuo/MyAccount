$(function($){

/*    $("#btn_bind").click(function(){
        var mailaddress = $("#mailaddress").val();
        var verificationcode = $("#verificationcode").val();
        if(verificationcode==""){
            alert('验证码不能为空');
            return false;
        }

        $.ajax({
            url:context+"/ui/bindPhoneMail",
            data:{
                mailaddress:mailaddress,
                verificationcode:verificationcode
            },
            type:"POST",
            dataType:"json",
            success:function(data){
                var error = data.error;
                if(error=="0"){
                    alert("绑定邮箱成功");
                    location.href = context+"/ui/index";
                }else if(error=="25"){
                    alert("该邮箱已经被绑定");
                }else{
                    alert("绑定失败");
                }
            }
        });
    });*/

    $("#btn_validate").click(function(){

        var phonenumber = jQuery.trim($("#phonenumber").val());
        var verificationcode = jQuery.trim($("#verificationcode").val());
        if(!validatePhoneNum(phonenumber)) {
        	alert('请输入正确格式的手机号！');
            return false;
        }
        if(!validateVerificationcode(verificationcode)) {
        	alert('验证码格式不正确');
            return false;
        }

        $.ajax({
            url:context+"/ui/validatePhoneMail",
            data:{
                phonenumber:phonenumber,
                verificationcode:verificationcode
            },
            type:"POST",
            dataType:"json",
            success:function(data){
                var error = data.error;
                if(error=="0"){
                    location.href = context+"/ui/updatePhonePage";
                }else if(error=="12"){
                    alert("手机错误");
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

        var mailaddress = jQuery.trim($("#phonenumber").val());
        var verificationcode = jQuery.trim($("#verificationcode").val());
        if(!validatePhoneNum(mailaddress)) {
        	alert('请输入正确格式的手机号！');
            return false;
        }
        if(!validateVerificationcode(verificationcode)) {
        	alert('验证码格式不正确');
            return false;
        }

        $.ajax({
            url:context+"/ui/bindPhoneMail",
            data:{
                phonenumber:mailaddress,
                verificationcode:verificationcode
            },
            type:"POST",
            dataType:"json",
            success:function(data){
                var error = data.error;
                if(error=="0"){
                    alert("修改手机成功");
                    location.href = context+"/ui/index";
                }else if(error=="25"){
                    alert("该手机已经被绑定");
                }else if(error=="17"){
                    alert("原手机或者验证码错误");
                }else{
                    alert("绑定失败");
                }
            }
        });
    });


    //发送手机验证码，不需要链接
    $("#btnSendCode").click(function(){
        var phonenumber = jQuery.trim($("#phonenumber").val());
        var mailtype = '0';
        if(!validatePhoneNum(phonenumber)) {
        	alert('请输入正确格式的手机号！');
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












