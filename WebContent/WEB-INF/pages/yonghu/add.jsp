<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.jqprint-0.3.js"></script>
<script src="${ctx}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var sid = $("#yhzt").val();
		if (sid != '') {
			$("#zt option[value=" + sid + "]").attr("selected", true);
		}
		sid = $("#yhjs").val;
		if (sid != '') {
			$("#yhjsid option[value=" + sid + "]").attr("selected", true);
		}
		sid = $("#yhbm").val;
		if (sid != '') {
			$("#yhbmid option[value=" + sid + "]").attr("selected", true);
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
					<li><a href="${ctx}/zuzhijigou/list">组织机构</a></li>
					<li class="active"><a href="${ctx}/yonghu/sylist">用户管理</a></li>
					<li><a href="${ctx}/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-md-10 maincon">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">添加用户</a>
						</div>
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav">
								<li><a onclick="return topdf()">打印</a></li>
							</ul>
						</div>
					</div>
				</nav>
				<div>
					<input id="yhzt" type="hidden" value="${yonghu.zt }" />
					<input id="yhjs" type="hidden" value="${yonghu.yhjsid }" />
					<input id="yhbm" type="hidden" value="${yonghu.yhbmid }" />
					<span>${waymsg}</span> <span>${bhmsg}</span> <span>${mcmsg}</span>
				</div>
				<form id="formpot" class="form-horizontal"
					action="${ctx }/yonghu/doadd" method="post">
					<div class="form-group">
						<input type="hidden" name="fdid" value="${yonghu.fdid }" />
					</div>
					<div class="form-group">
						<label for="yhbh" class="col-md-2 control-label">编号</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="yhbh" name="yhbh"
								value="${yonghu.yhbh }" />
						</div>
					</div>
					<div class="form-group">
						<label for="yhdlm" class="col-md-2 control-label">用户名</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="yhdlm" name="yhdlm"
								value="${yonghu.yhdlm }" />
						</div>
					</div>
					<div class="form-group">
						<label for="yhmm" class="col-md-2 control-label">密码</label>
						<div class="col-md-5">
							<input type="password" class="form-control" id="yhmm" name="yhmm" />
						</div>
					</div>
					<div class="form-group">
						<label for="confirmyhmm" class="col-md-2 control-label">确认密码</label>
						<div class="col-md-5">
							<input type="password" class="form-control" id="confirmyhmm"
								name="confirmyhmm" data-validate="equalTo:'#yhmm'" />
						</div>
					</div>
					<div class="form-group">
						<label for="yhxm" class="col-md-2 control-label">姓名</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="yhxm" name="yhxm"
								value="${yonghu.yhxm }" />
						</div>
					</div>
					<div class="form-group">
						<label for="yhxmjp" class="col-md-2 control-label">姓名简拼</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="yhxmjp" name="yhxmjp"
								value="${yonghu.yhxmjp }" />
						</div>
					</div>
					<div class="form-group">
						<label for="yhxmjp" class="col-md-2 control-label">性别</label>
						<div class="col-md-5">
							<label class="radio-inline">
								<input type="radio" name="yhxb" id="yhxb1" checked value="1">
								男
							</label>
							<label class="radio-inline">
								<input type="radio" name="yhxb" id="yhxb2"
									<c:if test="${yonghu.yhxb == '2' }">checked</c:if> value="2">
								女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="yhsfzh" class="col-md-2 control-label">身份证号</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="yhsfzh" name="yhsfzh"
								value="${yonghu.yhsfzh }" />
						</div>
					</div>
					<div class="form-group">
						<label for="yhsj" class="col-md-2 control-label">联系电话</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="yhsj" name="yhsj"
								value="${yonghu.yhsj }" />
						</div>
					</div>
					<div class="form-group">
						<label for="yhdzyx" class="col-md-2 control-label">电子邮箱</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="yhdzyx" name="yhdzyx"
								value="${yonghu.yhdzyx }" />
						</div>
					</div>
					<div class="form-group">
						<label for="yhdz" class="col-md-2 control-label">地址</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="yhdz" name="yhdz"
								value="${yonghu.yhdz }" />
						</div>
					</div>
					<div class="form-group">
						<label for="yhyb" class="col-md-2 control-label">邮编</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="yhyb" name="yhyb"
								value="${yonghu.yhyb }" />
						</div>
					</div>
					<div class="form-group">
						<label for="yhcsrq" class="col-md-2 control-label">出生日期</label>
						<div class="col-md-5">
							<input type="date" class="form-control" id="yhcsrq" name="yhcsrq"
								value="<fmt:formatDate value='${yonghu.yhcsrq }' pattern='yyyy-MM-dd'/>" />
						</div>
					</div>
					<div class="form-group">
						<label for="yhrzrq" class="col-md-2 control-label">入职日期</label>
						<div class="col-md-5">
							<input type="date" class="form-control" id="yhrzrq" name="yhrzrq"
								value="<fmt:formatDate value='${yonghu.yhrzrq }' pattern='yyyy-MM-dd'/>" />
						</div>
					</div>
					<div class="form-group">
						<label for="ypjsid" class="col-md-2 control-label">角色</label>
						<div class="col-md-5">
							<select class="form-control" id="ypjsid" name="ypjsid">
								<c:forEach items="${rolelist }" var="rlist">
									<option value="${rlist.role_id }">${rlist.role_name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="ypbmid" class="col-md-2 control-label">部门</label>
						<div class="col-md-5">
							<select class="form-control" id="ypbmid" name="ypbmid">
								<c:forEach items="${chushilist }" var="clist">
									<option value="${clist.id }">${clist.csmc }</option>
								</c:forEach>
							</select>
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
						<label for="yhbz" class="col-md-2 control-label">备注信息</label>
						<div class="col-md-5">
							<textarea class="form-control" rows="4" id="yhbz" name="yhbz">${yonghu.yhbz }</textarea>
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