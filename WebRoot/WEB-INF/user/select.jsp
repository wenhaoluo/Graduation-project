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
		var win = parent.$("iframe[title='课程管理']").get(0).contentWindow;//返回ifram页面窗体对象（window)
			$('#dg').datagrid({    

			    //支持多条件查询
			    url:'${proPath}/user/selectPageUseDyc.action', 
			    
			    fitColumns:true,
			    nowrapL:true,
			    idField:'userid',
			    singleSelect:true,
			    rownumbers:true,
			    pagination:true,
			    pageSize:20,
			    pageList:[5,10,20],
			    
			    queryParams: {
					username: '%%',
					role:'教练'			
				}, 
						    
			    toolbar: [{
					iconCls: 'icon-ok',
					text:'选择教练',
					handler: function(){
						var row =  $("#dg").datagrid("getSelected");
						alert(row.userid);
						win.$("#ff").form('load',{
							teachername:row.truename,
							teacherid:row.userid
						}); 
						parent.$("#win").window("close");
					}
				},'-',{
					text:"用户名：<input type='text' id='username' name='username'/>",					
				}
				,'-',],			       
			    

				columns : [ [{
					checkbox:true,
				}, {
				field : 'userid',
				title : '教练编号'
			}, 
			{
				field : 'truename',
				title : '教练姓名',
				width : 100
			} 
			
			] ]
		});
		
			$('#role').searchbox({ 
				searcher:function(value,name){ 
					alert("role:"+value); 
					alert("username:"+$('#username').val());
					$('#dg').datagrid('load',{
						username: '%'+$('#username').val()+'%',
						role:'%'+value+'%'		
					});					
				}, 
				prompt:'' 
			});

	});
</script>
</head>

<body>
<table id="dg"></table>
</body>
</html>