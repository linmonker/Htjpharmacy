<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"
				style="border: 2px solid #a1a1a1; border-radius: 10px; position: absolute; left: 33%; top: 30%;">
				<form class="form-horizontal" action="dologin" method="post">
					<div class="form-group">
						<h2 class="col-md-offset-2">某中医馆药房管理</h2>
					</div>
					<div class="form-group">
						<label for="username" class="col-md-2 control-label col-md-offset-1">用户名</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="username"
								placeholder="登录账号" value="${username }">
							<span class="icon icon-user margin-small"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-2 control-label col-md-offset-1">密码</label>
						<div class="col-md-8">
							<input type="password" class="form-control" name="password"
								placeholder="登录密码">
							<span class="icon icon-key margin-small"></span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-4">
							<button class="btn btn-primary" type="submit">登录</button>
							<span class="errormsg">${loginmsg }</span>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>