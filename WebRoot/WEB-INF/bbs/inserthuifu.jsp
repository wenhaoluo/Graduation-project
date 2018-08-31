<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>My JSP</title>
</head>
<body>
	    <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
	    	<table cellpadding="5">
	    		<input type="hidden" value="${t.tieid }" name="tieid"  id="htieid"/>
	    		<tr>
	    		<td>回复内容:</td>
	    			<textarea id="hfcontext" name="hfcontext" id="hfcontext" style="width: 100%;"></textarea>
	    		</tr>
	    		<input type="hidden" value="${sessionScope.user.truename}" id="hfauthor" name="hfauthor" />
	    		<tr>
	    			<input type="hidden" value="${sessionScope.user.userid}" id="huserid" name="userid" />
	    		</tr>

				
	    		
	    	</table>
	    </form>
<div>
			<input id="btn" type="button" value="提交" />
		</div>



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
