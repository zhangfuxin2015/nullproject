//zfx2015.9.29  上传图片的时候显示图片 的方法（没看）
	function clacImgZoomParam( maxWidth, maxHeight, width, height ){ 
		var param = {top:0, left:0, width:width, height:height}; 
		if( width>maxWidth || height>maxHeight ) 
		{ 
		rateWidth = width / maxWidth; 
		rateHeight = height / maxHeight; 

		if( rateWidth > rateHeight ) 
		{ 
		param.width = maxWidth; 
		param.height = Math.round(height / rateWidth); 
		}else 
		{ 
		param.width = Math.round(width / rateHeight); 
		param.height = maxHeight; 
		} 
		} 
		param.left = Math.round((maxWidth - param.width) / 2); 
		param.top = Math.round((maxHeight - param.height) / 2); 
		return param; 
		} 
	//zfx2015.9.29  上传图片的时候显示图片
	function getFileUrl(sourceId,file,targetId) { 
		var url; 
		if (!!window.ActiveXObject || "ActiveXObject" in window) { // IE
			var div = document.getElementById('divNewPreview'); 
			var MAXWIDTH = 100; 
			var MAXHEIGHT = 100; 
			if (file.files && file.files[0]) 
			{ 		//ie 10\11
				div.innerHTML = '<img id='+targetId+'>'; 
				//imgPre
				var img = document.getElementById(targetId); 
				img.onload = function(){ 
				var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight); 
				img.width = rect.width; 
				img.height = rect.height; 
				img.style.marginLeft = rect.left+'px'; 
				img.style.marginTop = rect.top+'px'; 
				} 
				var reader = new FileReader(); 
				reader.onload = function(evt){img.src = evt.target.result;} 
				reader.readAsDataURL(file.files[0]); 
			} else{
				//ie9
				var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="'; 
				file.select(); 
				file.blur();
				var src = document.selection.createRange().text; 
				url=src;
				var img = document.getElementById(targetId);
				img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src; 
				var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight); 
				status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height); 
				div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;margin-left:"+rect.left+"px;"+sFilter+src+"\"'></div>"+'<img id='+targetId+'>'; 

			}
			
		} else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox
			url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
			var imgPre = document.getElementById(targetId); 
			imgPre.src = url; 
		} else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome 
			url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
			var imgPre = document.getElementById(targetId); 
			imgPre.src = url; 
		} 
			return url; 
		} 

		/** 
		* zfx2015.9.29将本地图片 显示到浏览器上 
		*/ 
		function preImg(sourceId, targetId,file) {
			var url = getFileUrl(sourceId,file,targetId); 
		} 
		/**
		 * 关于浏览器上面显示上传图片预览，同时还要
		 * <style type="text/css">#imgPre{filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);} </style>
		 */
		
	
//图标上传
function submitico(){
	alert("saf");
	 $("#icoform").ajaxSubmit({  
         type:"post",  //提交方式  
         dataType:"text", //数据类型  
         url:"<%=request.getContextPath() %>/uploadIco.do", //请求url  
         success: function(data){ //提交成功的回调函数  
             if(data=="ok"){
             	  $(".succeed").show();
             }else{
            	 alert(data);
             }
           
         }  
     });  
}
		