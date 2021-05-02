<%@page import="model.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list 페이지</title>
</head>
<body>
<h1>list 페이지 입니다.</h1>
<table border="">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
	</tr>
<c:forEach var="dto" items="${data }" varStatus="no">
	<tr>
		<td>${pd.start + no.index }</td>
		<td><a href="BoardDetail?id=${dto.id }&page=${pd.page}">${dto.title }</td>
		<td>${dto.pname }</td>
		<td><fmt:formatDate value="${dto.reg_date }" pattern="yyyy-MM-dd HH:mm" /></td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="4" align="center">
		<c:if test="${pd.startPage > 1 }">
			<a href="?page=${pd.startPage-1 }"> < </a>
		</c:if>
			<c:forEach begin="${pd.startPage }" end="${pd.endPage }" step="1" var="i">
				<c:choose>
					<c:when test="${i == pd.page }">
					[${i }]
					</c:when>
					<c:otherwise>
						<a href="?page=${i }">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		<c:if test="${pd.endPage < pd.total }">
			<a href="?page=${pd.endPage+1 }"> > </a>
		</c:if>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<a href="BoardInsert">글 쓰기</a>
		</td>
	</tr>
</table>
</body>
</html>