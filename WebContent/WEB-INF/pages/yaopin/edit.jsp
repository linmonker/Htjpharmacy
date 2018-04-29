<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改药品</title>
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/static/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.jqprint-0.3.js"></script>
<script src="${ctx}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script>
	$(document).ready(function() {
		var sid = $("#flid").val;
		if (sid != null) {
			$("#yplb option[value=sid]").attr("selected", true);
		}
		sid = $("#gysid").val;
		if (sid != null) {
			$("#ypgys option[value=sid]").attr("selected", true);
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
					<li class="active"><a href="${ctx }/yaopin/list">药品信息管理</a></li>
					<li><a href="${ctx }/gongyingshang/list">供应商管理</a></li>
					<li><a href="${ctx}/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list">科室管理</a></li>
					<li><a href="${ctx}/zhuzhijigou/list">组织机构</a></li>
					<li><a href="${ctx}/yonghu/sylist">用户管理</a></li>
					<li><a href="${ctx}/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<div class="field">
					<label class="sub-header">修改药品</label>
					<button class="btn btn-primary btn-sm" onclick="topdf()">打印</button>
					<input id="flid" type="hidden" value="${yaopin.yplb }" />
					<input id="gysid" type="hidden" value="${yaopin.ypgys }" />
					<span>${addmsg }</span><span>${bhmsg }</span> <span>${mcmsg}</span>
				</div>
				<form id="" formpot method="post" class="form-x"
					action="${ctx }/yaopin/doedit">
					<input type="hidden" name="id" value="${yaopin.id }" />
					<div>
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#jbxx"
								aria-controls="jbxx" role="tab" data-toggle="tab">基本信息</a></li>
							<li role="presentation"><a href="#jgxx" aria-controls="jgxx"
								role="tab" data-toggle="tab">价格信息</a></li>
						</ul>
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="jbxx">
								<div class="col-sm-6 col-md-8">
									<div class="form-group">
										<div class="label">
											<label>编号：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="ypbh"
												value="${yaopin.ypbh }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>商品名：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="ypspm"
												value="${yaopin.ypspm }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>通用名：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="yptym"
												value="${yaopin.yptym }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>药品类别：</label>
										</div>
										<div class="field">
											<select id="yplb" class="form-control" name="yplb">
												<c:forEach items="${ypfllist }" var="ylist">
													<option value="${ylist.id }">${ylist.flmc }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>供应商：</label>
										</div>
										<div class="field">
											<select id="ypgys" class="form-control" name="ypgys">
												<c:forEach items="${gyslist }" var="glist">
													<option value="${glist.id }">${glist.gysmc }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>药品规格：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="ypgg"
												value="${yaopin.ypgg}" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>包装规格：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="ypbzgg"
												value="${yaopin.ypbzgg }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>产地：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="ypcd"
												value="${yaopin.ypcd }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>单次限购：</label>
										</div>
										<div class="field">
											<input type="number" min="0" class="form-control"
												name="ypzddcgml" value="${yaopin.ypzddcgml }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>属性：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="ypsx"
												value="${yaopin.ypsx }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>用药提醒开关：</label>
										</div>
										<div class="field">
											<label class="radio-inline">
												<input type="radio" name="ypyytxnr" id="ypyytxnr1"
													<c:if test="${yaopin.ypyytxnr == 0 }">checked</c:if> value="0">开
											</label>
											<label class="radio-inline">
												<input type="radio" name="ypyytxnr" id="ypyytxnr2"
													<c:if test="${yaopin.ypyytxnr == 1 }">checked</c:if> value="1">关
											</label>
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>用药提醒内容：</label>
										</div>
										<div class="field">
											<textarea class="form-control" rows="2" name="ypyytxnr">${yaopin.ypyytxnr }</textarea>
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>生产单位：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="ypscdw"
												value="${yaopin.ypscdw }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>剂型：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="ypjx"
												value="${yaopin.ypjx }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>注册商标：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="ypzcsb"
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
											<input type="text" class="form-control" name="ypjx"
												value="${yaopin.ypjx }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>计量单位：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="ypdw"
												value="${yaopin.ypdw }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>验收标准：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="ypysbz"
												value="${yaopin.ypysbz }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>储藏条件：</label>
										</div>
										<div class="field">
											<input type="text" class="form-control" name="ypcctj"
												value="${yaopin.ypcctj }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>有效期：</label>
										</div>
										<div class="field">
											<input type="date" class="form-control" name="ypyxq"
												value="${yaopin.ypyxq }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>库存上限：</label>
										</div>
										<div class="field">
											<input type="number" min="0" class="form-control" name="ypkcsx"
												value="${yaopin.ypkcsx }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>库存下限：</label>
										</div>
										<div class="field">
											<input type="number" min="0" class="form-control" name=ypkcxx
												value="${yaopin.ypkcxx }" />
										</div>
									</div>
								</div>
							</div>
							<div role="tabpanel" class="tab-pane" id="jgxx">
								<div class="col-sm-8 col-md-10">
									<div class="form-group">
										<div class="label">
											<label>进货价：</label>
										</div>
										<div class="field">
											<input type="number" min="0" class="form-control" name="ypjhj"
												value="${yaopin.ypjhj }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>批发价：</label>
										</div>
										<div class="field">
											<input type="number" min="0" class="form-control" name="ypbfj"
												value="${yaopin.ypbfj }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>零售价：</label>
										</div>
										<div class="field">
											<input type="number" min="0" class="form-control" name="yplsj"
												value="${yaopin.yplsj }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>会员价：</label>
										</div>
										<div class="field">
											<input type="number" min="0" class="form-control" name="yphyj"
												value="${yaopin.yphyj }" />
										</div>
									</div>
									<div class="form-group">
										<div class="label">
											<label>是否允许打折：</label>
										</div>
										<div class="field">
											<label class="radio-inline">
												<input type="radio" name="ypsfdz" id="ypsfdz1"
													<c:if test="${yaopin.ypsfdz == 0 }">checked</c:if> value="0">
												是
											</label>
											<label class="radio-inline">
												<input type="radio" name="ypsfdz" id="ypsfdz2"
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
											<label class="radio-inline">
												<input type="radio" name="ypsfcyhyjf" id="ypsfcyhyjf1"
													<c:if test="${yaopin.ypsfcyhyjf == 0 }">checked</c:if>
													value="0">
												开
											</label>
											<label class="radio-inline">
												<input type="radio" name="ypsfcyhyjf" id="ypsfcyhyjf2"
													<c:if test="${yaopin.ypsfcyhyjf == 1 }">checked</c:if>
													value="1">
												关
											</label>
										</div>
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