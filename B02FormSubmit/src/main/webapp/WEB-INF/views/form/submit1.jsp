<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>submit1</title>
	</head>
	<body>
		<h2>폼값전송1: HttpServletRequest 내장객체</h2>
		<p>
			이름: ${name} <br/>
			나이: ${age}
		</p>
		<ul>
			<li><a href="/">루트</a></li>
		</ul>
	</body>
</html>