<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체/일부 실패 결과화면</title>
</head>
<body>
	<div>
	<p>전체/일부 실패 결과화면</p>
	
	<% int test3 = (int)session.getAttribute("count_f"); %>
	
	<p> 실패 <%= test3 %> 건</p>
	
	<%
		ArrayList line_f = (ArrayList)session.getAttribute("line_f");
		ArrayList text_f = (ArrayList)session.getAttribute("text_f");
		
			for (int i=0; i<test3; i++){
	%>
			라인 <%= line_f.get(i) %> )
				<%= text_f.get(i) %> <br/>
	<%
			}
	%>	
	</div>
</body>
</html>
