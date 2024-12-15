<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sitemesh:write property="head" />
<!-- Thêm liên kết tới Boxicons -->
<link href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css"
	rel="stylesheet" />
<title>Cosmetics</title>
</head>
<body>
	<header>
		<div>
			<%@ include file="/common/admin/header.jsp"%>
		</div>
	</header>

	<main>
		<div>
			<sitemesh:write property='body'></sitemesh:write>
		</div>
	</main>

	<footer>
		<div>
			<%@ include file="/common/admin/footer.jsp"%>
		</div>
	</footer>
</body>
</html>