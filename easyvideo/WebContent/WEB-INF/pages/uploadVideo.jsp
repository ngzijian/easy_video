<%@ page language="java" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 101 Template</title>

<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/uploadVideo.css">
</head>

<body>

	<div class="container">

		<jsp:include page="../../common/header.jsp" flush="true" />

		<div class="row">
			<div id="videos" class="col-md-8">
				<div id="videos" class="col-md-2"></div>
				<div id="videos" class="col-md-8 upvideo-form">
					<iframe name="upload-iframe"
						style="width: 0; height: 0; border: none;"></iframe>

					<form id="videoForm" action="user.html?method=uploadVideo"
						target="upload-iframe" enctype="multipart/form-data" method="post">
						<div class="form-group">
							<label for="uploadvideo">选择视频</label> <input type="file"
								name="uploadvideo" id="uploadvideo">
							<p class="help-block">选择需要上传的视频</p>
						</div>
						<div class="form-group">
							<label for="category">视频类型</label> <select id="category"
								name="category" class="form-control">

							</select>
						</div>
						<div class="form-group">
							<label for="videoname">视频标题</label> <input type="text"
								class="form-control" id="videoname" name="videoname"
								placeholder="金刚狼">
						</div>
						<div class="form-group">
							<label for="videoinfo">视频描述</label> <input type="text"
								class="form-control" id="videoinfo" name="videoinfo"
								placeholder="">
						</div>

						<button onclick="showStatus()" type="button"
							id="up-btn" class="btn btn-default">上传视频</button>
					</form>
					<div
						style="position: relative; top: 5px; bottom: 15px; display: none;"
						id="progress" class="progress">
						<div id="progress-bar" class="progress-bar" role="progressbar"
							aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
							style="width: 60%;">
							<span id="sr-only" class="sr-only">60% Complete</span>
						</div>
						
					</div>
					<div id="progress-info"></div>

				</div>
				<div id="videos" class="col-md-2"></div>
			</div>
			<jsp:include page="../../common/right.jsp" flush="true" />

		</div>

		<script src="js/bootstrap/bootstrap.min.js"></script>
		<script src="js/uploadVideo.js"></script>
</body>

</html>