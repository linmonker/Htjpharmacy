<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改货位</title>
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
				<li><a href="${ctx }index.action">首页</a></li>
				<li><label>当前用户：</label></li>
				<li><label>${session.loginer.login }</label></li>
				<li><label>${session.loginer.fdmc }</label></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">one</a></li>
				<li><a href="#">two</a></li>
				<li><a href="#">three</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 col-md-2 sidebar">
				<h4>管理项目</h4>
				<ul class="nav nav-sidebar">
					<li class="active"><a href="${ctx }/fendian/list.action">分店管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list.action">药品分类</a></li>
					<li><a href="${ctx }/yaopin/list.action">药品信息管理</a></li>
					<li><a href="${ctx }/gongyingshang/list.action">供应商管理</a></li>
					<li class="active"><a href="${ctx}/cangku/sylist.action">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list.action">科室管理</a></li>
					<li><a href="${ctx}/zhuzhijigou/list.action">组织机构</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<h4 class="sub-header">修改货位</h4>
				<form method="post" class="form-x"
					action="${ctx }/huowei/doedit.action">
					<span>${editmsg}</span> <span>${bhmsg }</span>
					<input type="hidden" name="id" value="${huowei.id }" />
					<input type="hidden" name="fdid" value="${huowei.fdid }" />
					<input type="hidden" name="ckid" value="${huowei.ckid }" />
					<input id="hwzt" type="hidden" value="${huowei.zt }" />
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
								value="${huowei.ckmcjp }" />
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
						<div class="label">
							<label></label>
						</div>
						<div class="field">
							<button class="button bg-main" type="submit">提交</button>
							<button class="button bg-main" type="reset">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>