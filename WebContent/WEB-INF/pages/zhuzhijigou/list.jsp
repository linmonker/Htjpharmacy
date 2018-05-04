<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处室列表</title>
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
			location = "${ctx}/zhuzhijigou/edit?id=" + id;
		}else{
			alert("请先选择处室");
		}
	}
	function del() {
		if($("tr.active").length > 0){	
			if (confirm("您确定要删除 " + $("tr.active td:eq(1)").text() + " 吗?")) {	
				var id = $("#tempid").val();
				location = "${ctx}/zhuzhijigou/delete?id=" + id;
			}
		}else{
			alert("请先选择处室");
		}
	}
	function toexcel() {
	    $("#tablepot").table2excel({
		    exclude: ".noExl",
		    name: "Excel Document Name",
		    filename: "处室列表",
		    exclude_img: true,
		    exclude_links: true,
		    exclude_inputs: true
		});
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
		<div id="navbar" class="row navbar-collapse collapse">
			<div class="col-sm-2 col-md-2 sidebar">
				<h4>管理项目</h4>
				<ul class="nav nav-sidebar">
					<li class="active"><a href="${ctx }/fendian/list">分店管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list">药品分类</a></li>
					<li><a href="${ctx }/yaopin/list">药品信息管理</a></li>
					<li><a href="${ctx }/gongyingshang/list">供应商管理</a></li>
					<li><a href="${ctx}/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list">科室管理</a></li>
					<li class="active"><a href="${ctx}/zhuzhijigou/list">组织机构</a></li>
					<li><a href="${ctx}/yonghu/sylist">用户管理</a></li>
					<li><a href="${ctx}/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<div class="row">
					<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">处室列表</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">
								<li><a href="${ctx}/zhuzhijigou/add">添加处室</a></li>
								<li><a onclick="return edit()">修改处室</a></li>
								<li><a onclick="return del()">删除处室</a></li>
								<li class="dropdown"><a id="drop2" data-toggle="dropdown" class="dropdown-toggle"
									role="button" aria-haspopup="true" aria-expanded="false">导出Excel <span class="caret"></span>
								</a>
									<ul class="dropdown-menu" aria-labelledby="drop2">
										<li><a onclick="return toexcel()">本页记录</a></li>
										<li><a href="${ctx }/zhuzhijigou/downloadexcel">全部记录</a></li>
									</ul></li>
							</ul>
							<div class="nav navbar-nav navbar-right">
								<form action="${ctx }/zhuzhijigou/search" method="post">
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
					<span>${waymsg }</span> <span>${editmsg }</span> <span>${deletemsg }</span>
				</div>
				<div class="row">
				    <span>共${chushilist.size() }条记录</span>
					<div class="table-responsive">
						<table id="tablepot" class="table table-bordered table-condensed">
							<thead>
								<tr>
									<th>处室编号</th>
									<th>处室名称</th>
									<th>处室电话</th>
									<th>处室主任</th>
									<th>备注信息</th>
									<th>状态</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${chushilist }" var="list">
									<tr onclick="setid(this,${list.id })">
										<td>${list.csbh }</td>
										<td>${list.csmc }</td>
										<td>${list.cslxdh }</td>
										<td>${list.cszr }</td>
										<td>${list.csbz }</td>
										<td><c:choose>
												<c:when test="${list.zt == 0}">启用</c:when>
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
</body>
</html>