<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>药品分类列表</title>
<link rel="stylesheet" href="${ctx}/static/css/pintuer.css">
<link rel="stylesheet" href="${ctx}/static/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/static/css/metroStyle.css" />
<script src="${ctx}/static/js/jquery.js"></script>
<script src="${ctx}/static/js/pintuer.js"></script>
<script src="${ctx}/static/js/bootstrap.min.js"></script>
<script src="${ctx}/static/js/jquery.ztree.all.min.js"></script>
<script type="text/javascript">
	var dragId;
	var zTree_Menu;
	var setting = {
		view : {
			addHoverDom : addHoverDom,
			removeHoverDom : removeHoverDom,
			selectedMulti : false,
			showLine : false,
			selectedMulti : false,
			showIcon : false
		},
		edit : {
			enable : true,
			showRemoveBtn : setRemoveBtn,
			removeTitle : "删除分类",
			renameTitle : "编辑分类",
			drag : {
				isCopy: false,
				isMove: false,
				prev : false,
				next : false,
				inner : false,
			},
			editNameSelectAll : true
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
		
			beforeEditName : beforeEditName,
			beforeRemove : beforeRemove,
			beforeRename : beforeRename,
			onRemove : onRemove,
			onRename : onRename,
		}
	};
	//采用简单数据模式 (Array)  
	var zNodes = [ {
		id : 1,
		pId : 0,
		name : "拖拽 1"
	}, {
		id : 11,
		pId : 1,
		name : "拖拽 1-1"
	}, {
		id : 111,
		pId : 11,
		name : "拖拽 1-1-1"
	}, {
		id : 12,
		pId : 1,
		name : "拖拽 1-2"
	}, {
		id : 121,
		pId : 12,
		name : "拖拽 1-2-1"
	},
	{
		id : 122,
		pId : 12,
		name : "拖拽 1-2-2"
	}, {
		id : 1221,
		pId : 121,
		name : "拖拽 1-2-2-1"
	}, {
		id : 123,
		pId : 12,
		name : "拖拽 1-2-3"
	}, {
		id : 1231,
		pId : 123,
		name : "拖拽 1-2-3-1"
	}, {
		id : 1232,
		pId : 123,
		name : "拖拽 1-2-3-2"
	}, {
		id : 1233,
		pId : 123,
		name : "拖拽 1-2-3-3"
	}, {
		id : 2,
		pId : 0,
		name : "拖拽 2"
	}, {
		id : 21,
		pId : 2,
		name : "拖拽 2-1"
	}, {
		id : 22,
		pId : 2,
		name : "拖拽 2-2"
	}, {
		id : 23,
		pId : 2,
		name : "拖拽 2-3"
	}, {
		id : 3,
		pId : 0,
		name : "拖拽 3"
	}, {
		id : 31,
		pId : 3,
		name : "拖拽 3-1"
	}, {
		id : 32,
		pId : 3,
		name : "拖拽 3-2"
	}, {
		id : 33,
		pId : 3,
		name : "拖拽 3-3"
	} ];

	//用于捕获节点编辑按钮的 click 事件，并且根据返回值确定是否允许进入名称编辑状态  
	function beforeEditName(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.selectNode(treeNode);
		return true;
	}
	
	//用于捕获节点被删除之前的事件回调函数，并且根据返回值确定是否允许删除操作  
	function beforeRemove(treeId, treeNode) {
		 var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
         zTree.selectNode(treeNode);  
         var confirmFlag = confirm("确认删除分类[ " + treeNode.name + " ]吗？" )  
         var confirmVal = false;  
         if(confirmFlag){  
              var data = {id:treeNode.id};  
             $.ajax({  
                  async: false,  
                  type: "post",  
                  data:data,  
                  url: "${ctx}/youpinfenlei/delete.action ",  
                  success: function(json){  
                         if(json == "success" ){  
                             confirmVal = true;  
                        } else{  
             alert('删除失败！');  
                        }  
                  },  
                  error: function(){  
                        alert('删除失败！');  
                  }  
             });  
        }  
         return confirmVal;  
	}
	
	//用于捕获删除节点之后的事件回调函数  
	function onRemove(e, treeId, treeNode) {
		 alert('删除成功！');  

	}
	
	//更新节点名称数据之前的事件回调函数，并且根据返回值确定是否允许更改名称的操作  
	function beforeRename(treeId, treeNode, newName) {
		if (newName.length == 0 || newName.indexOf("请输入名称")>=0) {  
	         alert('请输入分类名称！');  
	                 var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
	                 setTimeout( function(){zTree.editName(treeNode)}, 10);  
	                 return false;  
	           }  
	            if(newName.length > 15){  
	        alert('分类名称过长！');  
	                var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
	                setTimeout( function(){zTree.editName(treeNode)}, 10);  
	                return false;  
	           }  
	           native_name = treeNode.name;  
	           return true;  
	}
	
	//用于捕获节点编辑名称结束之后的事件回调函数  
	function onRename(e, treeId, treeNode) {
		 if(native_name == treeNode.name){  
             return;  
        }  
        var data = {id:treeNode.id,level_id:treeNode.level,pid:treeNode.pId,name:treeNode.name};  
        $.ajax({  
            async: false,  
            type: "post",  
            data:data,  
            url: "${ctx}/youpinfenlei/update.action ",  
            success : function(json){  
                  if(json == "success" ){  
           alert('操作成功!');  
                 } else{  
           alert('操作失败，请稍后再试！');  
                 }  
            },  
            error : function()    {  
         alert('网络有点不给力呀！');  
            }  
       });  

	}

	//用于当鼠标移动到节点上时，显示用户自定义控件   添加子节点
	var newCount = 1;
	function addHoverDom(treeId, treeNode) {
		 var sObj = $("#" + treeNode.tId + "_span");  
         if (treeNode.editNameFlag || $("#addBtn_" +treeNode.tId).length>0 || treeNode.level == 3) return;  
         var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='添加分类' onfocus='this.blur();'></span>";  
         sObj.after(addStr);  
         var btn = $("#addBtn_" +treeNode.tId);  
         if (btn) btn.bind("click" , function(){  
              var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
              var treeNodes;
              var data = {id:treeNode.id,level_id:treeNode.level};  
             $.ajax({  
                  async: true,  
                  type: "post",
                  data:data,
                  url: "${ctx}/yaopinfenlei/insert.action",  
                  success : function(flid){  
                         if(flid != "" ){  
                             treeNodes = zTree.addNodes(treeNode, {id:(flid), pId:treeNode.id, name:"新分类" });  
                        }  
                         if (treeNodes) {  
                             zTree.editName(treeNodes[0]);  
                        }  
                  },  
                  error : function(){  
                        alert('网络有点不给力呀！');  
                  }  
             });  
              return false;  
        });  
	}
	
	//父分类去掉删除功能
	function setRemoveBtn(treeId, treeNode) {  
		return !treeNode.isParent;
	}

	//鼠标移开按钮消失  
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_" + treeNode.tId).unbind().remove();
	};

	//添加按钮点击事件  
    function addClick(){  
          $( "#addParent").bind("click" , {isParent:true}, add);  
    }  
 
    //移除分类  
    function remove(e) {  
           var zTree = $.fn.zTree.getZTreeObj("treeDemo"),  
          nodes = zTree.getSelectedNodes(),  
          treeNode = nodes[0];  
           if (nodes.length == 0) {  
                alert( "请先选择一个分类!" );  
                return;  
          }  
           var callbackFlag = $("#callbackTrigger" ).attr("checked");  
          zTree.removeNode(treeNode, callbackFlag);  
    };  
      
    //展开全部分类  
    function expandAllFlag(){  
          zTree_Menu.expandAll( true);  
    }  
    //合并全部分类  
    function combineAllFlag(){  
          zTree_Menu.expandAll( false);  
    }  
     
	function selectAll() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.setting.edit.editNameSelectAll = $("#selectAll").attr("checked");
	};

	//加载ztree  
    function onloadZTree(){  
           var ztreeNodes;  
          $.ajax( {  
               async : true, //是否异步  
               cache : false, //是否使用缓存  
               type : 'post', //请求方式,post  
               dataType : "json", //数据传输格式  
               url : "${ctx}/yaopinfenlei/list.action/ ", //请求链接  
               error : function() {  
                    alert('网络有点不给力呀！');  
               },  
               success : function(data) {  
                    ztreeNodes = date;
                    $.fn.zTree.init($( "#treeDemo"), setting, ztreeNodes);  
                    zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo" );  
                    $( "#selectAll").bind("click" , selectAll);  
                    expandAllFlag();  
                    addClick();  
               }  
          });  
    }  
      
     //初始化操作  
    $(document).ready( function(){  
          onloadZTree();  
    });  
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
		<div id="navbar" class="row navbar-collapse collapse">
			<div class="col-sm-2 col-md-2 sidebar">
				<h4>管理项目</h4>
				<ul class="nav nav-sidebar">
					<li><a href="${ctx }/fendian/list.action">分店管理</a></li>
					<li class="active"><a href="${ctx }/yaopinfenlei/list.action">药品分类</a></li>
					<li><a href="${ctx }/yaopin/list.action">药品信息管理</a></li>
					<li><a href="${ctx }/gongyingshang/list.action">供应商管理</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-9 main">
				<div class="row">
					<nav class="navbar navbar-default">
					<div class="container-fluid">
						<div class="navbar-header">
							<a class="navbar-brand">药品分类列表</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav">

								<li><span style="margin-left: 50px; font-size: 20px">${adddata}</span></li>
								<li><span style="margin-left: 50px; font-size: 20px">${deletedata}</span></li>
							</ul>
						</div>
					</div>
					</nav>
				</div>
				<div class="row">
					<div class="content_wrap">
						<div class="zTreeDemoBackground ">
							<ul id="treeDemo" class="ztree"></ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>