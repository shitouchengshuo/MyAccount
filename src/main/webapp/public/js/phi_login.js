$(document).ready(function(){
    $('#login_btn').click(function() {
        if(!checkForm()){
            return false;
        }else{
            var account=$('#account').val();
            var password=hex_md5($('#password').val());
            //var verify=$('#theVerify').val();
            //var first_login=$('#first_login').val();
            $.ajax({
                url: login_url,
                dataType:"json",
                type:'POST',
                cache:false,
                data:{
                    "account": account,
                    "password": password,
                },
                success: function(data) {
                    if (data.status=='ok') {
                        window.location.href = index_url;
                    }else {
                        if(data.error=='帐号不正确！'){
                            $("#phone").val(data.error).addClass("foolproof");
                            $("#phone").attr("type","text");
                        }else if(data.error=='登录密码错误，请重新输入！'){
                            $("#password").val(data.error).addClass("foolproof");
                            $("#password").attr("type","text");
                        }else{
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
    if(!account_check()){
        return false;
    }  //检查帐号是否合法 

    if(!check_verify_pwd()){
        return false;
    } //检查是否输入密码

    return true;
}
