$(function($){
	$("#avatar").click(function(){
		window.location.href =context+"/wap/changeAvatar";
	});
	
	$.ajax({
		url:context+"/wap/getAvatarUrl",
		dataType:"text",
		success:function(data){
			if(data!="error"){
				$("#avatar").attr("src",data);
			}
		}
	});
	
	
	
});




function editUserInfo(){
	var nickname =  jQuery.trim($("#nickname").val());
	var age = jQuery.trim($("#age").val());
	var address = jQuery.trim($("#address").val());
	
	if(!validateNickname(nickname))	{
		alert("请输入正确格式的昵称！");
		return false;
	}	
	
	$.ajax({
		url:context+"/wap/editUserInfo",
		data:{
			 nickname:nickname,
			 age:age,
			 address:address
			 
		},
		dataType:"json",
		type:"POST",
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