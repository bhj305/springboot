<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>home</title>
	</head>
	<body>
		<h2>스프링 부트 프로젝트</h2>
		<ul>
			<li><a href="/">루트</a></li>
		</ul>
		<h2>JdbcTemplate으로 구현한 회원관리</h2>
		<ul>
			<li><a href="./list.do">회원목록</a>
				<ul>
					<li><a href="./regist.do">회원등록</a></li>
				</ul>			
			</li>
		</ul>
	</body>
</html>