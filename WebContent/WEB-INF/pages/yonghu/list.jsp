<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.table2excel.min.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script>
	function setid(element,id) {
		$("#tablepot .success").removeClass("success");
		$(element).addClass("success");
		$("#tempid").val(id);
	}
	function edit() {
		if($("#tablepot .success").length > 0){
			var id = $("#tempid").val();
			location = "${ctx}/yonghu/edit?id=" + id;
		}else{
			alert("请先选择用户");
		}
	}
	function del() {
		if($("#tablepot .success").length > 0){	
			if (confirm("您确定要删除 " + $("#tablepot .success td:eq(1)").text() + " 吗?")) {	
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
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">宏济堂药房管理</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="${ctx }/index">首页</a></li>
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
			<div class="col-md-2 sidebar">
				<h4>管理项目</h4>
				<ul class="nav nav-stacked">
					<li><a href="${ctx }/fendian/list">分店管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list">药品分类</a></li>
					<li><a href="${ctx }/yaopin/list">药品信息管理</a></li>
					<li><a href="${ctx }/gongyingshang/list">供应商管理</a></li>
					<li><a href="${ctx}/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list">科室管理</a></li>
					<li><a href="${ctx}/zuzhijigou/list">组织机构</a></li>
					<li class="active"><a href="${ctx}/yonghu/sylist">用户管理</a></li>
					<li><a href="${ctx}/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-md-10 maincon">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">用户列表</a>
						</div>
						<div id="navbar" class="collapse navbar-collapse">
							<ul class="nav navbar-nav">
								<li><a
									href="${ctx}/yonghu/add?fdid=${yonghulist.get(0).fdid }">添加用户</a></li>
								<li><a onclick="return edit()">修改用户</a></li>
								<li><a onclick="return del()">删除用户</a></li>
								<li class="dropdown"><a id="drop1" data-toggle="dropdown"
									class="dropdown-toggle" role="button" aria-haspopup="true"
									aria-expanded="false">导出Excel <span class="caret"></span>
								</a>
									<ul class="dropdown-menu" aria-labelledby="drop1">
										<li><a onclick="return toexcel()">本页记录</a></li>
										<li><a
											href="${ctx }/yonghu/downloadexcel?fdid=${yonghulist.get(0).fdid }">本店记录</a></li>
									</ul></li>
							</ul>
							<form class="navbar-form navbar-right"
								action="${ctx }/yonghu/search" method="post">
								<input type="hidden" name="fdid" value="${yonghulist.get(0).fdid }" />
								<input class="form-control" type="text" placeholder="请输入搜索关键字"
									name="searchword" />
								<button type="submit" class="btn btn-primary">搜索</button>
							</form>
						</div>
					</div>
				</nav>
				<div>
					<input type="hidden" id="tempid" />
					<span>${msgmsg}</span> <span>共${yonghulist.size() }条记录</span>
				</div>
				<div class="row">
					<div class="col-md-2">
						<h4>用户列表</h4>
						<ul class="nav nav-stacked pre-scrollable">
							<c:forEach items="${fendianlist }" var="fdlist">
								<li id="fdid${fdlist.id }"><a
									href="${ctx }/yonghu/list?fdid=${fdlist.id }">${fdlist.fdmc }</a></li>
							</c:forEach>
						</ul>
					</div>
					<div class="col-md-10">
						<h4>用户列表</h4>
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
									<th>状态</th>
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
										<td>
											<fmt:formatDate value='${yhlist.yhrzrq }' pattern='yyyy-MM-dd' />
										</td>
										<td>
											<c:choose>
												<c:when test="${yhlist.zt == 0}">启用</c:when>
												<c:otherwise>禁用</c:otherwise>
											</c:choose>
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