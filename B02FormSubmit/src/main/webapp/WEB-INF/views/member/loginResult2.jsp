<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>로그인결과</title>
	</head>
	<body>
		<h2>퀴즈] 로그인폼에서 전송된 값</h2>
		<p>
			<ul>
				<li>아이디: ${ quizVO.id }</li>
				<li>비밀번호: ${ quizVO.passwd }</li>
			</ul>
		</p>
	</body>
</html>