<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
		<body>
			<a href="/index.html">메인</a>
			<table>
				<thead>
					<th>id</th>
					<th>username</th>
					<th>age</th>
				</thead>
				<tbody>
				<c:forEach var="item" items="${members}">	<!-- for문 -->
					<tr>
						<td>${item.id}</td>
						<td>${item.username}</td>
						<td>${item.age}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</body>
</html>