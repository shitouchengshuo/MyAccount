$(document).ready(function(){

	if ((navigator.userAgent.indexOf('MSIE') >= 0) && (navigator.userAgent.indexOf('Opera') < 0)){
	    document.getElementById("account").attachEvent("onpropertychange",check_account_); 
	}else 
	{  
	    document.getElementById("account").addEventListener("input", check_account_, false);  
	}  
})

//帐号检查
function check_account_(){
	var account_val = $("#account").val();
	if (account_val =="") {
		$("#voiceVerfy").removeClass("disabled").addClass("disabled");
        $(".getCodeDiv").removeClass("disabled").addClass("disabled");
		return false;
	}else{
        $("#voiceVerfy").removeClass("disabled");
        $(".getCodeDiv").removeClass("disabled");	
    }
 
}

//帐号检查
function account_check(){
	var account_val = $("#account").val();
	if (account_val =="") {
		$("#account").val("请输入帐号").addClass("foolproof");
		$("#voiceVerfy").removeClass("disabled").addClass("disabled");
    	$(".getCodeDiv").removeClass("disabled").addClass("disabled");
        return false;
    }else{
		$("#voiceVerfy").removeClass("disabled");
    	$(".getCodeDiv").removeClass("disabled");
    	return true;
	}
	return true;
}

//检查帐号是否已经注册 已注册返回false
function check_exist_account(){
	var account=$('#account').val();
	var flag = true;
	$.ajax({
		url:check_account_url,
		dataType:"json",
		type:'POST',
		cache:false,
		async:false,
		data:{
		    "account": account
		},
		success: function(data) {
		    if (data.status=='ok') {
		    	//没有注册
		        $("#voiceVerfy").removeClass("disabled");
		        $(".getCodeDiv").removeClass("disabled");
		        flag = true;
		    }else {
		        if(data.error=='该帐号已注册！'){
		        	//已注册
		            $("#account").val(data.error).addClass("foolproof");
		            $("#voiceVerfy").removeClass("disabled").addClass("disabled");
		            $(".getCodeDiv").removeClass("disabled").addClass("disabled");
		            flag = false;
		        }else {
					flag = false;
					showTip(data.error);
				}
		    }
		}
	});
	return flag;
}

//检查手机号是否已经注册 没有注册返回false 
function check_noexist_account(){
	var account=$('#account').val();
	var flag = true;
	$.ajax({
		url:check_account_url,
		dataType:"json",
		type:'POST',
		cache:false,
		async:false,
		data:{
		    "account": account
		},
		success: function(data) {
		    if (data.status=='ok') {
		    	//没有注册
		        $("#account").val('该帐号还未注册').addClass("foolproof");
	            $("#voiceVerfy").removeClass("disabled").addClass("disabled");
	            $(".getCodeDiv").removeClass("disabled").addClass("disabled");
		        flag = false;
		    }else {
		        if(data.error=='该帐号已注册！'){
		        	//已注册
		        	$("#voiceVerfy").removeClass("disabled");
		        	$(".getCodeDiv").removeClass("disabled");		            
		            flag = true;
		        }
		    }
		}
	});
	return flag;
}

//检查帐号是否合法,是否已经注册
function chek_register_account(){
    if(!account_check()){
        return false;
    } //帐号是否输入检查

    if(!check_exist_account()){
    	return false;
    } //检查帐号是否存在

    return true;
}

// 获取短信或语音验证码
function sendMessage(code_flag) {
    var account = $("#account").val();
    $.ajax({
        url:get_code_url,
        dataType:"json",
        type:'POST',
        cache:false,
        data:{
            "account": account,
            "code_flag": code_flag
        },
        success: function (data) {
            if(data.status == 'ok'){
                $('#code_flag').val(code_flag);
            }else if(data.status == 'ok2'){
                showTip("已成功发送语音验证,<br>请注意接听您的手机!");
                $('#code_flag').val(code_flag);
            }else{
                showTip('验证码发送失败,请重试！');
            };
        }
    });
 
};

//密码输入检查
function check_verify_pwd(){
    if(!phi_verify_pwd("password")){
        $("#password").val("请输入8-16位字符的密码").addClass("foolproof");
        $("#password").attr("type","text");
        return false;
    } 
    return true;   
}

//确认密码输入检查
function check_verify_pwd2(){
    if(!phi_verify_pwd("password2")){
        $("#password2").val("确认密码需为8-16位并和密码相同").addClass("foolproof");
        $("#password2").attr("type","text");
        return false;
    } 
    return true;   
}


function check_compare_pwd(){
	if($("#password2").val()!=$("#password").val()){
		$("#password2").val("确认密码需为8-16位并和密码相同").addClass("foolproof");
        $("#password2").attr("type","text");
		return false;
	}
	return true;
}

//验证码输入检查
function check_verify_code(){
    if($("#code").val()==""){
        $("#code").val("请输入验证码").addClass("foolproof");
        return false;
    } 
    return true;   
}
