<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/js/jquery-1.7.2.js"></script>

<script type="text/javascript">
 test={
	ajaxpost:function(){
		$.ajax({
		    url:"<%=request.getContextPath()%>/zhangfuxin/getu.do",  
		    type: "POST",
		    dataType : 'json',
		    data:{"name":'张福新',"password":'123456'},
		    contentType:'application/x-www-form-urlencoded; charset=UTF-8',
		    success: function(mes){
		    }
		});
	}
 }

</script>
</head>
<body>
张福新测试
<input type="button" value="测试" onclick="test.ajaxpost()"/>

</body>
</html>