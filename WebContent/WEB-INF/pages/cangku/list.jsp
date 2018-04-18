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
		$("#tempid").val(id);
	}
	function edit() {
		if($("tr.active").length > 0){
			var id = $("#tempid").val();
			location = "${ctx}/cangku/edit.action?id=" + id;
		}else{
			alert("请先选择仓库");
		}
	}
	function del() {
		if($("tr.active").length > 0){	
			if (confirm("您确定要删除 " + $("tr.active td:eq(1)").text() + " 吗?")) {	
				var id = $("#tempid").val();
				location = "${ctx}/cangku/delete.action?id=" + id;
			}
		}else{
			alert("请先选择仓库");
		}
	}
	function huowei() {
		if($("tr.active").length > 0){	
			var id = $("#tempid").val();
			location = "${ctx}/huowei/list.action?ckid=" + id;
		}else{
			alert("请先选择仓库");
		}
	}
	function toexcel() {
	    $("#tablepot").table2excel({
		    exclude: ".noExl",
		    name: "Excel Document Name",
		    filename: "仓库列表",
		    exclude_img: true,
		    exclude_links: true,
		    exclude_inputs: true
		});
	}
	$(document).ready(function(){
		 var fdid = $(input[name='fdid']).val;
		 $("#fdid" + fdid).addClass("active");
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
		<div id="navbar" class="row navbar-collapse collapse">
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
								<li><a onclick="return huowei()">货位管理</a></li>
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
					<input type="hidden" id="tempid" />
					<input type="hidden" name="fdid" value="${cangkulist.fdid }" />
					<span>${addmsg}</span> <span>${editmsg}</span> <span>${deletemsg}</span>
				</div>
				<div class="row">
					<div class="col-sm-2 col-md-2 sidebar">
						<h4>分店列表</h4>
						<ul class="nav nav-sidebar">
							<c:forEach items="${fendianlist }" var="fdlist">
								<li id="fdid${fdlist.id }"><a
									href="${ctx }/cangku/list.action?fdid=${fdlist.id }">${fdlist.fdmc }</a></li>
							</c:forEach>
						</ul>
					</div>
					<div class="col-sm-9 col-md-9">
						<h4>仓库列表</h4>
						<span>共${cangkulist.size() }条记录</span>
					    <button class="btn btn-primary btn-sm" onclick="toexcel()">导出Excel</button>
						<div class="table-responsive">
							<table id="tablepot" class="table table-bordered table-condensed">
								<thead>
									<tr>
										<th>仓库编号</th>
										<th>仓库名称</th>
										<th>仓库名称简拼</th>
										<th>备注</th>
										<th>状态</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cangkulist }" var="cklist">
										<tr onclick="setid(this,${cklist.id })">
											<td>${cklist.ckbh }</td>
											<td>${cklist.ckmc }</td>
											<td>${cklist.ckbz }</td>
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