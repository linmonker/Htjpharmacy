<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改供应商</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.jqprint-0.3.js"></script>
<script src="${ctx}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var sid = $("#gyszt").val();
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
				<ul class="nav nav-stacked">
					<li><a href="${ctx }/fendian/list">分店管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list">药品分类</a></li>
					<li><a href="${ctx }/yaopin/list">药品信息管理</a></li>
					<li class="active"><a href="${ctx }/gongyingshang/list">供应商管理</a></li>
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
							<a class="navbar-brand">修改供应商</a>
						</div>
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav">
								<li><a onclick="return topdf()">打印</a></li>
							</ul>
						</div>
					</div>
				</nav>
				<div>
					<input id="gyszt" type="hidden" value="${gys.zt }" />
					<span>${waymsg}</span> <span>${bhmsg}</span> <span>${mcmsg}</span>
				</div>
				<form id="formpot" class="form-horizontal"
					action="${ctx }/gongyingshang/doedit" method="post">
					<div class="form-group">
						<input type="hidden" name="id" value="${gys.id }" />
					</div>
					<div class="container-fluid">
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#jbxx"
								aria-controls="jbxx" role="tab" data-toggle="tab">基本信息</a></li>
							<li role="presentation"><a href="#gspzl" aria-controls="gspzl"
								role="tab" data-toggle="tab">GSP资料</a></li>
						</ul>
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane fade in active" id="jbxx">
								<div class="col-md-6">
									<div class="form-group">
										<label for="gysbh" class="col-md-3 control-label">编号</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysbh" name="gysbh"
												value="${gys.gysbh }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysmc" class="col-md-3 control-label">名称</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysmc" name="gysmc"
												value="${gys.gysmc }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysmcjp" class="col-md-3 control-label">名称简拼</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysmcjp"
												name="gysmcjp" value="${gys.gysmcjp }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gyslxdh" class="col-md-3 control-label">电话</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gyslxdh"
												name="gyslxdh" value="${gys.gyslxdh }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gyslyxdz" class="col-md-3 control-label">电子邮件</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gyslyxdz"
												name="gyslyxdz" value="${gys.gyslyxdz }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysxxdz" class="col-md-3 control-label">地址</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysxxdz"
												name="gysxxdz" value="${gys.gysxxdz }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gyslxr" class="col-md-3 control-label">联系人</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gyslxr"
												name="gyslxr" value="${gys.gyslxr }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysywy" class="col-md-3 control-label">业务员</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysywy"
												name="gysywy" value="${gys.gysywy }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysywydh" class="col-md-3 control-label">业务员电话</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysywydh"
												name="gysywydh" value="${gys.gysywydh }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysywysfz" class="col-md-3 control-label">业务员身份证</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysywysfz"
												name="gysywysfz" value="${gys.gysywysfz }" />
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="gysyzbm" class="col-md-3 control-label">邮政编码</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysyzbm"
												name="gysyzbm" value="${gys.gysyzbm }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysyyzz" class="col-md-3 control-label">营业执照</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysyyzz"
												name="gysyyzz" value="${gys.gysyyzz }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysyyzzqx" class="col-md-3 control-label">执照期限</label>
										<div class="col-md-8">
											<input type="date" class="form-control" id="gysyyzzqx"
												name="gysyyzzqx"
												value="<fmt:formatDate value='${gys.gysyyzzqx }' pattern='yyyy-MM-dd'/>" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysyyzzfzrq" class="col-md-3 control-label">执照发证日期</label>
										<div class="col-md-8">
											<input type="date" class="form-control" id="gysyyzzfzrq"
												name="gysyyzzfzrq"
												value="<fmt:formatDate value='${gys.gysyyzzfzrq }' pattern='yyyy-MM-dd'/>" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysfrdb" class="col-md-3 control-label">法人代表</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysfrdb"
												name="gysfrdb" value="${gys.gysfrdb }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysjyxz" class="col-md-3 control-label">经营性质</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysjyxz"
												name="gysjyxz" value="${gys.gysjyxz }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gyszczb" class="col-md-3 control-label">注册资本</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gyszczb"
												name="gyszczb" value="${gys.gyszczb }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysjyfs" class="col-md-3 control-label">经营方式</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysjyfs"
												name="gysjyfs" value="${gys.gysjyfs }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysjyfw" class="col-md-3 control-label">经营范围</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysjyfw"
												name="gysjyfw" value="${gys.gysjyfw }" />
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
								</div>
							</div>
							<div role="tabpanel" class="tab-pane" id="gspzl">
								<div class="col-md-6">
									<div class="form-group">
										<label for="gysgspzj" class="col-md-3 control-label">GSP证书号码</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysgspzj"
												name="gysgspzj" value="${gys.gysgspzj }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysgspzjyxq" class="col-md-3 control-label">GSP证书有效期</label>
										<div class="col-md-8">
											<input type="date" class="form-control" id="gysgspzjyxq"
												name="gysgspzjyxq"
												value="<fmt:formatDate value='${gys.gysgspzjyxq }' pattern='yyyy-MM-dd'/>" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysgspfzr" class="col-md-3 control-label">GSP证书负责人</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysgspfzr"
												name="gysgspfzr" value="${gys.gysgspfzr }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysscjyxkz" class="col-md-3 control-label">生产经营许可证编号</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysscjyxkz"
												name="gysscjyxkz" value="${gys.gysscjyxkz }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysxkzmc" class="col-md-3 control-label">许可证名称</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysxkzmc"
												name="gysxkzmc" value="${gys.gysxkzmc }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysxkzfzdw" class="col-md-3 control-label">发证单位</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysxkzfzdw"
												name="gysxkzfzdw" value="${gys.gysxkzfzdw }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysxkzdz" class="col-md-3 control-label">许可证地址</label>
										<div class="col-md-8">
											<input type="text" class="form-control" id="gysxkzdz"
												name="gysxkzdz" value="${gys.gysxkzdz }" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysxkzfzrq" class="col-md-3 control-label">许可证发证日期</label>
										<div class="col-md-8">
											<input type="date" class="form-control" id="gysxkzfzrq"
												name="gysxkzfzrq"
												value="<fmt:formatDate value='${gys.gysxkzfzrq }' pattern='yyyy-MM-dd'/>" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysxkzyxq" class="col-md-3 control-label">有效期至</label>
										<div class="col-md-8">
											<input type="date" class="form-control" id="gysxkzyxq"
												name="gysxkzyxq"
												value="<fmt:formatDate value='${gys.gysxkzyxq }' pattern='yyyy-MM-dd'/>" />
										</div>
									</div>
									<div class="form-group">
										<label for="gysbz" class="col-md-3 control-label">备注信息</label>
										<div class="col-md-8">
											<textarea class="form-control" rows="4" id="gysbz" name="gysbz">${gys.gysbz }</textarea>
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