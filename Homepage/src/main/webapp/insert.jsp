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
		<h1>게시판글등록하기</h1>
	<form action="insert.do" method="post">
		<table border="1">
			<tr>
				<th>작성자</th>
				<th>내용</th>
			</tr>
			<tr>
				<td><input type="text" name="writer" required="required"></td>
				<td><input type="text" name="content" required="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="글등록하기"></td>
			</tr>
		</table>
	</form>
	<a href="main.do">메인화면</a>
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

