<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>

<title>My JSP</title>
</head>
<body>

	
	  <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>课程介绍:</td>
	    			<td><input class="easyui-textbox" type="text" name="cname" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>课程内容:</td>
	    			<td><textarea name="ctext"style="width: 150%;height:200;"></textarea></td>
	    		</tr>

	    	</table>
	    </form>
<div>
			<input id="btn" type="button" value="提交" />
		</div>
	

	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='课程信息']").get(0).contentWindow;//返回ifram页面文档（window)
		
			$("[name='cname']").validatebox({
				required : true,
				missingMessage : '请填写课程介绍！'
			});
			$("[name='ctext']").validatebox({
				required : true,
				missingMessage : '请填写课程内容！'
			});
			
			//禁用验证
			$("#ff").form("disableValidation");

			$("#btn").click(function() {
				//alert("ddddddddddd");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					alert("------------");
					$('#ff').form('submit', {
						url : '${proPath}/jsclass/insert.action',
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

		});
	</script>
</body>
</html>
