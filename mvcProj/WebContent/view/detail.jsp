<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<style>
	img{
		width: 500px;
		height: 500px;
	}
</style>
</head>
<body>
	<table border="">
		<tr>
			<td>id</td><td>${data.id }</td>
		</tr><tr>
			<td>제목</td><td>${data.title }</td>
		</tr><tr>
			<td>작성자</td><td>${data.pname }</td>
		</tr><tr>
			<td>작성일</td><td><fmt:formatDate value="${data.reg_date }" pattern="yyyy-MM-dd HH:mm" /></td>
		</tr><tr>
			<td>조회수</td><td>${data.cnt }</td>
		</tr><tr>
			<td>파일</td>
			<td>
			<c:if test="${data.upfile != null }">
				<c:choose>	
					<c:when test="${data.img }">
						<img alt="이미지파일 없음." src='<c:url value="/up/${data.upfile }" />' />
					</c:when>
					<c:otherwise>
						<a href="FileDown?fname=${data.upfile }"> ${data.upfile }</a>
					</c:otherwise>
				</c:choose>
			</c:if>
			</td>
		</tr><tr>
			<td>내용</td><td>${data.contentBr }</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<a href="BoardList?page=${param.page}">목록</a>
			<a href="BoardModifyForm?id=${data.id }&page=${param.page}">수정</a>
			<a href="BoardDeleteForm?id=${data.id }&page=${param.page}">삭제</a>
			</td>
		</tr>
	</table> 
</body>
</html>