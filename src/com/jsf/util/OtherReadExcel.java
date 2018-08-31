package com.jsf.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class OtherReadExcel extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String UPLOAD_PATH = "/usr/tmp";
	private String fileNames;
	private InputStream uploadFileStream;
	private String parameters;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 为解析类提供配置信息
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建解析类的实例
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 开始解析
		sfu.setFileSizeMax(1024 * 400);
		// 每个表单域中数据会封装到一个对应的FileItem对象上
		try {
			List<FileItem> items = sfu.parseRequest(req);
			// 区分表单域
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				// isFormField为true，表示这不是文件上传表单域
				if (!item.isFormField()) {
					setUploadFileStream(item.getInputStream());
					setFileNames(item.getName());
				} else {
					//获取参数parameters
					System.out.println(item.getFieldName());
					if (item.getFieldName().equals("parameters")) {
						this.setParameters(item.getString());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}

	public String getFileNames() {
		return this.fileNames;
	}

	public InputStream getUploadFileStream() {
		return uploadFileStream;
	}

	public void setUploadFileStream(InputStream uploadFileStream) {
		this.uploadFileStream = uploadFileStream;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

}