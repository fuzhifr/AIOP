<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
window.onload=function(){
	showUserInfoList();
}
function showUserInfoList(){
	var url='/AIOP/affaire/42/scelles.html';
	var data={numeroPV:20000,commentaire:"first Scelle"};
	$.ajax({
		url:url,
		type:'POST',
		data:data,
		dataType:'json',
		success:function(json){
			console.log(json);
		},
		error:function(){
			alert("信息加载失败,请联系管理员");
		}
	});
}
</script>
</head>  
<body>  
${objets.size()}  
<br>  
${msg }  
</body>  
</html>  