<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加分店</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.jqprint-0.3.js"></script>
<script src="${ctx}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script>
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
			<div class="collapse navbar-collapse">
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
				<ul class="nav navbar-nav">
					<li class="active"><a href="${ctx }/fendian/list">分店管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list">药品分类</a></li>
					<li><a href="${ctx }/yaopin/list">药品信息管理</a></li>
					<li><a href="${ctx }/gongyingshang/list">供应商管理</a></li>
					<li><a href="${ctx}/cangku/sylist">仓库管理</a></li>
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
							<a class="navbar-brand">添加分店</a>
						</div>
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav">
								<li><a onclick="return topdf()">打印</a></li>
							</ul>
						</div>
					</div>
				</nav>
				<div class="errormsg">
					<span>${waymsg}</span> <span>${bhmsg}</span> <span>${mcmsg}</span>
				</div>
				<form id="formpot" class="form-horizontal"
					action="${ctx }/fendian/doadd" method="post">
					<div class="form-group">
						<label for="fdbh" class="col-md-2 control-label">编号</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="fdbh" name="fdbh"
								value="${fendian.fdbh }" data-validate="required:请输入编号" />
						</div>
					</div>
					<div class="form-group">
						<label for="fdmc" class="col-md-2 control-label">名称</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="fdmc" name="fdmc"
								value="${fendian.fdmc }" data-validate="required:请输入名称" />
						</div>
					</div>
					<div class="form-group">
						<label for="fdlxdh" class="col-md-2 control-label">联系电话</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="fdlxdh" name="fdlxdh"
								value="${fendian.fdlxdh }" />
						</div>
					</div>
					<div class="form-group">
						<label for="fddzxm" class="col-md-2 control-label">店长姓名</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="fddzxm" name="fddzxm"
								value="${fendian.fddzxm }" />
						</div>
					</div>
					<div class="form-group">
						<label for="fddz" class="col-md-2 control-label">分店地址</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="fddz" name="fddz"
								value="${fendian.fddz }" />
						</div>
					</div>
					<div class="form-group">
						<label for="fdbz" class="col-md-2 control-label">备注信息</label>
						<div class="col-md-5">
							<textarea class="form-control" rows="4" id="fdbz" name="fdbz">${fendian.fdbz }</textarea>
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