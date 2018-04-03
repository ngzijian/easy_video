<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 101 Template</title>


<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/watch.css">

</head>

<body>

	<div class="container">

		<jsp:include page="../../common/header.jsp" flush="true" />

		<div class="row">
			<div id="videos" class="col-md-8">
				<div id="videos" class="col-md-2"></div>
				<div id="videos" class="col-md-9">
					<div id="videos" class="col-md-12">
						<embed autoplay="autoplay" src="${video.videoPath}" width="480"
							height="400">
						</embed>
					</div>
					<div class="col-md-2">${video.videoViewcount}播放</div>
					<div class="col-md-6"></div>
					<div class="col-md-4">
						<fmt:formatDate value='${video.videoUploadtime}'
							pattern='yyyy-MM-dd HH:mm' />
					</div>
					<div class="col-md-12 video-info">
						<h4>&nbsp;&nbsp;${video.videoInfo}</h4>
					</div>
					<div class="col-md-4">
						<a href="javaScript:" onclick="fav(${video.videoId},this)"
							class="btn btn-default" role="button"><img class="fav-img"
							src="imgs/fav.png" /><span>${video.	videoFavcount}</span></a>
					</div>
					<div class="col-md-4">

						<a href="javaScript:void(0)" onclick="document.getElementById('input-info').focus();" class="btn btn-default" role="button"><img
							class="fav-img" src="imgs/comm.png" /><span id = "comm">${video.videoComms}</span></a>

					</div>
					<div class="col-md-4">收藏</div>
					<div id="video-info" class="col-md-12">
						<div class="col-md-12">
							<div class="input-group div-info">
								<input id="input-info" type="text" class="form-control"
									placeholder="写评论，分享你的感受"> <span class="input-group-btn">
									<button onclick="sendinfo()" class="btn btn-default send-info"
										type="button">发送</button>
								</span>
							</div>
						</div>
						<div id="comm-info" class="col-md-12 comm-info">
							<!-- <div class="col-md-12 div-comm">
								<div class="col-md-3">
									<div class="col-md-12">
										<a href="" class="btn btn-default" role="button"><span
											class="user-pic"><img class="icons-img"
												src="test/imgs/head.jpg" /></span></a>
									</div>
									<div class="col-md-12">
										<span>用户名</span>
									</div>
									<div class="col-md-12">回复@</div>
									<div class="col-md-12">sfdfasefr</div>
								</div>
								<div class="col-md-6">
									<div class="col-md-12"></div>
									<div class="col-md-12">&nbsp;&nbsp;评论内容评论内容评论内容评论内</div>
								</div>
								<div class="col-md-3">
									<div class="col-md-12">1990-3-4 34:46</div>
									<div class="col-md-12"><h4>回复</h4></div>
								</div>
							</div> -->
						</div>
						<div class="col-md-12 comm-info">
							<div class="col-md-6 comm-info">
								<h4 onclick="comms(-1)">上一页</h4>
							</div>
							<div class="col-md-6 comm-info">
								<h4 onclick="comms(1)">下一页</h4>
							</div>
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="../../common/right.jsp" flush="true" />

		</div>
		

	</div>

	<script src="js/bootstrap/bootstrap.min.js"></script>
	<script>
		var videoId = '${video.videoId}'
	</script>
	<script src="js/watch.js"></script>

</body>

</html>