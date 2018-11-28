/**
 * deviceManage.jsp 对应的js文件
 * @Author: tengfei.cheng
 * @Time: 2016-12-22 17:01 
 */
var deviceNumber = 0;
$(document).ready(function() {
	getRouterDevices();
});

/**
 * 获取对应的路由器设备，并动态添加在页面中
 * @returns
 */
function getRouterDevices(){
	$.ajax({
		url: context + "/wap/device",
		type: 'GET',
		data:{
			devType:"1"
		},
		success:function(data){
			var dataContent=eval('('+data+')');
			// console.log(dataContent);
			if(dataContent.error=="0"&&dataContent.token_status=="0"){
				var arr=eval(dataContent.data);
				deviceNumber = deviceNumber + arr.length;
				$("#deviceNum").text(deviceNumber);
				for(var m=0;m<arr.length;m++){
					var  devModel="phicomm-"+arr[m].devModel;
					var  online="";
					if(arr[m].online=="1"){
						online="已连接";
					}else if(arr[m].online=="0"){
						online="离线";
					}
					var newDevice=$('<div class="item">'
							+'<div class="image">'
							+'<img class="router-img" src="../public/images/phicomm-router.png" alt="路由">'
							+'</div>'
							+'<div class="description">'
							+'<div><h4>'+"路由器"+'</h4></div>'
							+'<div><h4>'+devModel+","+online+'</h4></div>'
							+'</div><br>'
							+'</div>');
					$("#deviceGeneralList").append(newDevice);
				}
			}else if(dataContent.token_status=="1"){
				alert("token需要刷新");
			}else if(dataContent.error=="5"){
				alert("token过期");
			}else if(dataContent.error=="21"){
				alert("token错误");
			}else if(dataContent.error=="12"){
				alert("参数错误");
			}else if(dataContent.error=="113"){
				alert("账户未绑定任何设备");
			}else if(dataContent.error=="50"||dataContent.error=="500"){
				alert("服务器异常");
			}else if(dataContent.error=="51"){
				alert("服务器正在维护");
			}
		},
	    error:function(e){
	    	//alert(e);
	    	// alert("请求错误.");
	    }
	});
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