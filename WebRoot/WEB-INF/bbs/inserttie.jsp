<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>My JSP</title>
</head>
<body>

	<form id="ff" method="post">

		<div>
			<label for="username">账号:</label> <input type="text" name="username" />
		</div>
		<div>
			<label for="password">密码:</label> <input type="text" name="password" />
		</div>
		<div>
			<label for="role">角色:</label> <input type="text"
				name="role" />
		</div>

		<div>
			<input id="btn" type="button" value="提交" />
		</div>
	</form>

	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='会员信息']").get(0).contentWindow;//返回ifram页面文档（window)
		
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
