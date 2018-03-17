<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改分店</title>
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
				<li><a href="${ctx }index.action">首页</a></li>
				<li><a href="#">关于</a></li>

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
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<h4 class="sub-header">修改分店</h4>
				<form method="post" class="form-x" action="${ctx }/fendian/doedit">
					<span style="margin-left: 50px; color: red; font-size: 20px">${editdate}</span>
					<input type="hidden" name="id" value="${fendian.id }" />
					<div class="form-group">
						<div class="label">
							<label>集团ID：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" name="jtid"
								value="${fendian.jtid }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>分店编号：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" name="fdbh"
								value="${fendian.fdbh }" data-validate="required:请输入分店编号" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>分店名称：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" name="fdmc"
								value="${fendian.fdmc }" data-validate="required:请输入分店名称" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>联系电话：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" name="fdlxdh"
								value="${fendian.fdlxdh }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>店长姓名：</label>
						</div>
						<div class="field">
							<input type="text" class="input w50" name="fddzxm"
								value="${fendian.fddzxm }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>分店地址：</label>
						</div>
						<div class="field">
							<input type="text" class="input" name="fddz"
								value="${fendian.fddz }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>备注信息：</label>
						</div>
						<div class="field">
							<textarea class="input" rows="3" name="fdbz">${fendian.fdbz }</textarea>
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