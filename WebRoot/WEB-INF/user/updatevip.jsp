<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>修改会员信息</title>
</head>
<body>

		    <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
	    	<table cellpadding="5">
	    	<div style="display: none">
			<input type="text" name="userid" />
		</div>	
			    	<div style="display: none">
			<input type="text" name="empid" value="${sessionScope.user.userid}"/>
		</div>	
				<tr>
	    		<td>会员到期时间:</td>
	    			<td><input readOnly="true" class="easyui-textbox" type="text"  
	    			name="vipendtime" value="${sessionScope.user.vipendtime}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>会员充值:</td>
	    			<td><select class="easyui-combobox" name="number">
	    			<option value="1">月卡</option>
	    			<option value="3">季卡</option>
	    			<option value="12">年卡</option>
	    			</select></td>
	    		</tr>
	    	</table>
	    </form>
<div>
			<input id="btn" type="button" value="提交" />
		</div>
	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='会员信息']").get(0).contentWindow;//返回ifram页面文档（window)
		    var array =win.$("#dg").datagrid("getSelections");
		    alert(array[0].userid);
		    $("#ff").form('load',{
		    	userid : array[0].userid,
		    	vipendtime : array[0].vipendtime,
				
			});		


			$("#btn").click(function() {
				//alert("ddddddddddd");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					alert("------------");
					$('#ff').form('submit', {
						url : '${proPath}/order/updatevip.action',
						onSubmit : function() {
							return true;
						},
						success : function(count) {							
								//可以定义为对应消息框
                        	    alert("成功");
								parent.$("#win").window("close");
								win.$("#dg").datagrid("reload");
								 //根据需要调整
								win.$("#dg").datagrid("clearSelections");							
						}
					});

				}

			});

		});
	</script>
</body>
</html>
