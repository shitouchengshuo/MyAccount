/** 
 * loginHistory.jsp对应的js文件
 * @Author: tengfei.cheng
 * @Time: 2016-12-21 14:27 
 */



var recentHistoryNum = 20;
var hideLoginHistory = null;
var totalHoistoryNum = 0;
/**
 * 页面加载时执行的初始化操作，这里是获取登录记录
 */
$(document).ready(function() {
	showLoginHistory();
});


/**
 * 读取当前用户的登录记录，通过AJAX请求,返回的内容放在table中
 * @returns
 */
function showLoginHistory(){
	$.ajax({
		url: context+"/loginHistory",
		type: 'GET',
		headers:{
			"Authorization":getCookie("access_token")
		},
		success:function(data){
			var dataContent=eval('('+data+')');
			if(dataContent.error=="0"&&dataContent.token_status=="0"){
				var showNum = 0;
				var arr=eval(dataContent.result);
	
				totalHoistoryNum = arr.length;
				if(arr.length<=20) {
					showNum = arr.length;
					$("#recentNum").text(arr.length);
				} else {
					showNum = 20;
					$("#recentNum").text("20");
					$("#showAllTextButton").text("查看所有");
					$("#showAllTextButton").bind('click', showAllLoginHistory); 
				}
				
				recentHistoryNum = showNum;
				hideLoginHistory = arr;
				
				for(var m=0;m<showNum;m++){
					var newRecord=$('<tr>'
							+'<td class="loginTime">'+arr[m].logintime+'</td>'
							+'<td class="loginLocation">'+arr[m].loginlocation+'</td>'
							+'<td class="loginIP">'+arr[m].loginip+'</td>'
							+'<td class="loginSource">'+arr[m].loginsource+'</td>'
							+'<td class="loginMode">'+arr[m].loginmode+'</td>'
						+'</tr>');
					$("#loginHistory_content").append(newRecord);
				}
			}else if(dataContent.error=="5"){
				alert("token失效");
			}else if(dataContent.error=="17"){
				alert("没有权限");
			}else if(dataContent.error=="21"){
				alert("token错误");
			}else if(dataContent.error=="50"||dataContent.error=="500"){
				alert("服务器异常");
			}else if(dataContent.error=="51"){
				alert("服务器正在维护");
			}
		},
	    error:function(e){
	    	alert(e);
	    }
	});
}

function showAllLoginHistory() {
	for(var m=recentHistoryNum;m<totalHoistoryNum;m++){
		var newRecord=$('<tr class="hideandshow">'
				+'<td class="loginTime">'+hideLoginHistory[m].logintime+'</td>'
				+'<td class="loginLocation">'+hideLoginHistory[m].loginlocation+'</td>'
				+'<td class="loginIP">'+hideLoginHistory[m].loginip+'</td>'
				+'<td class="loginSource">'+hideLoginHistory[m].loginsource+'</td>'
				+'<td class="loginMode">'+hideLoginHistory[m].loginmode+'</td>'
			+'</tr>');
		$("#loginHistory_content").append(newRecord);
	}
	
	$("#recentNum").text(totalHoistoryNum);
	$("#showAllTextButton").text("收起");
	$("#showAllTextButton").unbind("click", showAllLoginHistory);
	$("#showAllTextButton").bind('click', hideAllLoginHistory);
}

function hideAllLoginHistory() {
	$("tr.hideandshow").remove();
	$("#recentNum").text("20");
	$("#showAllTextButton").text("查看所有");
	$("#showAllTextButton").unbind("click", hideAllLoginHistory);
	$("#showAllTextButton").bind('click', showAllLoginHistory);
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

//判断ip地址的合法性(IPV4 only)
function checkIP(value){
    var exp=/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/;
    var reg = value.match(exp);
    if(reg==null){
    	console.log("IP地址不合法！");
    	return false;
    } else {
    	return true;
    }
}