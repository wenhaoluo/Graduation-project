<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf"%>
<html>
<head>


<title></title>
<style type="text/css">
.searchbox{
	margin:-3
}
</style>

<script type="text/javascript">
	$(function(){

			$('#dg').datagrid({    

			    //支持多条件查询
			    url:'${proPath}/user/selectPageUseDyc.action', 
			    
			    fitColumns:true,
			    nowrapL:true,
			    idField:'userid',
			    rownumbers:true,
			    pagination:true,
			    pageSize:20,
			    pageList:[5,10,20],
			    
			     queryParams: {
					username: '%%'		
				}, 
						    
			    toolbar: [{
					iconCls: 'icon-add',
					text:'新增',
					handler: function(){
						alert('新增按钮');
						parent.$('#win').window({    
							title :'添加用户',						
						    width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/goURL/user/insert.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
						}); 
					}
						

				},'-',{
					iconCls: 'icon-edit',
					text:'修改',
					handler: function(){
						alert('修改按钮');
						//判断是否选中一行，并且只能选中一行进行修改
						var array = $('#dg').datagrid("getSelections");
						if(array.length!=1){
							alert("请选择需要修改的记录，并且只能选中一条！");
							return false;							
						}
						
						//打开修改窗口
						parent.$('#win').window({    
							title :'修改用户',
						    width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/goURL/user/update.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
						}); 
						
					}
				},'-',{
					iconCls: 'icon-edit',
					text:'充值',
					handler: function(){
						alert('充值按钮');
						//判断是否选中一行，并且只能选中一行进行修改
						var array = $('#dg').datagrid("getSelections");
						if(array.length!=1){
							alert("请选择需要修改的记录，并且只能选中一条！");
							return false;							
						}
						
						//打开修改窗口
						parent.$('#win').window({    
							title :'充值用户',
						    width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/goURL/user/updatevip.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
						}); 
						
					}
				},'-',{
					iconCls: 'icon-remove',
					text:'删除',
					handler: function(){
						alert('删除按钮');
						var array = $('#dg').datagrid("getSelections");
						if(array.length>0){
							alert("选中");
							
							
							//定义数组，通过下边的用来存储选中记录的Id
						var ids = new Array();
						for (i = 0; i < array.length; i++) {
							ids[i] = array[i].userid;
							alert(ids[i]);
						}
						//alert("ids" + ids);
						//如果需要锁整个页面，前面加parent.
						parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {
							if (r) {
								alert(r);
								$.ajax({
								  url: "${proPath}/user/deleteList.action",
								  type:"POST",
								  //设置为传统方式传送参数
								  traditional:true,
								  data:{pks:ids},
								  success: function(html){
									  if(html>0){
									  	alert("恭喜您 ，删除成功，共删除了"+html+"条记录");
									  }else{
									  	alert("对不超 ，删除失败");
									  }
								  //重新刷新页面
								    $("#dg").datagrid("reload");
								    //请除所有勾选的行
								    $("#dg").datagrid("clearSelections");
								  },
								  error: function (XMLHttpRequest, textStatus, errorThrown) {
									    $.messager.alert('删除错误','请联系管理员！','error');
									},
								  dataType:'json'
								});

							}
						});

						}else{
							alert("请选择需要删除的记录！");
						}
					}
		
				},'-',{
					iconCls: 'icon-edit',
					text:'导出',
					handler: function(){

					location.href = "${proPath}/excel/dcexcel.action";

					}},'-',
				{
					text:"名称：<input type='text' id='username' name='username'/>",					
				}],			       
			    

				columns : [ [{
					checkbox:true,
				}, {
				field : 'userid',
				title : '用户编号'
			}, {
				field : 'username',
				title : '用户名',
				width : 100
			}, {
				field : 'password',
				title : '密码',
				width : 100
			}, {
				field : 'role',
				title : '角色名',
				width : 100
			},
			{
				field : 'sex',
				title : '性别',
				width : 100
			},
			{
				field : 'truename',
				title : '姓名',
				width : 100
			},
			{
				field : 'birth',
				title : '出生日期',
				width : 100
			},
			{
				field : 'phone',
				title : '电话',
				width : 100
			},
			{	field:'vipendtime',
				title:'会员到期时间',
				width:100,
           }   ] ]
		});
		
			$('#username').searchbox({ 
			searcher:function(value,name){ 
				
				$('#dg').datagrid('load',{				
					username:'%'+value+'%'		
				});					
			}, 
			prompt:'' 
		});
	

	});
</script>
</head>

<body style="margin:0px">

	<table id="dg"></table>


	
</body>
</html>