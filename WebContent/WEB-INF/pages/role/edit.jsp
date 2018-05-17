<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改角色</title>
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/metroStyle.css" />
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.jqprint-0.3.js"></script>
<script src="${ctx}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/static/js/jquery.ztree.all.min.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script>
	// 设置ztree
	var zTree_Menu;
	var setting = {
		view : {
			selectedMulti : true, // 可以多选
			showLine : false,
			showIcon : false
		},
		check : {
			enable : true,
			chkStyle : "checkbox", //复选框
			chkboxType : {
				"Y" : "ps",
				"N" : "ps"
			}
		},
		data : {
			simpleData : {
				enable : true
			},
		},
	};

	// 加载ztree  
	function onloadZTree() {
		var ztreeNodes;
		$.ajax({
			async : true, //是否异步  
			cache : false, //是否使用缓存  
			type : 'post', //请求方式,post  
			dataType : "json", //数据传输格式  
			url : "${ctx}/role/menulist", //请求链接  
			error : function() {
				alert('获取页面数据失败，请刷新');
			},
			success : function(data) {
				$.fn.zTree.init($("#treeDemo"), setting, data);
				zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
				getquanxianfrompaga();
			}
		});
	}

	// 从页面input获取角色权限，并勾选权限复选框
	function getquanxianfrompaga() {
		var qxs = $("#quanxians").val();
		if (qxs.length > 0) {
			qxs = $.parseJSON(qxs);
			for (var i = 0; i < qxs.length; i++) {
				var nodes = zTree_Menu.getNodesByParam("id", qxs[i].id);
				zTree_Menu.checkNode(nodes[0], true, true);
			}
		}
	}

	// 从服务器获取角色权限，并勾选权限复选框
	function getquanxianfromser() {
		var ztreeNodes;
		$.ajax({
			async : true, //是否异步  
			cache : false, //是否使用缓存  
			type : 'post', //请求方式,post  
			dataType : "json", //数据传输格式  
			url : "${ctx}/role/getquanxian?id="
					+ $("input[name='role_id']").val(), //请求链接  
			error : function() {
				alert('获取权限数据失败，请重新操作');
			},
			success : function(qxs) {
				for (var i = 0; i < qxs.length; i++) {
					var nodes = zTree_Menu.getNodesByParam("id", qxs[i].id);
					zTree_Menu.checkNode(nodes[0], true, true);
				}
			}
		});
		return true;
	}

	// 记录权限复选框数据
	function jiluquanxian() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = zTree.getCheckedNodes(true);
		var qxs = [];
		for (var i = 0, l = nodes.length; i < l; i++) {
			if (!nodes[i].isParent) { //isParent判断是否为父级，也就是是否有下级
				var qx = {
					id : nodes[i].id
				}; //获取所选节点的id
				qxs.push(qx);
			}
		}
		$("#quanxians").val(JSON.stringify(qxs));
		return true;
	}

	// 打印PDF
	function topdf() {
		$("#formpot").jqprint({
			debug : false,
			importCSS : true,
			printContainer : true,
			operaSupport : true
		});
	}

	$(document).ready(function() {
		// ztree初始化操作  
		onloadZTree();
		// 设置状态下拉列表
		var sid = $("#rolezt").val();
		if (sid != '') {
			$("#zt option[value=" + sid + "]").attr("selected", true);
		}
	});
</script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">宏济堂中医馆药房管理</a>
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
					<li><a href="${ctx }/gongyingshang/list">供应商管理</a></li>
					<li><a href="${ctx }/yaopinfenlei/list">药品分类管理</a></li>
					<li><a href="${ctx }/yaopin/list">药品管理</a></li>
					<li><a href="${ctx }/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx }/keshi/list">科室管理</a></li>
					<li><a href="${ctx }/chushi/list">处室管理</a></li>
					<li><a href="${ctx }/yonghu/sylist">用户管理</a></li>
					<li class="active"><a href="${ctx }/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-md-10 maincon">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">修改角色</a>
						</div>
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav">
								<li><a onclick="return topdf()">打印</a></li>
							</ul>
						</div>
					</div>
				</nav>
				<div class="errormsg">
					<input id="rolezt" type="hidden" value="${role.zt }" />
					<span>${waymsg}</span> <span>${bhmsg}</span> <span>${mcmsg}</span>
				</div>
				<form id="formpot" class="form-horizontal" action="${ctx }/role/doedit"
					method="post" onsubmit="return jiluquanxian()">
					<div class="form-group">
						<input type="hidden" name="role_id" value="${role.role_id }" />
						<input type="hidden" id="quanxians" name="quanxians"
							value="${quanxians }">
					</div>
					<div class="form-group">
						<label for="role_name" class="col-md-2 control-label">名称</label>
						<div class="col-md-5">
							<input type="text" class="form-control" id="role_name"
								name="role_name" value="${role.role_name }"
								data-validate="required:请输入名称" />
						</div>
					</div>
					<div class="form-group">
						<label for="remark" class="col-md-2 control-label">备注信息</label>
						<div class="col-md-5">
							<textarea class="form-control" rows="4" id="remark" name="remark">${role.remark }</textarea>
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
						<label class="col-md-2 control-label">权限</label>
						<div class="col-md-5 pre-scrollable">
							<div class="content_wrap">
								<div class="zTreeDemoBackground ">
									<ul id="treeDemo" class="ztree"></ul>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-3">
							<button class="btn btn-primary" type="submit">提交</button>
							<button class="btn btn-primary" type="reset"
								onclick="return getquanxianfromser()">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>