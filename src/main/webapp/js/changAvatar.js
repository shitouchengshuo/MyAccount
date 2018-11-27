$(window).load(function() {


			//$(".imageBox").css("cssText","background-position:88px 88px!important");$(".imageBox").css("cssText","background-size:222px 222px!important");

			var options =

			{

				thumbBox : '.thumbBox',

				spinner : '.spinner',

				imgSrc : ''

			}

			var cropper = $('.imageBox').cropbox(options);

			var img = "";

			$('#upload-file').on('change', function() {

				var reader = new FileReader();

				reader.onload = function(e) {

					options.imgSrc = e.target.result;

					cropper = $('.imageBox').cropbox(options);

					getImg();

				}

				reader.readAsDataURL(this.files[0]);

				this.files = [];

				//getImg();

			})

			function getImg(){

				img = cropper.getDataURL();

				 $('.cropped').html('');

				 $('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:180px;margin-top:4px;box-shadow:0px 0px 12px #7E7E7E;">');

				// $('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:128px;margin-top:4px;border-radius:128px;box-shadow:0px 0px 12px #7E7E7E;"><p>128px*128px</p>');

				// $('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:64px;margin-top:4px;border-radius:64px;box-shadow:0px 0px 12px #7E7E7E;" ><p>64px*64px</p>');

				}

				

			$(".imageBox").on("mouseup",function(){

		 		getImg();

		  		});

				

				

			$('#btnZoomIn').on('click', function(){

				cropper.zoomIn();
				getImg();

			})

			$('#btnZoomOut').on('click', function(){

				cropper.zoomOut();
				getImg();

			})
			
			$("#btnCrop").click(function(){
				
				img = cropper.getDataURL();
				
				if(img==""){
					alert("请选择图片");
					return false;
				}
				
				
				$.ajax({
					url:context+"/ui/uploadAvatar",
					type:"POST",
					data:{
						imgData:img
					},
					dataType:"json",
					success:function(data){
						console.log(data);
						if(data.error=="0"){
							/*alert("上传成功");*/
							location.href=context+"/ui/index";
						}else if(data.error=="50"){
							alert("服务器异常");
						}
					}
						
				});
				
				
					
				
				
				
			});
			
			
			
			
			
			
			
			
			
			
});























