<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改角色</title>
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/static/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/metroStyle.css" />
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.jqprint-0.3.js"></script>
<script src="${ctx}/static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/static/js/jquery.ztree.all.min.js"></script>
<script>
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

	//加载ztree  
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
			}
		});
	}

	function setquanxians() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = zTree.getCheckedNodes(true);
		var v = "";
		for (var i = 0, l = nodes.length; i < l; i++) {
			if (!nodes[i].isParent) { //isParent判断是否为父级，也就是是否有下级
				v += nodes[i].id + ","; //获取所选节点的id
			}
		}
		if (v.length > 0) {
			v = v.substring(0, v.length - 1);
		}
		$("#quanxians").val(v)
		alert(v);
		return false;
	}
	
	function topdf() {
		$("#formpot").jqprint({
			debug : false,
			importCSS : true,
			printContainer : true,
			operaSupport : true
		});
	}

	//初始化操作  
	$(document).ready(function() {
		onloadZTree();
	});	
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
					<li><a href="${ctx }/gongyingshang/list">供应商管理</a></li>
					<li><a href="${ctx}/cangku/sylist">仓库管理</a></li>
					<li><a href="${ctx}/keshi/list">科室管理</a></li>
					<li><a href="${ctx}/zhuzhijigou/list">组织机构</a></li>
					<li><a href="${ctx}/yonghu/sylist">用户管理</a></li>
					<li class="active"><a href="${ctx}/role/list">角色管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<div class="field">
					<label class="sub-header">修改角色</label>
					<button class="btn btn-primary btn-sm" onclick="topdf()">打印</button>
					<span>${editmsg}</span><span>${mcmsg}</span>
				</div>
				<form id="formpot" method="post" class="form-x"
					action="${ctx }/role/doedit">
					<input type="hidden" name="role_id" value="${role.role_id }" />
					<input id="quanxians" name="quanxians" type="hidden" >
					<div class="form-group">
						<div class="label">
							<label>角色名称：</label>
						</div>
						<div class="field">
							<input type="text" class="form-control" name="role_name"
								value="${role.role_name }" data-validate="required:请输入角色名称" />
							<div class="tips"></div>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>备注信息：</label>
						</div>
						<div class="field">
							<textarea class="form-control" rows="3" name="remark">${role.remark }</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>角色状态：</label>
						</div>
						<div class="field">
							<select class="form-control" name="zt">
								<option value="0">启用</option>
								<option value="1">禁用</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label>权限：</label>
						</div>
						<div class="field">
							<div class="content_wrap">
								<div class="zTreeDemoBackground ">
									<ul id="treeDemo" class="ztree"></ul>
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