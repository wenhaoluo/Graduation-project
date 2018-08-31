<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload  read excel</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/ajaxupload.js"></script>
<script type="text/javascript" src="js/jquery.jokeer.js"></script>
<script type="text/javascript">
	//建筑Excel导入
	$(function(){
	//上传图片
	new AjaxUpload('#BuildBtn', {
		action: 'Student.do?status=otherRead', 
		name: 'picFile',
		responseType: 'json',
		onSubmit : function(file , ext){
			if (ext && /^(xlsx)$/.test(ext.toLowerCase())){
				var executeEstimateId =$('#headId').val();
				var parameters = "{executeEstimateId:"+executeEstimateId+"}";
				this.setData({
					'picName': file,
					'parameters': parameters
					
				});
			} else {
				alert("请上传格式为 xlsx类型的文件！");
				return false;				
			}
		},
		onComplete : function(file,response){
			if(response.error) {
				alert(response.error);
				return;
			}
			
			 if(response.picUrl==1){
				alert("解析成功！")
				setTimeout('haha()', 3000);
			}else{
				alert("解析失败！")
				setTimeout('haha()', 3000);
			} 
		}		
	});
})
	

</script>

</head>

<body>
<input id="headId" type="text" value="12">
	<h1>另一种解析EXCEL(2007)</h1>
	<button class="BuildBtn btn btn-sm btn-success btn-info margin-right-10" id="BuildBtn">Excel导入</button>
</body>
</html>