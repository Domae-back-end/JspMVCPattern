<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 페이지</title>
<script>
	function deleteGo() {
		if(confirm("정말로 삭제하시겠습니까?")){
			frm.submit()
		}
	}
</script>
</head>
<body>
<h1>삭제 페이지</h1>
<form action="BoardDeleteReg" method="post" name="frm">
	<input type="hidden" name="id" value="${param.id }" />
	<input type="hidden" name="page" value="${param.page }" />
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" onclick="deleteGo()" value="삭제" />
				<input type="reset" value="초기화" />
				<a href="BoardDetail?id=${param.id }&page=${param.page}">뒤로</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>