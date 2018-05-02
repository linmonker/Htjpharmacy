<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加货位</title>
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/static/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		if ("1" == $("#hwzt").val) {
			$("select option:eq(1)").attr("selected", true);
		}
	})
</script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">宏济堂药房管理</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${ctx}/index">首页</a></li>
				<li><a>当前用户：</a></li>
				<li><a>${sessionScope.loginer.username }</a></li>
				<li><a>${sessionScope.loginer.fdmc }</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${ctx}/outlogin">退出</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 col-md-2 sidebar">
				<h4>管理项目</h4>
				<ul class="nav nav-sidebar">
					<li class="active"><a href="${ctx}/fendian/list">分店管理</a></li>
					<li><a href="${ctx}/yaopinfenlei/list">药品分类</a></li>
					<li><a href="${ctx}/yaopin/list">药品信息管理</a></li>
					<li><a href="${ctx}/gongyingshang/list">供应商管理</a></li>
					<li class="active"><a href="${ctx}/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list">科室管理</a></li>
					<li><a href="${ctx}/zhuzhijigou/list">组织机构</a></li>
					<li><a href="${ctx}/yonghu/sylist">用户管理</a></li>
					<li><a href="${ctx}/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<div>
					<label class="sub-header">添加货位</label>
					<input id="hwzt" type="hidden" value="${huowei.zt }" />
					<span>${addmsg}</span> <span>${bhmsg}</span> <span>${mcmsg}</span>
				</div>
				<form method="post" class="form-x" action="${ctx}/huowei/doadd">
					<input type="hidden" name="fdid" value="${huowei.fdid }" />
					<input type="hidden" name="ckid" value="${huowei.ckid }" />
					<div class="form-group">
						<div class="label">
							<label>货位编号：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="hwbh"
								value="${huowei.hwbh }" data-validate="required:请输入货位编号" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>货位名称：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="hwmc"
								value="${huowei.hwmc }" data-validate="required:请输入货位名称" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>货位名称简拼：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="hwmcjp"
								value="${huowei.hwmcjp }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>货位状态：</label>
						</div>
						<div class="field">
							<select class="form-control" name="zt">
								<option value="0">启用</option>
								<option value="1">禁用</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>备注信息：</label>
						</div>
						<div class="field">
							<textarea class="form-control" rows="3" name="hwbz">${huowei.hwbz }</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="field">
							<button class="button bg-main" type="submit">提交</button>
							<a class="button bg-red" href="${ctx}/huowei/list"
								style="margin-left: 10px;"> 取消</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>