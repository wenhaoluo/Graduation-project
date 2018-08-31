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
			    url:'${proPath}/order/selectPageUseDyc.action', 
			    
			    fitColumns:true,
			    nowrapL:true,
			    idField:'orderid',
			    rownumbers:true,
			    pagination:true,
			    pageSize:20,
			    pageList:[5,10,20],
			    queryParams: form2Json("searchform"), //关键之处
			   

				columns : [ [{
					checkbox:true,
				}, {
				field : 'orderid',
				title : '订单编号'
			}, {
				field : 'ordertime',
				title : '订单生成时间',
				width : 100
			}, {
				field : 'orderprice',
				title : '订单价格',
				width : 100
			},{
				field : 'empid',
				title : '操作员工id',
				width : 100
			},{
				field : 'userid',
				title : '充值会员id',
				width : 100
			}] ]
		});
		

	

	});
</script>
</head>

<body style="margin:0px">
<div>  
	<form name="searchform" method="post" action="" id ="searchform">
        <div >  
            查询日期：<input  type="text" id="start"
				class="easyui-datebox" name="starttime" required="required"></input>
				<input  type="text" id="end"
				class="easyui-datebox" name="endtime" required="required"></input>
             <a id="submit_search">搜索</a>
        </div>  
        </form>
    </div>  
    <script type="text/javascript">
    $("#submit_search").linkbutton({ iconCls: 'icon-search', plain: true })
    .click(function () {
        $('#dg').datagrid({ queryParams: form2Json("searchform") });   //点击搜索
    });


//将表单数据转为json
function form2Json(id) {

    var arr = $("#" + id).serializeArray()
    var jsonStr = "";

    jsonStr += '{';
    for (var i = 0; i < arr.length; i++) {
        jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
    }
    jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
    jsonStr += '}'

    var json = JSON.parse(jsonStr)
    return json
}
    
	    $("#submit_search").click(function () {
	        $('#dg').datagrid({ queryParams: form2Json("searchform") });   //点击搜索
	    });
    </script>
    
	<table id="dg"></table>


	
</body>
</html>