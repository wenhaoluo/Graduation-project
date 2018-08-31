<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/common/common.jspf"%>
<%@ include file="/common/bbscommon.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'huifu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function _tanchu() {
		var zt = document.getElementById("zt_u_abs");
		zt.onmouseover = function() {
			document.getElementById("zt_u_bg").style.display = "block";
		};
		zt.onmouseout = function() {
			document.getElementById("zt_u_bg").style.display = "none";
		};
	}
	
	
	function showReplyArea(tieid){
		var id = "last_reply_"+tieid ; 
		var ele = document.getElementById(id);
		if(ele.style.display=="none"){
			ele.style.display="block";
		}else{
			ele.style.display="none";
		}
	}
</script>
  </head>
  
 <body>
	<div class="main1118">
		<div class="title1118">
			<a
				style="cursor: pointer;font-size: 20px;line-height: 47px;color: #666;">我的提问</a>
			<a href="${proPath}/tie/selecttie.action" class="fr back1118">返回问答中心</a>
		</div>



		<!-- 问答列表 -->
		<div id="showTopics">

			<c:forEach items="${mytie}" var="t">
			
			<div class="content1118" style="border-bottom: none;">
				<div class="oneDiv">

					<div class="fr oneRight">
						<div class="oneTop">
							<div class="fr operation"></div>
							<p>
								<span class="name">${t.tieauthor } </span> <span class="danwei" style="float: right;">
									
								</span>
							</p>
							<p class="gray">${t.tiedate }</p>
						</div>
						<h3 class="bt ol">
							<span style="color:#59657d;">${t.tietitle }</span>

						</h3>
						<p class="stuFont ol" style="margin-left: 0px;">
							<span style="color:#59657d;">${t.tiecontext }</span>
						</p>
						
						
						<!-- 回复按钮 -->
						<p class="clearfix">
							<a href="javascript:showReplyArea(${t.tieid })" class="fr tl1"><font id="count_${t.tieid }">回复</font></a>
						</p>
					</div>

					<div class="clear"></div>

					<!-- 回复表单 -->
					
						<div id="last_reply_${t.tieid }" class="hfpl clearfix" style="display:none; margin-top: 15px;position:relative">
							<form  method="post" action="${proPath}/tie/inserthuifu.action">
							<input type="hidden" value="${sessionScope.user.userid}" name="userid" />
							<input type="hidden" value="${sessionScope.user.truename}" name="hfauthor" />
							<input type="hidden" value="${t.tieid }" name="tieid" />
							<textarea id="hfcontext" name="hfcontext" class="fl inp02" style="width: 715px;"></textarea>
							<input type="submit" class="fl grenBtn" value="回复">
								</form>
						</div>
					
				</div>


				<!-- 分割线 -->
				<p class="borSolid"></p>

				<!-- 回复列表 -->
				 <div id="replyDiv_${t.tieid}">
				 
				 	<c:forEach items="${tiehuifu}" var="h">
				 	<c:if test="${h.tieid==t.tieid }">
						<div class="listHf clearfix" style="border-bottom: #e2e2e2 solid 1px; padding-left: 25px;">
							<p style="color:#666;padding-left:12px;" class="ol">
								<span class="listTime"  style="padding-right: 0px;">${h.hfdate }</span>

							</p>
							
							<div style="color:#666;padding-left:12px">${h.hfauthor } ：${h.hfcontext }</div>
						</div>
					</c:if>
					</c:forEach>
					
				
				</div> 
				
			</div>

			</c:forEach>



		</div>
	</div>
	<script type="text/javascript">
		function showReply(qid){
			var id = "topics_"+qid;
			var ele = document.getElementById(id);
			if(ele.style.display=="none"){
				ele.style.display="block"
			}else{
				ele.style.display="none"
			}
		}

	</script>
	
</body>
</html>
