$(function($){
	$("#avatar").click(function(){
		window.location.href =context+"/ui/changAvatarPage";
	});
	$(".score-state-right").width(score+"%");
	$(".score-num").html(score+"分！")
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