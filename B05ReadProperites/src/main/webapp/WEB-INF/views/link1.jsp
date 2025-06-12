<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>link1</title>
	</head>
	<body>
		<h2>사용자 정의 properies 파일에서 가져오기</h2>
		<ul>
			<li>testKey1:  ${ testKey1 }</li>
			<li>testKey2:  ${ testKey2 }</li>
		</ul>
		
		<ol>
		<c:forEach items="${ testKey3 }" var="item">
			<li>testKey3: ${ item }</li>
		</c:forEach>
		</ol>
	</body>
</html>