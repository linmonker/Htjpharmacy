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
				<li><a href="${ctx }index.action">首页</a></li>
				<li><a href="#">关于</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">one</a></li>
				<li><a href="#">two</a></li>
				<li><a href="#">three</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 col-md-2 sidebar">
				<h4>管理项目</h4>
				<ul class="nav nav-sidebar">
					<li><a href="${ctx }/fendian/list.action">分店管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list.action">药品分类</a></li>
					<li><a href="${ctx }/yaopin/list.action">药品信息管理</a></li>
					<li class="active"><a href="${ctx }/gongyingshang/list.action">供应商管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<h4 class="sub-header">修改供应商</h4>
				<span style="margin-left: 50px; color: red; font-size: 20px">${bhdata}</span>
				<span style="margin-left: 50px; color: red; font-size: 20px">${mcdata}</span>
				<form method="post" class="form-x"
					action="${ctx }/gongyingshang/doedit">
					<div>
						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#jbxx"
								aria-controls="jbxx" role="tab" data-toggle="tab">基本信息</a></li>
							<li role="presentation"><a href="#gspzl"
								aria-controls="gspzl" role="tab" data-toggle="tab">GSP资料</a></li>
						</ul>

						<!-- Tab panes -->
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="jbxx">
								<div class="row">
									<div class="col-sm-6 col-md-6">
										<div class="form-group">
											<div class="label">
												<label>编号：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysbh"
													value="${gys.gysbh }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>名称：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysmc"
													value="${gys.gysmc }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>联系人：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gyslxr"
													value="${gys.gyslxr }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>电话：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gyslxr"
													value="${gys.gyslxdh }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>详细地址：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysxxdz"
													value="${gys.gysxxdz }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>电子邮件：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gyslyxdz"
													value="${gys.gyslyxdz}" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>邮政编码：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysyzbm"
													value="${gys.gysyzbm }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>业务员：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysywy"
													value="${gys.gysywy }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>业务员电话：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysywydh"
													value="${gys.gysywydh }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>营业执照：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysyyzz"
													value="${gys.gysyyzz }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>执照期限：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysyyzzqx"
													value="${gys.gysyyzzqx }" />
											</div>
										</div>

										<div class="form-group">
											<div class="label">
												<label>法人代表：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysfrdb"
													value="${gys.gysfrdb }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>经营性质：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysjyxz"
													value="${gys.gysjyxz }" />
											</div>
										</div>
									</div>
									<div class="col-sm-6 col-md-6">
										<div class="form-group">
											<div class="label">
												<label>注册资金：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gyszczb"
													value="${gys.gyszczb }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>经营方式：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysjyfs"
													value="${gys.gysjyfs }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>经营范围：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysjyfw"
													value="${gys.gysjyfw }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>发证日期：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysyyzzfzrq"
													value="${gys.gysyyzzfzrq }" />
											</div>
										</div>
									</div>
								</div>
							</div>
							<div role="tabpanel" class="tab-pane" id="gspzl">
								<div class="row">
									<div class="col-sm-6 col-md-6">
										<div class="form-group">
											<div class="label">
												<label>GSP证书编号：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gygspzj"
													value="${gys.gygspzj }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>gsp证书有效期：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysgspzjyxq"
													value="${gys.gysgspzjyxq }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>负责人：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysgspfzr"
													value="${gys.gysgspfzr }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>许可证名称：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysxkzmc"
													value="${gys.gysxkzmc }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>发证单位名称：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysxkzfzdw"
													value="${gys.gysxkzfzdw }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>许可证地址：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysxkzdz"
													value="${gys.gysxkzdz }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>许可证编号：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysxkzbh"
													value="${gys.gysxkzbh }" />
											</div>
										</div>

										<div class="form-group">
											<div class="label">
												<label>许可证发证日期：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysxkzfzrq"
													value="${gys.gysxkzfzrq }" />
											</div>
										</div>
										<div class="form-group">
											<div class="label">
												<label>有效期至：</label>
											</div>
											<div class="field">
												<input type="text" class="input w50" name="gysxkzyxq"
													value="${gys.gysxkzyxq }" />
											</div>
										</div>

									</div>
								</div>

							</div>
						</div>

					</div>
					<div class="form-group">
						<div class="label">
							<label></label>
						</div>
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