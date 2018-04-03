<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="css/common/header.css">
<style>

</style>
<div class="row">
	<div class="col-md-12">
		<nav class="navbar navbar-default">
			<div class="container-fluid">

				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"> <img class="brand"
						alt="Brand" src="imgs/logo.png">
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">

					<form class="navbar-form navbar-left">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="请输入搜索关键字" />
						</div>
						<button type="submit" class="btn btn-default">提交</button>
					</form>
					<c:if test="${user == null}">
						<ul class="nav navbar-nav navbar-right">

							<li>
								<!-- <a href="#">注册</a> -->
								<button type="button" class="btn btn-primary btn-lg"
									data-toggle="modal" data-target="#user-register">注册</button>
							</li>
							<li>
								<!-- <a href="javaScript:" >登录</a> --> <!-- Button trigger modal -->
								<button type="button" class="btn btn-primary btn-lg"
									data-toggle="modal" data-target="#user-login">登录</button> <!-- Modal -->
								<div class="modal fade" id="user-login" tabindex="-1" role="dialog"
									aria-labelledby="myModalLabel">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel">登录到一拍</h4>
											</div>
											<div class="modal-body">
												<form id="login" class="form-horizontal"
													action="user?method=login">
													<div class="form-group">
														<label for="inputEmail3" class="col-sm-2 control-label">邮箱地址</label>
														<div class="col-sm-10">
															<input name="email" type="email" class="form-control"
																id="inputEmail3" placeholder="Email">
														</div>
													</div>
													<div class="form-group">
														<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
														<div class="col-sm-10">
															<input name="password" type="password"
																class="form-control" id="inputPassword3"
																placeholder="Password">
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
															<div class="checkbox">
																<label> <input type="checkbox"> 记住我
																</label>
															</div>
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-offset-2 col-sm-10">
															<button type="button" onclick="login()"
																class="btn btn-default">登录</button>
														</div>
													</div>
												</form>

											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">关闭</button>
												<button type="button" class="btn btn-primary">保存</button>
											</div>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</c:if>

					<c:if test="${user != null}">
						<div id="upload-video" class="upload-video">
							<button onclick="uploadVideo()" type="button" id="myButton"
								data-loading-text="Loading..." class="btn btn-primary"
								autocomplete="off">
								<img src="imgs/upload.png" />上传
							</button>
						</div>
						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								<img style="width: 25px; height: 25px;" src="${user.userPic}" />${user.userNickname}<span
									class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
								<li><a href="#">我的主页</a></li>
								<li><a href="#">个人资料</a></li>
								<li><a href="#">退出</a></li>

							</ul>
						</div>
					</c:if>

				</div>

			</div>

		</nav>
	</div>

</div>
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-10">
		<ul id="menu" class="nav nav-pills">
			<li role="presentation" ><a href="index.jsp">首页</a></li>
			<!-- <li role="presentation"><a href="#">Profile</a></li>
					<li role="presentation"><a href="#">Messages</a></li> -->
		</ul>
	</div>
	<div class="col-md-1"></div>

</div>
<script src="js/jquery.min.js"></script>
<script src="js/common/header.js"></script>