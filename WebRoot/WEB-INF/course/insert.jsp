<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>My JSP</title>
	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='课程管理']").get(0).contentWindow;//返回ifram页面文档（window)
		
			$("[name='yytime']").validatebox({
				required : true,
				missingMessage : '请填写预约时间！'
			});
			$("[name='teacherid']").validatebox({
				required : true,
				missingMessage : '请填写预约教练！'
			});
			$("[name='cid']").validatebox({
				required : true,
				missingMessage : '请填写预约课程！'
			});
			//禁用验证
			$("#ff").form("disableValidation");

			$("#btn").click(function() {
				//alert("ddddddddddd");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					alert("------------");
					$('#ff').form('submit', {
						url : '${proPath}/course/insert.action',
						onSubmit : function() {
							return true;
						},
						success : function(count) {							
								//可以定义为对应消息框
                        	    alert("成功");
								parent.$("#win").window("close");
								win.$("#dg").datagrid("reload");							
						}
					});

				}

			});
			$('#cname').searchbox({ 
				searcher:function(value,name){ 
	
				 			parent.$('#win').window({    
								title :'选择课程',						
							    width:800,    
							    height:600,    
							    modal:true,
							    content:"<iframe src='${proPath}/base/goURL/jsclass/select.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
							});  
				
				}, 
				prompt:'请选择课程' 
			});
			$('#teachername').searchbox({ 

				searcher:function(value,name){ 
				//alert(value + "," + name);
				 			parent.$('#win').window({    
								title :'选择教练',						
							    width:800,    
							    height:600,    
							    modal:true,
							    content:"<iframe src='${proPath}/base/goURL/user/select.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
							});  
				
				}, 
				prompt:'请选择教练' 
			});

		});
	</script>
</head>
<body>
	    <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
	    	<table cellpadding="5">
	    	<div style="display: none">
			<input type="text" value="0" name="classover" />
		</div>
	    		<tr>
	    			<td>预约时间:</td>
	    			<td><input  type="text" id="yytime" class="easyui-datetimebox" name="yytime" required="required" /></td>
	    		</tr>
	    		<tr>
	    			<td>预约教练:</td>
	    			<td><input type="hidden" id="teacherid" name="teacherid"/>
 						<input type="text" id="teachername" name="teachername"/></td>
	    		</tr>
	    		<tr>
	    			<td>预约课程:</td>
	    			<td><input type="hidden" id="cid" name="cid"/>
 						<input type="text" id="cname" name="cname"/></td>
	    		</tr>
	    		<tr>
	    			
	    			<td><input type="hidden" value="${sessionScope.user.userid}" name="studentid"/></td>
	    		</tr>
	    		
	    	</table>
	    </form>
<div>
			<input id="btn" type="button" value="提交" />
		</div>




</body>
</html>
