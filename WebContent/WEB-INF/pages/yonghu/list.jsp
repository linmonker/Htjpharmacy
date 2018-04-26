<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
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
			location = "${ctx}/yonghu/edit?id=" + id;
		}else{
			alert("请先选择用户");
		}
	}
	function del() {
		if($("tr.active").length > 0){	
			if (confirm("您确定要删除 " + $("tr.active td:eq(1)").text() + " 吗?")) {	
				var id = $("#tempid").val();
				location = "${ctx}/yonghu/delete?id=" + id;
			}
		}else{
			alert("请先选择用户");
		}
	}
	function toexcel() {
	    $("#tablepot").table2excel({
		    exclude: ".noExl",
		    name: "Excel Document Name",
		    filename: "用户列表",
		    exclude_img: true,
		    exclude_links: true,
		    exclude_inputs: true
		});
	}
	$(document).ready(function(){
		 var fdid = $("input[name='fdid']").val();
		 $("#fdid"+fdid).addClass("active");
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
				<li><a href="${ctx }/index">首页</a></li>
				<li><a>当前用户：</a></li>
				<li><a>${session.loginer.login }</a></li>
				<li><a>${session.loginer.fdmc }</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${ctx}/outlogin">退出</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container-fluid">
		<div id="navbar" class="row navbar-collapse collapse">
			<div class="col-sm-2 col-md-2 sidebar">
				<h4>管理项目</h4>
				<ul class="nav nav-sidebar">
					<li><a href="${ctx }/fendian/list">分店管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list">药品分类</a></li>
					<li><a href="${ctx }/yaopin/list">药品信息管理</a></li>
					<li><a href="${ctx }/gongyingshang/list">供应商管理</a></li>
					<li><a href="${ctx}/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list">科室管理</a></li>
					<li><a href="${ctx}/zhuzhijigou/list">组织机构</a></li>
					<li class="active"><a href="${ctx}/yonghu/sylist">用户管理</a></li>
					<li><a href="${ctx}/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<div class="row">
					<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">用户列表</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li><a href="${ctx}/yonghu/add">添加用户</a></li>
								<li><a onclick="return edit()">修改用户</a></li>
								<li><a onclick="return del()">删除用户</a></li>
								<li><span id="tempid" style="display: none"></span></li>
							</ul>
							<div class="nav navbar-nav navbar-right">
								<form action="${ctx }/yonghu/search" method="post">
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
					<input type="hidden" name="fdid" value="${yonghulist.get(0).fdid }" />
					<span>${addmsg}</span> <span>${editmsg}</span> <span>${deletemsg}</span>
				</div>
				<div class="row">
					<div class="col-sm-2 col-md-2 sidebar">
						<h4>用户列表</h4>
						<ul class="nav nav-sidebar">
							<c:forEach items="${fendianlist }" var="fdlist">
								<li id="fdid${fdlist.id }"><a
									href="${ctx }/yonghu/list?fdid=${fdlist.id }">${fdlist.fdmc }</a></li>
							</c:forEach>
						</ul>
					</div>
					<div class="col-sm-9 col-md-9">
						<h4>用户列表</h4>
						<span>共${yonghulist.size() }条记录</span>
					    <button class="btn btn-primary btn-sm" onclick="toexcel()">导出Excel</button>
						<div class="table-responsive">
							<table id="tablepot" class="table table-bordered table-condensed">
								<thead>
									<tr>
										<th>人员编号</th>
										<th>用户名</th>
										<th>姓名</th>
										<th>性别</th>
										<th>部门</th>
										<th>联系电话</th>
										<th>email</th>
										<th>入职日期</th>
										<th>备注信息</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${yonghulist }" var="yhlist">
										<tr onclick="setid(this,${yhlist.id })">
											<td>${yhlist.yhbh }</td>
											<td>${yhlist.yhdlm }</td>
											<td>${yhlist.yhxm }</td>
											<td>${yhlist.yhxb }</td>
											<td>${yhlist.csmc }</td>
											<td>${yhlist.yhsj }</td>
											<td>${yhlist.yhdzyx }</td>
											<td>${yhlist.yhrzrq }</td>
											<td>${yhlist.yhbz }</td>
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