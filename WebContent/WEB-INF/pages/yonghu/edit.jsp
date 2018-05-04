<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/static/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.jqprint-0.3.js"></script>
<script src="${ctx}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var sid = $("#yhjs").val;
		if (sid != null) {
			$("#yhjs option[value=sid]").attr("selected", true);
		}
		sid = $("#yhbm").val;
		if (sid != null) {
			$("#yhbn option[value=sid]").attr("selected", true);
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
		<div class="row">
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
				<div class="field">
					<label class="sub-header">修改用户</label>
					<button class="btn btn-primary btn-sm" onclick="topdf()">打印</button>
					<input id="yhjs" type="hidden" value="${yonghu.yhjsid }" />
					<input id="yhbm" type="hidden" value="${yonghu.yhbmid }" />
					<span>${msgmsg}</span><span>${bhmsg}</span><span>${mcmsg}</span><span>${mmmsg}</span>
				</div>
				<form id="formpot" method="post" class="form-x"
					action="${ctx }/yonghu/doedit">
					<input type="hidden" name="id" value="${yonghu.id }" />
					<input type="hidden" name="fdid" value="${yonghu.fdid }" />
					<div class="form-group">
						<div class="label">
							<label>用户编号：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="yhbh"
								value="${yonghu.yhbh }" data-validate="required:请输入用户编号" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>用户名：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="yhdlm"
								value="${yonghu.yhdlm }" data-validate="required:请输入用户名" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>密码：</label>
						</div>
						<div class="field">
							<input id="yhmm" type="text" class="form-control" name="yhmm"
							     placeholder="修改密码时输入" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>确认密码：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="confirmyhmm"
								 placeholder="修改密码时输入" data-validate="equalTo:'#yhmm'" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>姓名：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="yhxm"
								value="${yonghu.yhxm }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>姓名简拼：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="yhxmjp"
								value="${yonghu.yhxmjp }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>性别：</label>
						</div>
						<div class="field">
							<label class="radio-inline">
								<input type="radio" name="yhxb" id="yhxb1"
									<c:if test="${yonghu.yhxb == '1' }">checked</c:if> value="1">男
							</label>
							<label class="radio-inline">
								<input type="radio" name="yhxb" id="yhxb2"
									<c:if test="${yonghu.yhxb == '2' }">checked</c:if> value="2">女
							</label>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>身份证号：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="yhsfzh"
								value="${yonghu.yhsfzh }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>联系电话：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="yhsj"
								value="${yonghu.yhsj }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>email：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="yhdzyx"
								value="${yonghu.yhdzyx }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>地址：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="yhdz"
								value="${yonghu.yhdz }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>邮编：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="yhyb"
								value="${yonghu.yhyb }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>出生日期：</label>
						</div>
						<div class="field">
							<input type="date" class="form-control" name="yhcsrq"
								value="<fmt:formatDate value='${yonghu.yhcsrq }' pattern='yyyy-MM-dd'/>" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>入职日期：</label>
						</div>
						<div class="field">
							<input type="date" class="form-control" name="yhrzrq"
								value="<fmt:formatDate value='${yonghu.yhrzrq }' pattern='yyyy-MM-dd'/>" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>角色：</label>
						</div>
						<div class="field">
							<select id="yhjs" class="form-control" name="ypjsid">
								<c:forEach items="${rolelist }" var="rlist">
									<option value="${rlist.role_id }">${rlist.role_name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>部门：</label>
						</div>
						<div class="field">
							<select id="yhbm" class="form-control" name="ypbmid">
								<c:forEach items="${chushilist }" var="clist">
									<option value="${clist.id }">${clist.csmc }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>备注信息：</label>
						</div>
						<div class="field">
							<textarea class="form-control" rows="3" name="ckbz">${yonghu.yhbz }</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="field">
							<button class="button bg-main" type="submit">提交</button>
							<button class="button bg-main" type="reset">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>