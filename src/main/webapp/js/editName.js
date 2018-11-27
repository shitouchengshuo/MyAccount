$(function($){
	$("#avatar").click(function(){
		window.location.href =context+"/ui/changAvatarPage";
	});
	
	$.ajax({
		url:context+"/ui/getAvatarUrl",
		dataType:"text",
		success:function(data){
			if(data!="error"){
				$("#avatar").attr("src",data);
			}
		}
	});
	
	
	
});




function editName(){
	var realName = jQuery.trim($("#surname").val()+$("#name").val());
	if(realName==""){
		alert("请输入真实姓名");
		return false;
	}
	
	var realNamereg = new RegExp("^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9_]){1,10}$"); 
	if(!realNamereg.test(realName)){
		alert("名称格式不正确");
		return false;
	}
	
	
	$.ajax({
		url:context+"/ui/editName",
		data:{
			realName:realName
		},
		dataType:"json",
		type:"POST",
		success:function(data){
			if(data.error=="0"){
				alert("修改成功");
				location.href=context+"/ui/index";
			}else{
				alert("修改失败");
			}
		}
		
	});
	
}