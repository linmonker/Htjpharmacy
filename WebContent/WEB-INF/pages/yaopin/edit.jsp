<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改药品</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.jqprint-0.3.js"></script>
<script src="${ctx}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script>
	$(document).ready(function() {
		// 设置状态下拉列表
		var sid = $("#ypzt").val();
		if (sid != '') {
			$("#zt option[value=" + sid + "]").attr("selected", true);
		}
		// 设置分店下拉列表
		sid = $("#flid").val();
		if (sid != '') {
			$("#yplb option[value=" + sid + "]").attr("selected", true);
		}
		// 设置供应商下拉列表
		sid = $("#gysid").val();
		if (sid != '') {
			$("#ypgys option[value=" + sid + "]").attr("selected", true);
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
				<a class="navbar-brand">某中医馆药房管理</a>
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
					<li><a href="${ctx }/gongyingshang/list">供应商管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list">药品分类管理</a></li>
					<li class="active"><a href="${ctx }/yaopin/list">药品管理</a></li>
					<li><a href="${ctx }/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx }/keshi/list">科室管理</a></li>
					<li><a href="${ctx }/chushi/list">处室管理</a></li>
					<li><a href="${ctx }/yonghu/sylist">用户管理</a></li>
					<li><a href="${ctx }/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-md-10 maincon">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">修改药品</a>
						</div>
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav">
								<li><a onclick="return topdf()">打印</a></li>
							</ul>
						</div>
					</div>
				</nav>
				<div class="errormsg">
					<input id="flid" type="hidden" value="${yaopin.yplb }" />
					<input id="gysid" type="hidden" value="${yaopin.ypgys }" />
					<input id="ypzt" type="hidden" value="${yaopin.zt }" />
					<span>${msgmsg }</span><span>${bhmsg }</span> <span>${mcmsg}</span>
				</div>
				<form id="formpot" class="form-horizontal"
					action="${ctx }/yaopin/doedit" method="post">
					<div class="form-group">
						<input type="hidden" name="id" value="${yaopin.id }" />
					</div>
					<div class="container-fluid">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#jbxx"
								aria-controls="jbxx" role="tab" data-toggle="tab">基本信息</a></li>
							<li role="presentation"><a href="#jgxx" aria-controls="jgxx"
								role="tab" data-toggle="tab">价格信息</a></li>
						</ul>
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="jbxx">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ypbh" class="col-md-3 control-label">编号</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypbh" name="ypbh"
												value="${yaopin.ypbh }" data-validate="required:请输入编号"/>
										</div>
									</div>
									<div class="form-group">
										<label for="ypspm" class="col-md-3 control-label">商品名</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypspm" name="ypspm"
												value="${yaopin.ypspm }" data-validate="required:请输入商品名"/>
										</div>
									</div>
									<div class="form-group">
										<label for="yptym" class="col-md-3 control-label">通用名</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="yptym" name="yptym"
												value="${yaopin.yptym }" />
										</div>
									</div>
									<div class="form-group">
										<label for="yplb" class="col-md-3 control-label">药品类别</label>
										<div class="col-md-8">
											<select id="yplb" class="form-control" name="yplb">
												<c:forEach items="${ypfllist }" var="flist">
													<option value="${flist.id }">${flist.flmc }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label for="ypgys" class="col-md-3 control-label">供应商</label>
										<div class="col-md-8">
											<select id="ypgys" class="form-control" name="ypgys">
												<c:forEach items="${gyslist }" var="glist">
													<option value="${glist.id }">${glist.gysmc }(${glist.fdmc })</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label for="ypgg" class="col-md-3 control-label">药品规格</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypgg" name="ypgg"
												value="${yaopin.ypgg }" data-validate="required:请输入药品规格"/>
										</div>
									</div>
									<div class="form-group">
										<label for="ypbzgg" class="col-md-3 control-label">包装规格</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypbzgg"
												name="ypbzgg" value="${yaopin.ypbzgg }" />
										</div>
									</div>
									<div class="form-group">
										<label for="ypcd" class="col-md-3 control-label">产地</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypcd" name="ypcd"
												value="${yaopin.ypcd }" data-validate="required:请输入产地"/>
										</div>
									</div>
									<div class="form-group">
										<label for="ypscdw" class="col-md-3 control-label">生产单位</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypscdw" name="ypscdw" 
												value="${yaopin.ypscdw }" data-validate="required:请输入生产单位"/>
										</div>
									</div>
									<div class="form-group">
										<label for="ypjx" class="col-md-3 control-label">剂型</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypjx" name="ypjx"
												value="${yaopin.ypjx }" />
										</div>
									</div>
									<div class="form-group">
										<label for="ypdw" class="col-md-3 control-label">计量单位</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypdw" name="ypdw"
												value="${yaopin.ypdw }" data-validate="required:请输入计量单位"/>
										</div>
									</div>
									<div class="form-group">
										<label for="ypzddcgml" class="col-md-3 control-label">单次限购</label>
										<div class="col-md-8">
											<input type="number" min="0" class="form-control" id="ypzddcgml"
												name="ypzddcgml" value="${yaopin.ypzddcgml }" />
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="ypsx" class="col-md-3 control-label">属性</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypsx" name="ypsx"
												value="${yaopin.ypsx }" />
										</div>
									</div>
									<div class="form-group">
										<label for="ypzcsb" class="col-md-3 control-label">注册商标</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypzcsb"
												name="ypzcsb" value="${yaopin.ypzcsb }" />
										</div>
									</div>
									<div class="form-group">
										<label for="yppzwh" class="col-md-3 control-label">批准文号</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="yppzwh"
												name="yppzwh" value="${yaopin.yppzwh }" />
										</div>
									</div>
									<div class="form-group">
										<label for="ypysbz" class="col-md-3 control-label">验收标准</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypysbz"
												name="ypysbz" value="${yaopin.ypysbz }" />
										</div>
									</div>
									<div class="form-group">
										<label for="ypcctj" class="col-md-3 control-label">储藏条件</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypcctj"
												name="ypcctj" value="${yaopin.ypcctj }" />
										</div>
									</div>
									<div class="form-group">
										<label for="ypyxq" class="col-md-3 control-label">有效期</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="ypyxq" name="ypyxq"
												value="${yaopin.ypyxq }" />
										</div>
									</div>
									<div class="form-group">
										<label for="ypkcsx" class="col-md-3 control-label">库存上限</label>
										<div class="col-md-8">
											<input type="number" min="0" class="form-control" id="ypkcsx"
												name="ypkcsx" value="${yaopin.ypkcsx }" />
										</div>
									</div>
									<div class="form-group">
										<label for="ypkcxx" class="col-md-3 control-label">库存下限</label>
										<div class="col-md-8">
											<input type="number" min="0" class="form-control" id="ypkcxx"
												name="ypkcxx" value="${yaopin.ypkcxx }" />
										</div>
									</div>
									<div class="form-group">
										<label for="zt" class="col-md-3 control-label">状态</label>
										<div class="col-md-8">
											<select class="form-control" id="zt" name="zt">
												<option value="0">启用</option>
												<option value="1">禁用</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">用药提醒开关</label>
										<div class="col-md-8">
											<label class="radio-inline">
												<input type="radio" name="ypyytx" id="ypyytx1"
													<c:if test="${yaopin.ypyytx == 0 }">checked</c:if> value="0">
												开
											</label>
											<label class="radio-inline">
												<input type="radio" name="ypyytx" id="ypyytx2" checked
													value="1">
												关
											</label>
										</div>
									</div>
									<div class="form-group">
										<label for="ypyytxnr" class="col-md-3 control-label">用药提醒内容</label>
										<div class="col-md-8">
											<textarea class="form-control" rows="4" id="ypyytxnr"
												name="ypyytxnr">${yaopin.ypyytxnr }</textarea>
										</div>
									</div>
								</div>
							</div>
							<div role="tabpanel" class="tab-pane" id="jgxx">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ypjhj" class="col-md-3 control-label">进货价</label>
										<div class="col-md-8">
											<input type="number" min="0" class="form-control" id="ypjhj"
												name="ypjhj" value="${yaopin.ypjhj }" />
										</div>
									</div>
									<div class="form-group">
										<label for="yppfj" class="col-md-3 control-label">批发价</label>
										<div class="col-md-8">
											<input type="number" min="0" class="form-control" id="yppfj"
												name="yppfj" value="${yaopin.yppfj }" />
										</div>
									</div>
									<div class="form-group">
										<label for="yplsj" class="col-md-3 control-label">零售价</label>
										<div class="col-md-8">
											<input type="number" min="0" class="form-control" id="yplsj"
												name="yplsj" value="${yaopin.yplsj }" />
										</div>
									</div>
									<div class="form-group">
										<label for="yphyj" class="col-md-3 control-label">会员价</label>
										<div class="col-md-8">
											<input type="number" min="0" class="form-control" id="yphyj"
												name="yphyj" value="${yaopin.yphyj }" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">是否允许打折</label>
										<div class="col-md-8">
											<label class="radio-inline">
												<input type="radio" name="ypsfdz" id="ypsfdz1"
													<c:if test="${yaopin.ypsfdz == 0 }">checked</c:if> value="0">
												是
											</label>
											<label class="radio-inline">
												<input type="radio" name="ypsfdz" id="ypsfdz2" checked
													value="1">
												否
											</label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">是否参与积分</label>
										<div class="col-md-8">
											<label class="radio-inline">
												<input type="radio" name="ypsfcyhyjf" id="ypsfcyhyjf1"
													<c:if test="${yaopin.ypsfcyhyjf == 0 }">checked</c:if>
													value="0">
												是
											</label>
											<label class="radio-inline">
												<input type="radio" name="ypsfcyhyjf" id="ypsfcyhyjf2" checked
													value="1">
												否
											</label>
										</div>
									</div>
								</div>
							</div>
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