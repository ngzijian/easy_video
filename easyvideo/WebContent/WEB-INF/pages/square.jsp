<%@ page language="java" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 101 Template</title>


<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="css/square.css" rel="stylesheet">
</head>

<body>

	<div class="container">

		<jsp:include page="../../common/header.jsp" flush="true" />

		<div class="row">
			<div id="videos" class="col-md-8">
				<input type="hidden" id="type" value="${cate.cateId}" />
				<div class="col-md-12">
					<h2 class="cate-name">${cate.cateName}</h2>
				</div>

			</div>
			<jsp:include page="../../common/right.jsp" flush="true" />

		</div>

		<script src="js/bootstrap/bootstrap.min.js"></script>
		<script src="js/square.js"></script>
</body>

</html>