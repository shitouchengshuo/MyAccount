$(function($) {

	var captchaid;

	$.ajax({
		url : context + "/wap/captcha",
		data : {
			authorizationcode : "feixun*123.SH_2630844"
		},
		dataType : "json",
		success : function(data) {
			if (data.error == "0") {
				$('#captchaImg').attr("src",
						"data:image/png;base64," + data.captcha);
				captchaid = data.captchaid;
			} else {
				alert(data.error + "获取图片验证码出错！");
			}
		}
	});

	$("#captchaImg").click(
			function() {
				$.ajax({
					url : context + "/wap/captcha",
					data : {
						authorizationcode : "feixun*123.SH_2630844"
					},
					dataType : "json",
					success : function(data) {
						if (data.error == "0") {
							$('#captchaImg').attr("src",
									"data:image/png;base64," + data.captcha);
							captchaid = data.captchaid;
						} else {
							alert(data.error + "获取图片验证码出错！");
						}
					}
				});
			});

	$("#btnSendCode").click(function() {
		var phonenumber = jQuery.trim($("#phonenumber").val());
		var captchaCode = jQuery.trim($("#captchaCode").val());
		if (!validatePhoneNum(phonenumber)) {
			alert('请输入有效的手机号码！');
			return false;
		}
		if (captchaCode.length <= 0) {
			alert('请输入图形验证码！');
			return false;
		}
		$.ajax({
			url : context + "/wap/verificationMsg",
			data : {
				authorizationcode : "feixun*123.SH_2630844",
				phonenumber : phonenumber,
				verificationtype : "0",
				captcha : captchaCode,
				captchaid : captchaid
			},
			success : function(data) {
				data = JSON.parse(data);
				if (data.error == "0") {
					time($('#btnSendCode'));
					alert("发送成功");
				} else if (data.error == "13") {
					alert("获取验证码失败");
				} else if (data.error == "36") {
					alert("图片验证码过期");
				} else if (data.error == "37") {
					alert("图片验证码输入错误")
				} else if (data.error == "38") {
					time($('#btnSendCode'));
					alert("验证码请求过快");
				} else if (data.error == "39") {
					alert("验证码请求超出今日限制")
				} else {
					alert(data.error + "获取短信出错！");
				}
			}

		});
	});

	$("#login-button").click(
			function() {
				var phonenumber = jQuery.trim($("#phonenumber").val());
				/* var username = jQuery.trim($("#username").val()); */
				var password = jQuery.trim($("#password").val());
				var password2 = jQuery.trim($("#password2").val());
				var verificationcode = jQuery
						.trim($("#verificationcode").val());
				var openid = document.getElementById("openid").value;
				var access_url = document.getElementById("access_url").value;
				
				var client_id = document.getElementById("client_id").value;
				var state = document.getElementById("state").value;

				/*
				 * if (!validateUsername(username)) { alert('请输入有效的用户名！');
				 * return false; }
				 */
				if (!validatePhoneNum(phonenumber)) {
					alert('请输入有效的手机号码！');
					return false;
				}
				if (!validateVerificationcode(verificationcode)) {
					alert('验证码格式不正确');
					return false;
				}
				if (!validatePwd(password)) {
					alert('请输入有效的密码！');
					return false;
				}

				if (jQuery.trim(password) != jQuery.trim(password2)) {
					alert('两次输入的密码不一致');
					return false;
				}

				$.ajax({
					url : context + "/ui/register",
					data : {
						phonenumber : phonenumber,
						/* username : username, */
						password : password,
						verificationcode : verificationcode,
						openid : openid
					},
					type : "POST",
					dataType : "json",
					success : function(data) {
						if (data.error == "0") {
							if (openid != "") {
								location.href = context + "/wap/WXloginPage?"
										+ "openid=" + openid + "&access_url="
										+ access_url;
							} if(client_id != ""){
								if(client_id == "8605274"){
									location.href = context + "/wap/login?client_id=" 
										+ client_id
										+"&state="+state
								}
								else{
								location.href = context + "/wap/WXloginPage?"
										+"client_id="+client_id
										+"&state="+state;}
							}
							else
								location.href = context + "/wap/login";
						} else if (data.error == "1") {
							alert("验证码错误");
						} else if (data.error == "2") {
							alert("验证码过期");
						} else if (data.error == "14") {
							alert("该账户已存在");
							if (openid != "") {
								location.href = context + "/wap/WXloginPage?"
										+ "openid=" + openid + "&access_url="
										+ access_url;
							} if(client_id != ""){
								location.href = context + "/wap/WXloginPage?"
										+"client_id="+client_id
										+"&state="+state;
							}
							else
								location.href = context + "/wap/login";
						} else if (data.error == "23") {
							alert("验证码已被使用");
						} else if (data.error == "24") {
							alert("该账号已注册，请直接登录");
							if (openid != "") {
								location.href = context + "/wap/WXloginPage?"
										+ "openid=" + openid + "&access_url="
										+ access_url;
							} if(client_id != ""){
								location.href = context + "/wap/WXloginPage?"
										+"client_id="+client_id
										+"&state="+state;
							}
							else
								location.href = context + "/wap/login";
						} else {
							alert(data.error + "服务器异常");
						}
					}

				});
			});

	var wait = 60;
	function time(o) {

		if (wait == 0) {
			$(o).removeAttr('disabled');
			$(o).html("获取验证码");
			wait = 60;
		} else {
			$(o).attr('disabled', 'true');
			$(o).html("重新发送(" + wait + ")");
			wait--;
			setTimeout(function() {
				time(o)
			}, 1000)
		}
	}

});
