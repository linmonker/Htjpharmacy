<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓库搜索结果列表</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.table2excel.min.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script>
	// 记录所选仓库
	function setid(element,id) {
		$("#tablepot .success").removeClass("success");
		$(element).addClass("success");
		$("#tempid").val(id);
	}
	
	// 查看修改
	function edit() {
		if($("#tablepot .success").length > 0){
			var id = $("#tempid").val();
			location = "${ctx}/cangku/edit?id=" + id;
		}else{
			alert("请先选择仓库");
		}
	}
	
	// 删除仓库
	function del() {
		if($("#tablepot .success").length > 0){	
			if (confirm("您确定要删除 " + $("#tablepot .success td:eq(1)").text() + " 吗?")) {	
				var id = $("#tempid").val();
				location = "${ctx}/cangku/delete?id=" + id;
			}
		}else{
			alert("请先选择仓库");
		}
	}
	
	// 进入货位管理
	function huowei() {
		if($("#tablepot .success").length > 0){	
			var id = $("#tempid").val();
			location = "${ctx}/huowei/list?ckid=" + id;
		}else{
			alert("请先选择仓库");
		}
	}
	
	// 本页表格导出Excel
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
	
	// 上下页
	function walkpage(conpage) {
		if(conpage>0||conpage<=$("#zonpage").text()){
			var fdid = $("#tempfdid").val();
			var searchword = $("#searchword2").val()
			location="${ctx }/cangku/search?conpage="+conpage
					+"&&searchword="+searchword+"&&fdid="+fdid;
		}
	}
	
	// 跳页
	function turnpage() {
		var conpage = Number($("#conpage").val());
		if(Number.isInteger(conpage) && conpage>0 && conpage<=$("#zonpage").text()){
			return true;
		}else{
			return false;
		}
	}
	$(document).ready(function(){
		// 设置分店列表所选分店active
		var fdid = $("#tempfdid").val();
		 	$("#fdid" + fdid).addClass("active");
		});
</script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">宏济堂中医馆药房管理</a>
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
					<li><a href="${ctx }/gongyingshang/list">供应商管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list">药品分类管理</a></li>
					<li><a href="${ctx }/yaopin/list">药品管理</a></li>
					<li class="active"><a href="${ctx }/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx }/keshi/list">科室管理</a></li>
					<li><a href="${ctx }/chushi/list">处室管理</a></li>
					<li><a href="${ctx }/yonghu/sylist">用户管理</a></li>
					<li><a href="${ctx }/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-md-10 maincon">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">仓库列表</a>
						</div>
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav">
								<c:if
									test="${cangkulist.get(0).fdid == sessionScope.loginer.fdid }">
									<li><a onclick="return edit()">修改仓库</a></li>
									<li><a onclick="return del()">删除仓库</a></li>
									<li><a onclick="return huowei()">货位管理</a></li>
								</c:if>
								<li class="dropdown"><a id="drop1" data-toggle="dropdown"
									class="dropdown-toggle" role="button" aria-haspopup="true"
									aria-expanded="false">导出Excel <span class="caret"></span>
								</a>
									<ul class="dropdown-menu" aria-labelledby="drop1">
										<li><a onclick="return toexcel()">本页记录</a></li>
									</ul></li>
							</ul>
							<form class="navbar-form navbar-right"
								action="${ctx }/cangku/search" method="post">
								<input type="hidden" id="tempfdid" name="fdid"
									value="${cangkulist.get(0).fdid }" />
								<input class="form-control" type="text" placeholder="请输入搜索关键字"
									name="searchword" value="${searchword }" />
								<button type="submit" class="btn btn-primary">搜索</button>
							</form>
						</div>
					</div>
				</nav>
				<div>
					<input type="hidden" id="tempid" />
					<span>${waymsg}</span>
				</div>
				<div class="row">
					<div class="col-md-2">
						<h4>分店列表</h4>
						<ul class="nav nav-stacked pre-scrollable">
							<c:forEach items="${fendianlist }" var="fdlist">
								<li id="fdid${fdlist.id }"><a
									href="${ctx }/cangku/list?fdid=${fdlist.id }">${fdlist.fdmc }</a></li>
							</c:forEach>
						</ul>
					</div>
					<div class="col-md-10">
						<h4>仓库列表</h4>
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
										<td>${cklist.ckmcjp }</td>
										<td>${cklist.ckbz }</td>
										<td>
											<c:choose>
												<c:when test="${cklist.zt == 0}">启用</c:when>
												<c:otherwise>禁用</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<form class="form-inline" action="${ctx }/cangku/search"
							onsubmit="return turnpage()">
							<div class="form-group">
								<p class="form-control-static">共${count }条记录</p>
							</div>
							<c:if test="${count >0 }">
								<button type="button" class="btn btn-default"
									onclick="walkpage(${conpage-1 })">上一页</button>
								<div class="form-group">
									<input type="hidden" name="fdid"
										value="${cangkulist.get(0).fdid }" />
									<input type="hidden" id="searchword2" name="searchword"
										value="${searchword }">
									<input type="text" class="form-control" style="width: 60px"
										id="conpage" name="conpage" value="${conpage }">
									<p class="form-control-static">
										/<span id="zonpage"><fmt:formatNumber
												value="${count/20 + 0.5}" pattern="#,###,###,###" /></span> 页
									</p>
								</div>
								<button type="submit" class="btn btn-default">跳转</button>
								<button type="button" class="btn btn-default"
									onclick="walkpage(${conpage+1 })">下一页</button>
							</c:if>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>