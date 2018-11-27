$(document).ready(function(){
    $(".getCodeDiv").click(function(){
        if($(".getCodeDiv").attr("class").indexOf("disabled")<0){
            if(!chek_register_account()){
                return false;
            }  //检查手机号是否合法,是否已经注册
            settime($(".getCodeDiv"));
            sendMessage(0); //发送短信验证码
        }  //倒计时
    });

    $("#voiceVerfy").click(function(){
        if(!chek_register_account()){
            return false;
        }  //检查帐号是否合法,是否已经注册

        if($(".getCodeDiv").attr("class").indexOf("disabled")<0){
            sendMessage(1);
        } //发送语音验证码 
    });

    $('#registerBtn').click(function() {
        if(!checkForm()){
            return false;
        }else {
            var account=$('#account').val();
            var password=hex_md5($('#password').val());
            var password2=hex_md5($('#password2').val());
            var code=$('#code').val();
            var flag=$('#flag').val();
            /*var goods_id=$('#goods_id').val();
            var number=$('#number').val();
            var color=$('#color').val();
            var code_flag=$('#code_flag').val();*/

            $.ajax({
                url:register_url,
                dataType:"json",
                type:'POST',
                cache:false,
                data:{
                    "account": account,
                    "code": code,
                    "password": password,
                    "password2": password2,
                    "code_flag": code_flag
                },
                success: function(data) {
                    if ((data.status=='ok')&&(flag==2)) {
                        window.location.href="webmall.php?m=webmall&c=Address&a=index&goods_id="+goods_id+"&number="+number+"&color="+color;
                    }else if(data.status=='ok'){
                        window.location.href= index_url;
                    }else {
                        if(data.error=='该帐号已注册！'){
                            $("#account").val(data.error).addClass("foolproof");
                        }else if(data.error=='确认密码不正确！'){
                            $("#password2").val(data.error).addClass("foolproof");
                            $("#password2").attr("type","text");
                        }else if(data.error== '验证码错误！' || data.error=='验证码过期，请重新获取！'){
                            $("#code").val(data.error).addClass("foolproof");
                        }else {
                            showTip(data.error);
                        }
                    }
                }
            });
        }    
    });

})

//表单检查
function checkForm(){
    if(!chek_register_account()){
        return false;
    }  //检查帐号是否合法,是否已经注册

    if(!check_verify_code()){
        return false;
    } //检查是否输入验证码

    if(!check_verify_pwd()){
        return false;
    } //检查是否输入密码


    if(!check_verify_pwd2()){
        return false;  //检查是否输入确认密码
    }

    if(!check_compare_pwd()){
        return false;  //检查两次输入是否一致
    }

    return true;
}


