<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改供应商</title>
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
		if ("1" == $("#gyszt").val) {
			$("select option:eq(1)").attr("selected", true);
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
					<li><a href="${ctx }/fendian/list">分店管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list">药品分类</a></li>
					<li><a href="${ctx }/yaopin/list">药品信息管理</a></li>
					<li class="active"><a href="${ctx }/gongyingshang/list">供应商管理</a></li>
					<li><a href="${ctx}/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list">科室管理</a></li>
					<li><a href="${ctx}/zhuzhijigou/list">组织机构</a></li>
					<li><a href="${ctx}/yonghu/sylist">用户管理</a></li>
					<li><a href="${ctx}/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<div class="field">
					<label class="sub-header">修改供应商</label>
					<button class="btn btn-primary btn-sm" onclick="topdf()">打印</button>
					<input id="gyszt" type="hidden" value="${gys.zt }" />
					<span>${editmsg}</span> <span>${bhmsg}</span> <span>${mcmsg}</span>
				</div>
				<form id="formpot" method="post" class="form-x"
					action="${ctx }/gongyingshang/doedit">
					<input type="hidden" name="id" value="${gys.id }" />
					<div>
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#jbxx"
								aria-controls="jbxx" role="tab" data-toggle="tab">基本信息</a></li>
							<li role="presentation"><a href="#gspzl" aria-controls="gspzl"
								role="tab" data-toggle="tab">GSP资料</a></li>
						</ul>
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="jbxx">
								<div class="col-sm-8 col-md-10">
									<div class="form-group">
										<div class="label">
											<label>编号：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysbh"
												value="${gys.gysbh }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>名称：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysmc"
												value="${gys.gysmc }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>名称简拼：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysmcjp"
												value="${gys.gysmcjp }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>供应商电话：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gyslxdh"
												value="${gys.gyslxdh }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>联系人：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gyslxr"
												value="${gys.gyslxr }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>详细地址：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysxxdz"
												value="${gys.gysxxdz }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>电子邮件：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gyslyxdz"
												value="${gys.gyslyxdz}" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>邮政编码：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysyzbm"
												value="${gys.gysyzbm }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>业务员：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysywy"
												value="${gys.gysywy }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>业务员电话：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysywydh"
												value="${gys.gysywydh }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>业务员身份证：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysywysfz"
												value="${gys.gysywysfz }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>营业执照：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysyyzz"
												value="${gys.gysyyzz }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>执照期限：</label>
										</div>
										<div class="field">
											<input type="date" class="form-control" name="gysyyzzqx"
												value="<fmt:formatDate value='${gys.gysyyzzqx }' pattern='yyyy-MM-dd'/>" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>执照发证日期：</label>
										</div>
										<div class="field">
											<input type="date" class="form-control" name="gysyyzzfzrq"
												value="<fmt:formatDate value='${gys.gysyyzzfzrq }' pattern='yyyy-MM-dd'/>" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>法人代表：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysfrdb"
												value="${gys.gysfrdb }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>经营性质：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysjyxz"
												value="${gys.gysjyxz }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>注册资本：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gyszczb"
												value="${gys.gyszczb }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>经营方式：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysjyfs"
												value="${gys.gysjyfs }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>经营范围：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="gysjyfw"
												value="${gys.gysjyfw }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>状态：</label>
										</div>
										<div class="field">
											<select class="form-control" name="zt">
												<option value="0">启用</option>
												<option value="1">禁用</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div role="tabpanel" class="tab-pane" id="gspzl">
								<div class="form-group">
									<div class="label">
										<label>GSP证书号码：</label>
									</div>
									<div class="field">
										<input type="text" class="form-control" name="gysgspzj"
											value="${gys.gysgspzj }" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label>gsp证书有效期：</label>
									</div>
									<div class="field">
										<input type="date" class="form-control" name="gysgspzjyxq"
											value="<fmt:formatDate value='${gys.gysgspzjyxq }' pattern='yyyy-MM-dd'/>" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label>负责人：</label>
									</div>
									<div class="field">
										<input type="text" class="form-control" name="gysgspfzr"
											value="${gys.gysgspfzr }" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label>生产经营许可证编号：</label>
									</div>
									<div class="field">
										<input type="text" class="form-control" name="gysscjyxkz"
											value="${gys.gysscjyxkz }" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label>许可证名称：</label>
									</div>
									<div class="field">
										<input type="text" class="form-control" name="gysxkzmc"
											value="${gys.gysxkzmc }" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label>发证单位名称：</label>
									</div>
									<div class="field">
										<input type="text" class="form-control" name="gysxkzfzdw"
											value="${gys.gysxkzfzdw }" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label>许可证地址：</label>
									</div>
									<div class="field">
										<input type="text" class="form-control" name="gysxkzdz"
											value="${gys.gysxkzdz }" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label>许可证发证日期：</label>
									</div>
									<div class="field">
										<input type="date" class="form-control" name="gysxkzfzrq"
											value="<fmt:formatDate value='${gys.gysxkzfzrq }' pattern='yyyy-MM-dd'/>" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label>有效期至：</label>
									</div>
									<div class="field">
										<input type="date" class="form-control" name="gysxkzyxq"
											value="<fmt:formatDate value='${gys.gysxkzyxq }' pattern='yyyy-MM-dd'/>" />
									</div>
								</div>
								<div class="form-group">
									<div class="label">
										<label>备注信息：</label>
									</div>
									<div class="field">
										<textarea class="form-control" rows="3" name="gysbz">${gys.gysbz }</textarea>
									</div>
								</div>
							</div>
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