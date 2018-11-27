$(function($){
	$("#avatar").click(function(){
		window.location.href =context+"/wap/changeAvatar";
	});
	$.ajax({
		url:context+"/wap/getAvatarUrl",
		dataType:"text",
		type:"GET",
		success:function(data){
			if(data!="error"){
				$("#avatar").attr("src",data);
			}
		}
	});
});