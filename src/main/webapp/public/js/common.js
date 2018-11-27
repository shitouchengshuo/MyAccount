$(document).ready(function(){
	
	var context = "${pageContext.request.contextPath}";
	
	login_logo_click();
	ieCompatible();
	menue_list_hover();
	
})


function login_logo_click(){
	$(".login_logo").click(function(){
		window.location.href="index";
	})
}

function forwardUrl(url){
	window.location.href = url;
}

function forwardUrl2(url){
	window.open(url);
}

function menue_list_hover(){
	$(".tow_level_li").hover(function(){
		$(this).find(".tow_level_ul").show(); 
	},function(){
		$(this).find(".tow_level_ul").hide(); 
	})

	$(".three_level_li").hover(function(){
		$(this).find(".three_level_ul").show(); 
	},function(){
		$(this).find(".three_level_ul").hide();
	})
}

function ieCompatible(){
	//IE placeholder兼容问题
	if( !('placeholder' in document.createElement('input')) ){  
	    $('input[placeholder],textarea[placeholder]').each(function(){   
	      var that = $(this),   
	      text= that.attr('placeholder');   
	      if(that.val()===""){   
	        that.val(text).addClass('placeholder');   
	      }   
	      that.focus(function(){   
	        if(that.val()===text){   
	          that.val("").removeClass('placeholder');   
	        }   
	      })   
	      .blur(function(){   
	        if(that.val()===""){   
	          that.val(text).addClass('placeholder');   
	        }   
	      })   
	      .closest('form').submit(function(){   
	        if(that.val() === text){   
	          that.val('');   
	        }   
	      });   
	    });   
  	} 

  	//ie indexOf兼容问题
  	if (!Array.prototype.indexOf){
		Array.prototype.indexOf = function(elt /*, from*/){
			var len = this.length >>> 0;
			var from = Number(arguments[1]) || 0;
			from = (from < 0)
			     ? Math.ceil(from)
			     : Math.floor(from);
			if (from < 0)
			  from += len;
			for (; from < len; from++){
			  if (from in this &&
			      this[from] === elt)
			    return from;
			}
			return -1;
		};
	} 
}

//倒计时60s
var setTime;
function settime(get_obj){
    if(get_obj.attr("class").indexOf("disabled")<0){
        var time=60;
        get_obj.html("60秒");
        get_obj.css("color","#ff8000");
        get_obj.addClass("disabled");
        setTime=setInterval(function(){
            if(time<=0){
                clearInterval(setTime);
                get_obj.html("重新发送");
                get_obj.removeClass("disabled");
                return;
            }
            time--;
            $(".getCodeDiv").html(time+"秒");
        },1000);    
    }
}

/*----------------分割线---------------------*/

function forwardUrlPost(url) {
  $.ajax({
      type:'POST',
      url:url,
      dataType: "json",
      success:function(data){

          if(data.error == "0"){
              window.location.href = context+"/ui/index";
          }else{
              alert('退出失败，请重试');
              window.location.href = context+"/ui/index";
          }
      }
  });
}

function forwardWapUrlPost(url) {
	  $.ajax({
	      type:'POST',
	      url:url,
	      headers:{
				"Authorization":getCookie("access_token")
		  },
		  dataType: "json",
	      success:function(data){
	          if(data.error == "0"){
	              window.location.href = context+"/wap/index";
	          }else{
	        	  alert('退出失败，请重试');
	              window.location.href = context+"/wap/index";
	          }
	      }
	  });
}
/*
function thirdLogin_sina(url) {

    $.ajax({
        type:'GET',
        url:url,
        dataType: "json",
        success:function(data){
            if(data.error == "0"){
                window.location.href = context+"/ui/index";
            }else{
                alert('失败，请重试');
                window.location.href = context+"/ui/index";
            }
        }
    });
}*/




function validateUsername(usernamepara){
	var username = jQuery.trim(usernamepara);
	var regexUsername = /^([\u4e00-\u9fa5]{1,10}|[a-zA-Z0-9_-]{2,20})$/;
	if(!regexUsername.test(username)) {
		// alert("用户名格式不正确");
		return false;
	} else {
		return true;
	}
	// return regexUsername.test(username);
}

function validatePhoneNum(phonenumpara) { 
	var phonenum = jQuery.trim(phonenumpara);
	var regexPhoneNum = /^1[34578]\d{9}$/;
	if(!regexPhoneNum.test(phonenum)) {
		// alert("手机号码格式不正确");
		return false;
	} else {
		return true;
	}
	// return regexPhoneNum.test(phonenum);
}

function validateMail(mailpara) {
	var mail = jQuery.trim(mailpara);
	var regexEmail = /^(?:\w+\.?)*\w+@(?:\w+\.)+\w+$/;
	if(!regexEmail.test(mail)) {
		// alert("邮箱格式不正确");
		return false;
	} else {
		return true;
	}
	// return regexEmail.test(mail);
}

function validatePwd(passwordpara) {
	var password = jQuery.trim(passwordpara);
	var regexPwd = /^[a-zA-Z0-9_!#\$\*\+-\.\/:;=\?@\[\]\^`\|]{6,20}$/;
	if(!regexPwd.test(password)){
		// alert("密码格式不正确");
		return false;
	} else {
		return true;
	}
	// return regexPwd.test(password);
}

function validateNickname(nicknamepara) {
	var nickname = jQuery.trim(nicknamepara);
	var regexNickname = /^([\u4e00-\u9fa5]{2,10}|[a-zA-Z0-9_-]{4,20})$/;
	if(!regexNickname.test(nickname)){
		// alert("昵称格式不正确");
		return false;
	} else {
		return true;
	}
	// return regexNickname.test(nickname);
}

function validateVerificationcode(codepare) {
	var code = jQuery.trim(codepare);
	var regexCode = /^\d{4,6}$/;
	if(!regexCode.test(code)){
		return false;
	} else {
		return true;
	}
}

/**
 * 验证头像是否是gif,jpg或者png格式的图片
 * @param 				filename 上传头像图片的名称
 * @returns				true or false
 */
function validateAvatarForm(filename) {
	if(filename == "") {
		alert("上传头像为空");
		return false;
	} else {
		if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(filename)) {
        	alert("图片类型必须是.gif .jpeg .jpg .png中的一种")
            return false;
        } else {
        	return true;
        }
	}
}

/**
 * 根据cookie的名字获取cookie
 * @param cookie名字
 * @returns cookie的值
 */
function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');   //通过 ; 号来分离每个cookie
	for(var i = 0; i < ca.length; i++) {
		var c = ca[i];      //通过遍历依次把cookie读取出来
		while(c.charAt(0) == ' ') {    
			c = c.substring(1);
		}
		if(c.indexOf(name) == 0) {
			return unescape(c.substring(name.length, c.length));
		}
		return "";   //cookie不存在就返回空
	}
}


// AJAX拦截HTTP异常码处理请求
/*
$.ajaxSetup({
	   contentType:"application/x-www-form-urlencoded;charset=utf-8",
	   complete:function(XMLHttpRequest,textStatus){
	   },
	   statusCode: {
	     404: function() {
	         alert('数据获取/输入失败，没有此服务。404');
	     },
	     504: function() {
	         alert('数据获取/输入失败，服务器没有响应。504');
	     },
	     500: function() {
	         alert('服务器有误。500');
	     }
	   }
	});
*/