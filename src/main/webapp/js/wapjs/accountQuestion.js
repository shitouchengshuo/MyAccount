
function editSecurityQA(){


	var accountQ1 =  $("#accountQ1").val();
	var answer1 = $("#answer1").val();
	var accountQ2 =  $("#accountQ2").val();
	var answer2 = $("#answer2").val();
	var accountQ3 =  $("#accountQ3").val();
	var answer3 = $("#answer3").val();
	var qa = "{"+accountQ1+":"+answer1+"},{"+accountQ2+":"+answer2+"},{"+accountQ3+":"+answer3+"}";
	//var qa = "{qa:{"+accountQ1+":"+answer1+"},{"+accountQ2+":"+answer2+"},{"+accountQ3+":"+answer3+"}}";
	
	if(accountQ1=="请选择：" || accountQ2=="请选择：" || accountQ3=="请选择："){
		alert("请选择您的密保问题");
		return false;
	}	
	
	if(answer1=="" || answer2=="" || answer3==""){
		alert("请填入您的答案");
		return false;
	}

	
	
	$.ajax({
		url:context+"/wap/editSecurityQA",
		data:{qa:qa},
		dataType:"json",
		type:"POST",
/*		headers:{
			"Authorization":getCookie("access_token")
		},*/
		success:function(data){
			if(data.error=="0"){
				alert("修改成功");
				location.href=context+"/wap/index";
			}else{
				alert("修改失败");
			}
		}
		
	});
	
}