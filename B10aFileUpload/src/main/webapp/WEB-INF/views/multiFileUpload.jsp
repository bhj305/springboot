<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>멀티파일업로드</title>
		<script>
		function validateForm(form){
			if(form.title.value == ""){
				alert("제목을 입력하세요.");
				form.title.focus();
				return false;
			}
			if(form.ofile.value == ""){
				alert("첨부파일은 필수입니다.");
				return false;
			}
		}
		</script>
	</head>
	<body>
	<h2>멀티파일업로드</h2>
	<form name="fileForm" method="post" enctype="multipart/form-data"
		action="multiUploadProcess.do" onsubmit="return validateForm(this);">
		제목: <input type="text" name="title"/><br/><br/>
		카테고리(선택사항): 
		<input type="checkbox" name="cate" value="사진" checked/>사진
		<input type="checkbox" name="cate" value="과제" />과제
		<input type="checkbox" name="cate" value="워드" />워드
		<input type="checkbox" name="cate" value="음원" />음원 <br/><br/>
		첨부파일: <input type="file" name="ofile" multiple/><br/><br/>
		<input type="submit" value="전송하기" />
	
	</form>
	</body>
</html>