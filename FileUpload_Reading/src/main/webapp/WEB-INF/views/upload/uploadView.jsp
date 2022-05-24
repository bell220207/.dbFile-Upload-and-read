<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<title>업로드 화면</title>
<script>

$(function(){

});

function fileSend(){
	var ext = $('#file').val().split('.').pop().toLowerCase(); // 확장자 구하기
	console.log(ext);
	
	if(ext=='dbfile'){
		return true;
	}else if(ext==''){
		alert("파일을 선택해주세요.");
		return false;
	}else{
		alert("확장자는 dbfile만 가능합니다.");
		return false;
	}
}
</script>
</head>
<body>
	<h2> 업로드 페이지 </h2>
		<form action="data" method="post" onsubmit="return fileSend()" enctype="multipart/form-data"> 
		<!-- enctype 속성: 자바에서 file로 받기위해 추가 -->
			<input type="file" name="file" id="file"><br> <!-- name 속성이 있어야 한다 -->
    		<button id="sbmBtn">제출</button>
		</form>
</body>
</html>