package com.jsf.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsf.entity.User;

@Controller
@RequestMapping("/base")
public class BaseAction {
	
	@Resource
	ServletContext application;	
	//方法参数folder通过@PathVariable指定其值可以从@RequestMapping的{folder}获取，同理file也一样
	@RequestMapping("/goURL/{folder}/{file}")
	public String goURL(@PathVariable String folder,@PathVariable String file) {
		//int userId = Integer.valueOf((String) request.getSession().getAttribute("userid"));
		System.out.println("goURL.folder|file===" + folder+"/"+file);
		return "forward:/WEB-INF/"+folder+"/"+file+".jsp";
	}
	

}
