<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 성공 결과화면</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
</head>
<body>
	<div class="container">
		<div class="heading">
			<p>전체 성공 결과화면</p>
			<%= session.getAttribute("count")  %>건 입력성공 <br/>
			<br/>
	    </div>
	    <div class="body">
			<button type="submit" id="resBtn" name="resBtn" >조회</button>	    
	    	<table class="table">
	    		<c:forEach var="vo" items="${results}">
	    			<tr>
		    			<td>${vo.id}</td>
		    			<td>${vo.pwd}</td>
		    			<td>${vo.name}</td>
		    			<td>${vo.level}</td>
		    			<td>${vo.desc}</td>	
		    			<td>${vo.reg_Date}</td>		    			    				    				    			
	    			</tr>
	    		</c:forEach>
	    	</table>
	    </div> <!-- body -->
	</div> <!-- container -->
<script>
	$("#resBtn").click(function(){
	  $.ajax({
		  type:"post", // 보내는방식
		  url: "list.do",//보내는주소
		  success : ajaxHtml,
		  error : function(error, textStatus){
			  // 실패했을 때 실행
			  alert("오류");
			  console.log("error:", error);
			  console.log("textStatus:", textStatus);} // error 끝
	  }); // ajax 끝
	} // 익명함수 중괄호
	); // 이벤트 함수 소괄호
	
	function ajaxHtml(data){
		var html = "<table class='table'>";
		html += "<tr>";
		html += "<td>아이디</td>";
		html += "<td>비밀번호</td>";		
		html += "<td>이름</td>";
		html += "<td>레벨</td>";
		html += "<td>설명</td>";
		html += "<td>등록일자</td>";
		html += "</tr>";		
		
		$.each(data, (index, obj)=>{
			html += "<tr>";
			html += "<td>"+obj.id+"</td>";
			html += "<td>"+obj.pwd+"</td>";
			html += "<td>"+obj.name+"</td>";
			html += "<td>"+obj.level+"</td>";
			html += "<td>"+obj.desc+"</td>";			
			html += "<td>"+obj.reg_Date+"</td>";			
			html += "</tr>";			
		}) // each 끝
		
		html+="</table>";
		$("#resBtn").html(html);	
	}	
</script>
</body>
</html>
