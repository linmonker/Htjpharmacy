<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商列表</title>
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/static/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>

<script>
	function del(bh) {
		if (confirm("您确定要删除 " + bh + " 吗?")) {
			location = "${ctx}/gongyingshang/delete?gysbh=" + bh;
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
		<div id="navbar" class="row navbar-collapse collapse">
			<div class="col-sm-2 col-md-2 sidebar">
				<h4>管理项目</h4>
				<ul class="nav nav-sidebar">
					<li><a href="${ctx }/fendian/list.action">分店管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list.action">药品分类</a></li>
					<li><a href="${ctx }/yaopin/list.action">药品信息管理</a></li>
					<li class="active"><a href="${ctx }/gongyingshang/list.action">供应商管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<div class="row">
					<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">供应商列表</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li><a href="add.action">添加供应商</a></li>
								<li><span style="margin-left: 50px; font-size: 20px">${adddata}</span></li>
								<li><span style="margin-left: 50px; font-size: 20px">${deletedata}</span></li>
							</ul>

							<div class="nav navbar-nav navbar-right">
								<form action="${ctx }/gongyingshang/search" method="post">
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
				</div>
				<div class="row">
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th width="10%">供应商编号</th>
									<th>供应商名称</th>
									<th>联系人</th>
									<th>供应商电话</th>
									<th>业务员</th>
									<th>业务员电话</th>
									<th>供应商地址</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${gyslist }" var="list">
									<tr>
										<td>${list.gysbh }</td>
										<td>${list.gysmc }</td>
										<td>${list.gyslxr }</td>
										<td>${list.gyslxdh }</td>
										<td>${list.gysywy}</td>
										<td>${list.gysywydh}</td>
										<td>${list.gysxxdz}</td>
										<td>
											<div class="button-group">
												<a type="button" class="button border-main"
													href="${ctx }/gongyingshang/edit?gysbh=${list.gysbh }">修改</a>
												<a type="button" class="button border-red"
													onclick="return del('${list.gysbh}')">删除</a>
											</div>
										</td>
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