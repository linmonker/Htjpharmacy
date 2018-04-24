<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>XXX医院管理系统</title>
	<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
	<link rel="stylesheet" href="${ctx}/static/css/admin.css">
	<script src="${ctx}/static/js/jquery.js"></script>
	<script src="${ctx}/static/js/pintuer.js"></script>
</head>
	<body>
		<div class="body">
			<div class="header bg-main">
				<div class="logo margin-big-left fadein-top">
					<h1><img src="${ctx}/static/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />XXX医院管理中心</h1>
				</div>
				<div class="head-l">
					<a class="button button-little bg-green" >用户：${username } 您好，您的权限为：${rolename }</a> &nbsp;&nbsp;
					<a class="button button-little bg-blue" href="admin"><span class="icon-home"></span> 后台管理</a> &nbsp;&nbsp;
					<a class="button button-little bg-red" href="${ctx}/outlogin"><span class="icon-power-off"></span> 退出登录</a>
				</div>
			</div>
			<div class="leftnav">
				<div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
				<shiro:hasPermission name="/hospital/list"><h2><span class="icon-caret-right"></span>统计查询</h2></shiro:hasPermission>
				<ul style="padding-top: 0px;" >
					<%--<h2><span class="icon-caret-right"></span><a href="hospital/list" target="right"><span class="icon-caret-right"></span>分院管理</a></h2>--%>
					<shiro:hasPermission name="/hospital/list"><h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px; padding-top: 5px;"></span>门诊分析</h2></shiro:hasPermission>
					<ul>
						<li><a href="${ctx}/hospital/list" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>门诊量</a></li>
						<li><a href="${ctx}/hospital/add" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>门诊收入</a></li>
						<li><a href="${ctx}/hospital/add" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>人均门诊费用</a></li>
					</ul>

					<shiro:hasPermission name="/user/hospitalAdmin/list"><h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px;"></span>门诊查询</h2></shiro:hasPermission>
					<ul>
						<li><a href="${ctx}/user/hospitalAdmin/list" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>挂号查询</a></li>
						<li><a href="${ctx}/user/hospitalAdmin/add" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>收费查询</a></li>
					</ul>

					<shiro:hasPermission name="/user/hospitalAdmin/list"><h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px;"></span>门诊统计</h2></shiro:hasPermission>
					<ul>
						<li><a href="${ctx}/user/hospitalAdmin/list" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>医生收入统计</a></li>
						<li><a href="${ctx}/user/hospitalAdmin/add" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>科室收入统计</a></li>
					</ul>
				</ul>



				<shiro:hasPermission name="/business/depot/daily/fy_admin"><h2><span class="icon-caret-right"></span>药房管理</h2></shiro:hasPermission>
				<!--style="display:block"-->
				<ul style="padding-top: 0px;">
					<h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px; padding-top: 5px;"></span>日常工作</h2>
					<ul>
						<li><a href="${ctx}/business/depot/daily/fy_admin" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>发药管理</a></li>
						<li><a href="${ctx}/business/depot/daily/bill" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>单据业务</a></li>
						<li><a href="${ctx}/business/depot/daily/drugadmin?pageNumber=1" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>药品管理</a></li>
						<li><a href="${ctx}/business/depot/daily/detection?pageNumber=1" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>药品检测</a></li>
						<li><a href="${ctx}/business/depot/daily/inventory?pageNumber=1" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>药品盘点</a></li>
					</ul>

					<h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px; padding-top: 5px;"></span>统计查询</h2>
					<ul>
						<li><a href="${ctx}/business/depot/statistics/yp_query?pageNumber=1" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>药品综合查询</a></li>
						<li><a href="${ctx}/business/depot/statistics/yp_sale?pageNumber=1" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>药品销售查询</a></li>
						<li><a href="${ctx}/business/depot/statistics/yp_typesum" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>药品各类汇总</a></li>
						<li><a href="${ctx}/business/depot/statistics/yp_pricesum?pageNumber=1" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>药品调价汇总</a></li>
					</ul>
				</ul>


				<shiro:hasPermission name="/user/doctor/list"><h2><span class="icon-caret-right"></span>门诊医师</h2></shiro:hasPermission>
				<!--style="display:block"-->
				<ul>
					<li><a href="${ctx}/business/registration/diagnosis" target="right"><span class="icon-caret-right"></span>患者就诊管理</a></li>
					<li><a href="${ctx}/user/doctor/add" target="right"><span class="icon-caret-right"></span>医生套餐管理</a></li>
					<li><a href="${ctx}/user/doctor/add" target="right"><span class="icon-caret-right"></span>常用药品项目</a></li>
					<li><a href="${ctx}/user/doctor/add" target="right"><span class="icon-caret-right"></span>医生收入统计</a></li>
				</ul>
				
				<h2><span class="icon-caret-right"></span>挂号收费</h2>
				<ul style="padding-top: 0px;">
					<%--<h2><span class="icon-caret-right"></span><a href="hospital/list" target="right"><span class="icon-caret-right"></span>分院管理</a></h2>--%>
					<h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px; padding-top: 5px;"></span>日常业务</h2>
					<ul>
						<li><a href="${ctx}/business/registration/process" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>号表处理</a></li>
						<li><a href="${ctx}/business/registration/management" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>挂号管理</a></li>
						<li><a href="${ctx}/business/registration/diagnosis" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>划价收费</a></li>
						<li><a href="${ctx}/business/registration/invalid" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>收费作废</a></li>
						<li><a href="${ctx}/business/registration/balance" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>收费冲账</a></li>
					</ul>
					<h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px;"></span>日结处理</h2>
					<ul>
						<li><a href="${ctx}/business/processing/personal" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>个人日结</a></li>
						<li><a href="${ctx}/business/user/hospitalAdmin/add" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>科室日结</a></li>
					</ul>
					<h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px; padding-top: 5px;"></span>查询统计</h2>
					<ul>
						<li><a href="${ctx}/business/statistics/query" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>挂号查询</a></li>
						<li><a href="${ctx}/business/statistics/monquery" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>收费查询</a></li>
						<li><a href="${ctx}/business/statistics/stdep" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>科室收入统计</a></li>
						<li><a href="${ctx}/business/statistics/dostat" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>医生收入统计</a></li>
					</ul>
					<h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px;"></span>票号维护</h2>
				</ul>

				<h2><span class="icon-caret-right"></span>系统设置</h2>
				<ul style="padding-top: 0px;">
					<%--<h2><span class="icon-caret-right"></span><a href="hospital/list" target="right"><span class="icon-caret-right"></span>分院管理</a></h2>--%>
					<h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px; padding-top: 5px;"></span>公工字典</h2>
					<ul>
						<li><a href="${ctx}/hospital/list" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>药典类</a></li>
						<li><a href="${ctx}/hospital/add" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>人员类</a></li>
						<li><a href="${ctx}/hospital/add" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>其他类</a></li>
					</ul>
					<h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px;"></span>医院字典</h2>
					<ul>
						<li><a href="${ctx}/user/hospitalAdmin/list" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>医疗类</a></li>
						<li><a href="${ctx}/user/hospitalAdmin/add" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>财务类</a></li>
						<li><a href="${ctx}/hospital/add" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>住院类</a></li>
						<li><a href="${ctx}/hospital/add" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>其他类</a></li>
					</ul>
					<h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px;"></span>医疗机构</h2>
				</ul>
				
				<%-- <shiro:hasPermission name=""></shiro:hasPermission> --%>

				<%--<h2><span class="icon-caret-right"></span>一级菜单</h2>--%>
				<%--<ul>--%>
					<%--<li><a href="/user/depotAdmin/add.html" target="right"><span class="icon-caret-right"></span>二级菜单1</a></li>--%>
					<%--<h2 style="font-weight: normal"><span class="icon-caret-right" style="margin-left: 8px;"></span>二级菜单2</h2>--%>
					<%--<ul>--%>
						<%--<li><a href="list.html" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>三级菜单1</a></li>--%>
						<%--<li><a href="add.html" target="right"><span class="icon-caret-right" style="margin-left: 10px;"></span>三级菜单2</a></li>--%>
					<%--</ul>--%>
					<%--<li><a href="/user/depotAdmin/delete.html" target="right"><span class="icon-caret-right"></span>二级菜单3</a></li>--%>
					<%--<li><a href="/user/depotAdmin/edit.html" target="right"><span class="icon-caret-right"></span>二级菜单4</a></li>--%>
				<%--</ul>--%>


			</div>
			<script type="text/javascript">
				$(function() {
					$(".leftnav h2").click(function() {
						$(this).next().slideToggle(200);
						$(this).toggleClass("on");
					});
					$(".leftnav ul li a").click(function() {
						$("#a_leader_txt").text($(this).text());
						$(".leftnav ul li a").removeClass("on");
						$(this).addClass("on");
					});

					$(".close,.bg-red").click(function(){
						$(".hm,.tc").css("display","none");
					});
				});

				function add(){
					$(".hm,.tc").css("display","block");
				}

			</script>
			<ul class="bread">
				<li><a href="info" target="right" class="icon-home"> 首页</a></li>
				<li><a href="##" id="a_leader_txt">欢迎使用</a></li>
			</ul>
			<div class="admin">
				<iframe scrolling="auto" rameborder="0" src="info/info" name="right" width="100%" height="100%"></iframe>
			</div>
		</div>

	</body>

</html>