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