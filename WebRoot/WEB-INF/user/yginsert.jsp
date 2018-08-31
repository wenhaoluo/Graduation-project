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
	    			<td>账号:</td>
	    			<td><input class="easyui-textbox" type="text" name="username" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input class="easyui-textbox" type="text" name="password" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>角色:</td>
	    			<td><select class="easyui-combobox" name="role">


	    			<option value="会员">会员</option>
	    			</select></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td><select class="easyui-combobox" name="sex">
	    			<option value="男">男</option>
	    			<option value="女">女</option>
	    			</select></td>
	    		</tr>
	    		<tr>
	    			<td>真实姓名:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" name="truename" data-options="required:true"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>生日:</td>
	    			<td>
	    				<input  type="text" id="birth"
				class="easyui-datebox" name="birth" required="required"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>电话:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" name="phone" data-options="required:true"></input>
	    			</td>
	    		</tr>
				
	    		
	    	</table>
	    </form>
<div>
			<input id="btn" type="button" value="提交" />
		</div>



	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='所有会员']").get(0).contentWindow;//返回ifram页面文档（window)
		
			$("[name='username']").validatebox({
				required : true,
				missingMessage : '请填写账号！'
			});
			$("[name='password']").validatebox({
				required : true,
				missingMessage : '请填写密码！'
			});
			$("[name='role']").validatebox({
				required : true,
				missingMessage : '请填写角色！'
			});
			//禁用验证
			$("#ff").form("disableValidation");

			$("#btn").click(function() {
				//alert("ddddddddddd");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					alert("------------");
					$('#ff').form('submit', {
						url : '${proPath}/user/insert.action',
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
