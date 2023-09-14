<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>학사관리</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
<style>
.primary {
	margin-right: 10px;
}
</style>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">
		<form name="choiceBtn" method="post">
			<table border="1">
				<thead>
					<tr>
						<th>글번호</th>
						<th>작성자</th>
						<th>내용</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="bid" value="${dyoung.bid }"
							readonly="readonly"></td>
						<td><input type="text" name="writer"
							value="${dyoung.writer }" required="required"></td>
						<td><input type="text" name="content"
							value="${dyoung.content }" required="required"></td>
						<td><input type="text" name="regdate"
							value="${dyoung.regdate }" readonly="readonly"></td>
					</tr>
					<tr>
						<c:if test="${!empty check}">
							<td>
								<button type="submit" formaction="boardupdate.do">게시글내용변경하기</button>
							</td>
						</c:if>
						<td colspan="4" align="right">
							<button type="submit" formaction="main.do">메인화면</button>
						</td>

					</tr>
				</tbody>
			</table>
		</form>
		<a href="main.do"></a>
	</div>
	<!-- BG -->
	<div id="bg"></div>
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>
