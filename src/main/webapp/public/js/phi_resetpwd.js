$(document).ready(function(){
    $(".getCodeDiv").click(function(){
        if($(".getCodeDiv").attr("class").indexOf("disabled")<0){
            if(!chek_resetPwd_account()){
                return false;
            }  //检查帐号是否合法 
            settime($(".getCodeDiv"));
            sendMessage(0); //发送短信验证码
        }  //倒计时
    });

    $("#voiceVerfy").click(function(){
        if(!chek_resetPwd_account()){
            return false;
        }  //检查帐号是否合法 

        if($(".getCodeDiv").attr("class").indexOf("disabled")<0){
            sendMessage(1);
        } //发送语音验证码 
    });

    $('#resetPswBtn').click(function() {
        if(!checkForm()){
            return false;
        }else {
            var account=$('#account').val();
            var password=hex_md5($('#password').val());
            var password2=hex_md5($('#password2').val());
            var code=$('#code').val();
            var flag=$('#flag').val();
            var goods_id=$('#goods_id').val();
            var number=$('#number').val();
            var color=$('#color').val();
            var code_flag=$('#code_flag').val();
            $.ajax({
                url:self_ur,
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
                        window.location.href=index_url;
                    }else {
                        if(data.error=='帐号不正确！' || data.error=='您还未注册，请先注册！'){
                            $("#phone").val(data.error).addClass("foolproof");
                        }else if(data.error=='两次输入密码不一致！'){
                            $("#password").val(data.error).addClass("foolproof");
                            $("#password").attr("type","text");
                        }if(data.error=='验证码错误！'){
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

function checkForm(){
    if(!account_check()){
        return false;
    }  //检查帐号是否合法 

    if(!chek_resetPwd_account()){
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

//检查帐号是否合法,是否已经注册
function chek_resetPwd_account(){
    if(!account_check()){
        return false;
    } //帐合法性检查

    if(!check_noexist_account()){
        return false;
    } //检查帐合是否存在

    return true;
}

