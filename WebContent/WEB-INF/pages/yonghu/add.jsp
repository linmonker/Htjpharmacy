<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/static/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">宏济堂药房管理</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${ctx}/index">首页</a></li>
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
		<div class="row">
			<div class="col-sm-2 col-md-2 sidebar">
				<h4>管理项目</h4>
				<ul class="nav nav-sidebar">
					<li><a href="${ctx}/fendian/list">分店管理</a></li>
					<li><a href="${ctx}/yaopinfenlei/list">药品分类</a></li>
					<li><a href="${ctx}/yaopin/list">药品信息管理</a></li>
					<li><a href="${ctx}/gongyingshang/list">供应商管理</a></li>
					<li><a href="${ctx}/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list">科室管理</a></li>
					<li><a href="${ctx}/zhuzhijigou/list">组织机构</a></li>
					<li class="active"><a href="${ctx}/yonghu/sylist">用户管理</a></li>
					<li><a href="${ctx}/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<div class="field">
					<label class="sub-header">添加用户</label>
					<span>${addmsg}</span> <span>${bhmsg}</span> <span>${mcmsg}</span>
				</div>
				<form method="post" class="form-x" action="${ctx}/yonghu/doadd">
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
							<select class="form-control" name="yhxb">
								<option value="男">男</option>
								<option value="女">女</option>
							</select>
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
							<input type="text" class="form-control" name="yhdzyj"
								value="${yonghu.yhdzyj }" />
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
								value="${yonghu.yhcsrq }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>入职日期：</label>
						</div>
						<div class="field">
							<input type="date" class="form-control" name="yhrzrq"
								value="${yonghu.yhrzrq }" />
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>角色：</label>
						</div>
						<div class="field">
							<select id="ypgys" class="form-control" name="ypjsid">
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
							<select id="ypgys" class="form-control" name="ypbmid">
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
							<a class="button bg-red" href="${ctx}/yonghu/list"
								style="margin-left: 10px;"> 取消</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>