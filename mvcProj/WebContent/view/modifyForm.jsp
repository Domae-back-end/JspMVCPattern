<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
<script>
	function fileDelete() {
		if(confirm("정말로 파일을 삭제하시겠습니까?")){
			frm.action = "FileDelete"
			frm.enctype="application/x-www-form-urlencoded"
			frm.submit()
		}
	}
</script>
</head>
<style>
img {
	width: 500px;
	height: 500px;
}
</style>
<body>
	<h1>수정 페이지</h1>
	<form action="BoardModifyReg" method="post"
		enctype="multipart/form-data" name="frm">
		<input type="hidden" name="id" value="${data.id }" />
		<input type="hidden" name="page" value="${param.page }" />
		<table border="">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value=${data.title } /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="pname" value=${data.pname } /></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="pw" /></td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
				<c:choose>
					<c:when test="${data.upfile != null }">
						<c:choose>
							<c:when test="${data.img }">
								<img alt="이미지파일 없음." src='<c:url value="/up/${data.upfile }" />' />
							</c:when>
							<c:otherwise>
								${data.upfile }
							</c:otherwise>
						</c:choose>
						<input type="hidden" name="upfile" value="${data.upfile }"/>
						<input type="button" value="파일삭제" onclick="fileDelete()"/>
					</c:when>
					<c:otherwise>
						<input type="file" name="upfile" /></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="10" cols="30">${data.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="수정" />
					<input type="reset" value="초기화" /> 
					<a href="BoardDetail?id=${param.id }&page=${param.page}">뒤로</a></td>
			</tr>
		</table>
	</form>
</body>
</html>