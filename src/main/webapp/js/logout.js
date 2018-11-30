function submitLogout(){

	$.ajax({
		type:"POST",
		url:context+"/ui/logout",
		data:{},
		dataType:"json",
		cache:false,
		async:false,
		success:function(data){
			if(data.error=="0"){
                alert("退出成功");
				location.href=context+"/ui/login";
			}
		}
	});
	
}


















