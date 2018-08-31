package com.jsf.action;

import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.jsf.entity.User;
import com.jsf.service.UserService;
import com.jsf.util.ReadExcel;







@Controller
@RequestMapping("/excel")
public class ExcelAction extends BaseAction{
	
	@Resource
	private UserService userService;
	// 保存文件的目录
	private static String PATH_FOLDER = "d:/";
	// 存放临时文件的目录
	private static String TEMP_FOLDER = "d:/";
	//信息的导入
	@RequestMapping("/dcexcel")
		public void downloadExcel(HttpServletResponse response) throws Exception {
			 List<User> detailList = userService.select1();
			//2.将用户信息组织称csv格式的数据
			StringBuffer buffer = new StringBuffer();
			String str = "账号,密码,角色,性别,真实姓名,生日,手机,会员到期时间\r\n";
			///str = new String(str.getBytes("UTF-8"),"GBK");
			buffer.append(str);
			for (User si : detailList) {
				buffer.append(si.getUsername() + "," + si.getPassword() + "," + si.getRole() + "," + si.getSex()+"," + si.getTruename()+"," +si.getBirth()+"," +si.getPhone()+"," +si.getVipendtime()+"\r\n");
			}
			String data = buffer.toString();
			
			//3.提供下载
			String filename = "用户信息_"+new Date().toLocaleString()+".csv";
			response.setCharacterEncoding("GBK");
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename,"GBK"));
			response.setContentType(application.getMimeType(filename));
			response.getWriter().write(data);
		 }
	
	
	
	@RequestMapping("/drexcel")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selecttie(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws Exception{			

		request.setCharacterEncoding("utf-8"); // 设置编码
		response.setContentType("text/html;charset=UTF-8");
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(TEMP_FOLDER));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);
		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// 提交上来的信息都在这个list里面
			// 这意味着可以上传多个文件
			// 请自行组织代码
			List<FileItem> list = upload.parseRequest(request);
			// 获取上传的文件
			FileItem item = getUploadFileItem(list);
			// 获取文件名
			String filename = getUploadFileName(item);
			String value = getUploadValue(list);//携带参数
			System.err.println(value+"<<<<<<<<<<<<");
			// 保存后的文件名
			String saveName =  new Date().getTime()+ filename.substring(filename.lastIndexOf("."));
			// 保存后图片的浏览器访问路径
			String picUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload/"+saveName;
			System.out.println("存放目录:" + PATH_FOLDER);
			System.out.println("文件名:" + filename);
			System.out.println("浏览器访问路径:" + picUrl);
			File file=new File(PATH_FOLDER);
			if(!file.exists()&& !file .isDirectory())
				 {
				file.mkdir(); 
				 }
				 else{//创建
					 System.out.print("文件夹已存在");
				 }
			// 真正写到磁盘上
			item.write(new File(PATH_FOLDER, saveName)); // 第三方提供的
			
			int result=readExcel(PATH_FOLDER+saveName);
			
			System.err.println(result+"《《《《《《《《《《《《《成功调用！");

	
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		
		return "forward:/WEB-INF/bbs/tie.jsp";
	}
	private String  getUploadValue(List<FileItem> list) {
		for (FileItem fileItem : list) {
			if(fileItem.isFormField()) {
				String  value=fileItem.getString();
				 try {
					value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}  	
				return value;
			}
		}
		return null;
	}
	private FileItem getUploadFileItem(List<FileItem> list) {
		for (FileItem fileItem : list) {
			if(!fileItem.isFormField()) {
				return fileItem;
			}
		}
		return null;
	}
	
	private String getUploadFileName(FileItem item) {
		// 获取路径名
		String value = item.getName();
		// 索引到最后一个反斜杠
		int start = value.lastIndexOf("/");
		// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
		String filename = value.substring(start + 1);
		return filename;
	}
	/**
	 * 查看会员信息-导出
	 * @return
	 */
	public Integer readExcel(String path){
		Integer  result=0;
		Map<String,String> table=new HashMap<String,String>();
		table.put("账号","username");
		table.put("密码", "password");
		table.put("角色", "role");
		table.put("性别", "sex");
		table.put("真实姓名", "truename");
		table.put("生日", "birth");
		table.put("手机", "phone");
		table.put("会员到期时间", "vipendtime");
		try {
			String[] myfieldNames = ReadExcel.impotrHead(path, table);//头解析
			List<User> list = new ArrayList<User>();
			Map<Integer, String> map = ReadExcel.readExcelContent(path);//数据内容
			list = ReadExcel.readExcels(User.class, table, myfieldNames, map);
			for (int i = 0; i < list.size(); i++) {
			
				System.err.println(
						list.get(i).getUsername() + ">>>>" + list.get(i).getPassword() + ">>>>" + list.get(i).getRole() + list.get(i).getPhone());
				userService.insert(list.get(i));
				result=1;
					} 
			
			} catch (Exception e) {
							}
//下面便可以进行数据库添加Student的业务调用了			
return result;

}
}
