<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加分店</title>
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/static/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">宏济堂药房管理</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${ctx}/index.action">首页</a></li>
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
					<li class="active"><a href="${ctx}/fendian/list.action">分店管理</a></li>
					<li><a href="${ctx}/yaopinfenlei/list.action">药品分类</a></li>
					<li><a href="${ctx}/yaopin/list.action">药品信息管理</a></li>
					<li><a href="${ctx}/gongyingshang/list.action">供应商管理</a></li>
					<li><a href="${ctx}/cangku/sylist.action">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list.action">科室管理</a></li>
					<li><a href="${ctx}/zhuzhijigou/list.action">组织机构</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<div class="field">
					<label class="sub-header">添加分店</label>
					<span>${addmsg}</span> <span>${bhmsg}</span> <span>${mcmsg}</span>
				</div>
				<form method="post" class="form-x" action="${ctx}/fendian/doadd.action">
					<div class="form-group">
						<div class="label">
							<label>分店编号：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="fdbh"
								value="${fendian.fdbh }" data-validate="required:请输入分店编号" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>分店名称：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="fdmc"
								value="${fendian.fdmc }" data-validate="required:请输入分店名称" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>联系电话：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="fdlxdh"
								value="${fendian.fdlxdh }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>店长姓名：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="fddzxm"
								value="${fendian.fddzxm }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>分店地址：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="fddz"
								value="${fendian.fddz }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>备注信息：</label>
						</div>
						<div class="field">
							<textarea class="form-control" rows="3" name="fdbz">${fendian.fdbz }</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="field">
							<button class="button bg-main" type="submit">提交</button>
							<a class="button bg-red" href="${ctx}/fendian/list.action"
								style="margin-left: 10px;"> 取消</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>