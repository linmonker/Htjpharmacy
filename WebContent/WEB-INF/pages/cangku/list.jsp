<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓库列表</title>
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/static/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>

<script>
	function setid(element,id) {
		$("tr.active").removeClass("active");
		$(element).addClass("active");
		$("#tempid").text(id);
	}
	function edit() {
		if($("tr.active").length > 0){
			var id = $("#tempid").text();
			location = "${ctx}/cangku/edit.action?id=" + id;
		}else{
			alert("请先选择对象");
		}
	}
	function del() {
		if($("tr.active").length > 0){	
			if (confirm("您确定要删除 " + $("tr.active td:eq(1)").text() + " 吗?")) {	
				var id = $("#tempid").text();
				location = "${ctx}/cangku/delete.action?id=" + id;
			}
		}else{
			alert("请先选择对象");
		}
	}
	$(document).ready(function(){
		 var fdid_ = "<%=session.getAttribute("fdid")%>"; 
		 $("#fdid" + fdid_).addClass("active");
		});
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
					<li class="active"><a href="${ctx }/fendian/list.action">分店管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list.action">药品分类</a></li>
					<li><a href="${ctx }/yaopin/list.action">药品信息管理</a></li>
					<li><a href="${ctx }/gongyingshang/list.action">供应商管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<div class="row">
					<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">仓库列表</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li><a href="${ctx}/cangku/add.action">添加仓库</a></li>
								<li><a onclick="return edit()">修改仓库</a></li>
								<li><a onclick="return del()">删除仓库</a></li>
								<li><span id="tempid" style="display: none"></span></li>
							</ul>
							<div class="nav navbar-nav navbar-right">
								<form action="${ctx }/cangku/search.action" method="post">
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
					<div class="col-sm-2 col-md-2 sidebar">
						<h5>分店列表</h5>
						<ul class="nav nav-sidebar">
							<c:forEach items="${fendianlist }" var="fdlist">
								<li id="fdid${fdlist.id }"><a href="${ctx }/cangku/list.action?fdid=${fdlist.id }">${fdlist.fdmc }</a></li>
							</c:forEach>
						</ul>
					</div>
					<div class="col-sm-9 col-md-9">
						<h5>仓库列表</h5>
						<div class="table-responsive">
							<table class="table table-bordered table-condensed">
								<thead>
									<tr>
										<th>仓库编号</th>
										<th>仓库名称</th>
										<th>仓库名称简拼</th>
										<th>状态</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cangkulist }" var="cklist">
										<tr onclick="setid(this,${cklist.id })">
											<td>${cklist.ckbh }</td>
											<td>${cklist.ckmc }</td>
											<td>${cklist.ckmcjp }</td>
											<td><c:choose>
													<c:when test="${cklist.zt == 0}">启用</c:when>
													<c:otherwise>禁用</c:otherwise>
												</c:choose></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>