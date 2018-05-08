<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加处室</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.jqprint-0.3.js"></script>
<script src="${ctx}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var sid = $("#cszt").val();
		if (sid != '') {
			$("#zt option[value=" + sid + "]").attr("selected", true);
		}
	})
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
				<ul class="nav nav-stacked">
					<li><a href="${ctx }/fendian/list">分店管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list">药品分类</a></li>
					<li><a href="${ctx }/yaopin/list">药品信息管理</a></li>
					<li><a href="${ctx }/gongyingshang/list">供应商管理</a></li>
					<li><a href="${ctx}/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list">科室管理</a></li>
					<li class="active"><a href="${ctx}/zuzhijigou/list">组织机构</a></li>
					<li><a href="${ctx}/yonghu/sylist">用户管理</a></li>
					<li><a href="${ctx}/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-md-10 maincon">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">添加处室</a>
						</div>
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav">
								<li><a onclick="return topdf()">打印</a></li>
							</ul>
						</div>
					</div>
				</nav>
				<div>
					<input id="cszt" type="hidden" value="${chushi.zt }" />
					<span>${waymsg }</span> <span>${bhmsg}</span><span>${mcmsg}</span>
				</div>
				<form id="formpot" class="form-horizontal"
					action="${ctx }/zuzhijigou/doadd" method="post">
					<div class="form-group">
						<label for="csbh" class="col-md-2 control-label">编号</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="csbh" name="csbh"
								value="${chushi.csbh }" />
						</div>
					</div>
					<div class="form-group">
						<label for="csmc" class="col-md-2 control-label">名称</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="csmc" name="csmc"
								value="${chushi.csmc }" />
						</div>
					</div>
					<div class="form-group">
						<label for="csmcjp" class="col-md-2 control-label">名称简拼</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="csmcjp" name="csmcjp"
								value="${chushi.csmcjp }" />
						</div>
					</div>
					<div class="form-group">
						<label for="cslxdh" class="col-md-2 control-label">处室电话</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="cslxdh" name="cslxdh"
								value="${chushi.cslxdh }" />
						</div>
					</div>
					<div class="form-group">
						<label for="cszr" class="col-md-2 control-label">处室主任</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="cszr" name="cszr"
								value="${chushi.cszr }" />
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
						<label for="csbz" class="col-md-2 control-label">备注信息</label>
						<div class="col-md-5">
							<textarea class="form-control" rows="4" name="ksbz">${chushi.csbz }</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-3">
							<button class="btn btn-primary" type="submit">提交</button>
							<button class="btn btn-primary" type="button"
								onclick="window.history.back(-1)">取消</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>