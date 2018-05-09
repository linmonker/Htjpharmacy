<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>货位列表</title>
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
			location = "${ctx}/huowei/edit?id=" + id;
		}else{
			alert("请先选择货位");
		}
	}
	function del() {
		if($("#tablepot .success").length > 0){	
			if (confirm("您确定要删除 " + $("#tablepot .success td:eq(1)").text() + " 吗?")) {	
				var id = $("#tempid").val();
				location = "${ctx}/huowei/delete?id=" + id;
			}
		}else{
			alert("请先选择货位");
		}
	}
	function walkpage(conpage) {
		if(conpage>0||conpage<=$("#zonpage").text()){
			var ckid = $("#ckid1").val();
			location="${ctx }/cangku/list?conpage="+conpage+"&&ckid="+ckid;
		}
	}
	function turnpage() {
		var conpage = Number($("#conpage").val());
		if(Number.isInteger(conpage) && conpage>0 && conpage<=$("#zonpage").text()){
			return true;
		}else{
			return false;
		}
	}
	function toexcel() {
	    $("#tablepot").table2excel({
		    exclude: ".noExl",
		    name: "Excel Document Name",
		    filename: "货位列表",
		    exclude_img: true,
		    exclude_links: true,
		    exclude_inputs: true
		});
	}
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
					<li class="active"><a href="${ctx}/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list">科室管理</a></li>
					<li><a href="${ctx}/zuzhijigou/list">组织机构</a></li>
					<li><a href="${ctx}/yonghu/sylist">用户管理</a></li>
					<li><a href="${ctx}/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-md-10 maincon">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">货位列表</a>
						</div>
						<div id="navbar" class="collapse navbar-collapse">
							<ul class="nav navbar-nav">
								<li><a
									href="${ctx}/huowei/add?ckid=${huoweilist.get(0).ckid }">添加货位</a></li>
								<li><a onclick="return edit()">修改货位</a></li>
								<li><a onclick="return del()">删除货位</a></li>
								<li class="dropdown"><a id="drop1" data-toggle="dropdown"
									class="dropdown-toggle" role="button" aria-haspopup="true"
									aria-expanded="false">导出Excel <span class="caret"></span>
								</a>
									<ul class="dropdown-menu" aria-labelledby="drop1">
										<li><a onclick="return toexcel()">本页记录</a></li>
										<li><a
											href="${ctx }/huowei/downloadexcel?ckid=${huoweilist.get(0).ckid }">本仓库记录</a></li>
									</ul></li>
							</ul>
							<form class="navbar-form navbar-right"
								action="${ctx }/huowei/search" method="post">
								<input type="hidden" id="ckid1" name="ckid"
									value="${huoweilist.get(0).ckid }" />
								<input class="form-control" type="text" placeholder="请输入搜索关键字"
									name="searchword" />
								<button type="submit" class="btn btn-primary">搜索</button>
							</form>
						</div>
					</div>
				</nav>
				<div>
					<input type="hidden" id="tempid" />
					<span>${waymsg}</span>
				</div>
				<table id="tablepot" class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>货位编号</th>
							<th>货位名称</th>
							<th>货位名称简拼</th>
							<th>备注信息</th>
							<th>状态</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${huoweilist }" var="list">
							<tr onclick="setid(this,${list.id })">
								<td>${list.hwbh }</td>
								<td>${list.hwmc }</td>
								<td>${list.hwmcjp }</td>
								<td>${list.hwbz }</td>
								<td>
									<c:choose>
										<c:when test="${list.zt == 0}">启用</c:when>
										<c:otherwise>禁用</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form class="form-inline" action="${ctx }/huowei/list"
					onsubmit="return turnpage()">
					<div class="form-group">
						<p class="form-control-static">共${count }条记录</p>
					</div>
					<c:if test="${count >0 }">
						<button type="button" class="btn btn-default"
							onclick="walkpage(${conpage-1 })">上一页</button>
						<div class="form-group">
							<input type="hidden" name="ckid" value="${huoweilist.get(0).ckid }" />
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
</body>
</html>