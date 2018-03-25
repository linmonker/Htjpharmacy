<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>药品列表</title>
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/static/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>

<script>
	function setid(element, id) {
		$("tr.active").removeClass("active");
		$(element).addClass("active");
		$("#tempid").text(id);
	}
	function edit() {
		if($("tr.active").length > 0){
			var id = $("#tempid").text();
			location = "${ctx}/yaopin/edit.action?id=" + id;
		}else{
			alert("请先选择对象");
		}
	}
	function del() {
		if($("tr.active").length > 0){
			if (confirm("您确定要删除 " + $("tr.active td:eq(1)").text() + " 吗?")) {	
				var id = $("#tempid").text();
				location = "${ctx}/yaopin/delete.action?id=" + id;
			}
		}else{
			alert("请先选择对象");
		}
	}
</script>
</head>
<body>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">宏济堂药房管理</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${ctx }/index.action">首页</a></li>
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
		<div id="navbar" class="row navbar-collapse collapse">
			<div class="col-sm-2 col-md-2 sidebar">
				<h4>管理项目</h4>
				<ul class="nav nav-sidebar">
					<li><a href="${ctx }/fendian/list.action">分店管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list.action">药品分类</a></li>
					<li class="active"><a href="${ctx }/yaopin/list.action">药品信息管理</a></li>
					<li><a href="${ctx }/gongyingshang/list.action">供应商管理</a></li>
					<li><a href="${ctx}/cangku/sylist.action">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list.action">科室管理</a></li>
					<li><a href="${ctx}/zhuzhijigou/list.action">组织机构</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<div class="row">
					<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">药品列表</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li><a href="${ctx}/yaopin/add.action">添加药品</a></li>
								<li><a onclick="return edit()">修改药品</a></li>
								<li><a onclick="return del()">删除药品</a></li>
								<li><span id="tempid" style="display: none"></span></li>
							</ul>

							<div class="nav navbar-nav navbar-right">
								<form action="${ctx }/yaopin/search.action" method="post">
									<input type="text" placeholder="请输入搜索关键字" name="searchword"
										class="input"
										style="width: 250px; line-height: 15px; display: inline-block;"
										required="required" />
									<button type="submit" class="button border-main">搜索</button>
								</form>
							</div>

						</div>
					</div>
					</nav>
					<span style="margin-left: 50px; font-size: 20px">${adddata}</span>
					<span style="margin-left: 50px; font-size: 20px">${deletedata}</span>
				</div>
				<div class="row">
					<div class="table-responsive">
						<table class="table table-bordered table-condensed">
							<thead>
								<tr>
									<th>药品编号</th>
									<th>药品名称</th>
									<th>通用名</th>
									<th>生产单位</th>
									<th>剂型</th>
									<th>零售价</th>
									<th>库存</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${yaopinlist }" var="list">
									<tr>
										<td>${list.ypbh }</td>
										<td>${list.ypspm }</td>
										<td>${list.yptym }</td>
										<td>${list.ypscdw }</td>
										<td>${list.ypjx }</td>
										<td>${list.yplsj }</td>
										<td>${list.ypkcsl }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>