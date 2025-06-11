<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>submit3</title>
	</head>
	<body>
		<h2>폼값전송3: 커맨드 객체</h2>
		<p>
			이름: ${personDTO.name} <br/>
			나이: ${personDTO.age}
		</p>
		<img src="./images/SpringBoot.png" />
		<ul>
			<li><a href="/">루트</a></li>
		</ul>
	</body>
</html>