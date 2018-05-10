<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改货位</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.jqprint-0.3.js"></script>
<script src="${ctx}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// 设置状态下拉列表
		var sid = $("#ypzt").val();
		if (sid != '') {
			$("#zt option[value=" + sid + "]").attr("selected", true);
		}
	})
	
	// 打印PDF
	function topdf() {
		$("#formpot").jqprint({
			debug : false,
			importCSS : true,
			printContainer : true,
			operaSupport : true
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
				<ul class="nav nav-sidebar">
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
			<div class="col-md-9 maincon">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">修改货位</a>
						</div>
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav">
								<li><a onclick="return topdf()">打印</a></li>
							</ul>
						</div>
					</div>
				</nav>
				<div class="errormsg">
					<input id="hwzt" type="hidden" value="${huowei.zt }" />
					<span>${waymsg}</span> <span>${bhmsg }</span> <span>${mcmsg}</span>
				</div>
				<form id="formpot" class="form-horizontal"
					action="${ctx }/huowei/doedit" method="post">
					<div class="form-group">
						<input type="hidden" name="id" value="${huowei.id }" />
					</div>
					<div class="form-group">
						<label for="hwbh" class="col-md-2 control-label">编号</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="hwbh" name="hwbh"
								value="${huowei.hwbh }" data-validate="required:请输入编号"/>
						</div>
					</div>
					<div class="form-group">
						<label for="hwmc" class="col-md-2 control-label">名称</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="hwmc" name="hwmc"
								value="${huowei.hwmc }" data-validate="required:请输入名称"/>
						</div>
					</div>
					<div class="form-group">
						<label for="hwmcjp" class="col-md-2 control-label">名称简拼</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="hwmcjp" name="hwmcjp"
								value="${huowei.hwmcjp }" />
						</div>
					</div>
					<div class="form-group">
						<label for="zt" class="col-md-2 control-label">状态</label>
						<div class="col-md-5">
							<select class="form-control" id="zt" name="zt">
								<option value="0">启用</option>
								<option value="1">禁用</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="hwbz" class="col-md-2 control-label">备注信息</label>
						<div class="col-md-5">
							<textarea class="form-control" rows="4" id="hwbz" name="hwbz">${huowei.hwbz }</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-3">
							<button class="btn btn-primary" type="submit">提交</button>
							<button class="btn btn-primary" type="reset">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>