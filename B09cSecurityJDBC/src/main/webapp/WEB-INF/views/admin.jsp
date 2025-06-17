<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Admin</title>
	</head>
	<body>
		<h2>Admin 영역</h2>
		ADMIN 권한만 접근할 수 있습니다. <br/>
		<s:authorize access="hasRole('ADMIN')">
			로그인 아이디: <s:authentication property="name"/>
		</s:authorize>
		<%@ include file= "/link.jsp" %>
	</body>
</html>