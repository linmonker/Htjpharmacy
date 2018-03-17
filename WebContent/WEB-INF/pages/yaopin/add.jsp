<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加药品</title>
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
				<li><a href="index.action">首页</a></li>
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
					<li class="active"><a href="${ctx }/yaopin/list.action">药品信息管理</a></li>
					<li><a href="${ctx }/gongyingshang/list.action">供应商管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<h4 class="sub-header">添加药品</h4>
				<span style="margin-left: 50px; color: red; font-size: 20px">${bhdata}</span>
				<span style="margin-left: 50px; color: red; font-size: 20px">${mcdata}</span>
				<form method="post" class="form-x" action="${ctx }/yaopin/doadd">
					<div>
						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#jbxx"
								aria-controls="jbxx" role="tab" data-toggle="tab">基本信息</a></li>
							<li role="presentation"><a href="#jgxx" aria-controls="jgxx"
								role="tab" data-toggle="tab">价格信息</a></li>
						</ul>

						<!-- Tab panes -->
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="jbxx">
								<div class="container-fluid">
									<div class="row">
										<div class="col-sm-6 col-md-6">
											<div class="form-group">
												<div class="label">
													<label>编号：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypbh"
														value="${yaopin.ypbh }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>商品名：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypspm"
														value="${yaopin.ypspm }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>通用名：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="yptym"
														value="${yaopin.yptym }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>供应商：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypgys"
														value="${yaopin.ypgys }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>详细地址：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="gysxxdz"
														value="${yaopin.gysxxdz }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>规格：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypgg"
														value="${yaopin.ypgg}" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>包装规格：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypbzgg"
														value="${yaopin.ypbzgg }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>产地：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypcd"
														value="${yaopin.ypcd }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>单次限购：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypzddcgml"
														value="${yaopin.ypzddcgml }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>属性：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypsx"
														value="${yaopin.ypsx }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>执照期限：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="gysyyzzqx"
														value="${yaopin.gysyyzzqx }" />
												</div>
											</div>

											<div class="form-group">
												<div class="label">
													<label>用药提醒开关：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypyytx"
														value="${yaopin.ypyytx }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>用药提醒内容：</label>
												</div>
												<div class="field">
													<label class="radio-inline"> <input type="radio"
														name="ypyytxnr" id="ypyytxnr1"
														<c:if test="${yaopin.ypyytxnr == 0 }">checked</c:if>
														value="0"> 开
													</label> <label class="radio-inline"> <input type="radio"
														name="ypyytxnr" id="ypyytxnr2"
														<c:if test="${yaopin.ypyytxnr == 1 }">checked</c:if>
														value="1"> 关
													</label>
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>生产单位：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypdw"
														value="${yaopin.ypdw }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>批准文号：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="yppzwh"
														value="${yaopin.yppzwh }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>注册商标：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypzcsb"
														value="${yaopin.ypzcsb }" />
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6">
											<div class="form-group">
												<div class="label">
													<label>剂型：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypjx"
														value="${yaopin.ypjx }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>计量单位：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypdw"
														value="${yaopin.ypdw }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>验收标准：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypysbz"
														value="${yaopin.ypysbz }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>储藏条件：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypcctj"
														value="${yaopin.ypcctj }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>有效期：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypyxq"
														value="${yaopin.ypyxq }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>库存上限：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name="ypkcsx"
														value="${yaopin.ypkcsx }" />
												</div>
											</div>
											<div class="form-group">
												<div class="label">
													<label>库存下限：</label>
												</div>
												<div class="field">
													<input type="text" class="input w50" name=ypkcxx
														value="${yaopin.ypkcxx }" />
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div role="tabpanel" class="tab-pane" id="jgxx">
								<div class="container-fluid">


									<div class="form-group">
										<div class="label">
											<label>进货价：</label>
										</div>
										<div class="field">
											<input type="text" class="input w50" name="ypjhj"
												value="${yaopin.ypjhj }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>批发价：</label>
										</div>
										<div class="field">
											<input type="text" class="input w50" name="ypbfj"
												value="${yaopin.ypbfj }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>零售价：</label>
										</div>
										<div class="field">
											<input type="text" class="input w50" name="yplsj"
												value="${yaopin.yplsj }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>会员价：</label>
										</div>
										<div class="field">
											<input type="text" class="input w50" name="yphyj"
												value="${yaopin.yphyj }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>是否允许打折：</label>
										</div>
										<div class="field">
											<label class="radio-inline"> <input type="radio"
												name="ypsfdz" id="ypsfdz1"
												<c:if test="${yaopin.ypsfdz == 0 }">checked</c:if> value="0">
												是
											</label> <label class="radio-inline"> <input type="radio"
												name="ypsfdz" id="ypsfdz2"
												<c:if test="${yaopin.ypsfdz == 1 }">checked</c:if> value="1">
												否
											</label>
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>是否参与积分：</label>
										</div>
										<div class="field">
											<label class="radio-inline"> <input type="radio"
												name="ypsfcyhyjf" id="ypsfcyhyjf1"
												<c:if test="${yaopin.ypsfcyhyjf == 0 }">checked</c:if>
												value="0"> 开
											</label> <label class="radio-inline"> <input type="radio"
												name="ypsfcyhyjf" id="ypsfcyhyjf2"
												<c:if test="${yaopin.ypsfcyhyjf == 1 }">checked</c:if>
												value="1"> 关
											</label>
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
							<a class="button bg-red" href="${ctx }/yaopin/list.action"
								style="margin-left: 10px;"> 取消</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>