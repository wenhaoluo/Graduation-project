package com.jsf.action;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsf.entity.Jsclass;
import com.jsf.entity.Page;
import com.jsf.service.JsclassService;

@Controller
@RequestMapping("/jsclass")
public class JsclassAction extends BaseAction{
	@Resource
	private JsclassService jsclassService;

	/**
	 * 添加课程
	 * @return
	 */
	@RequestMapping(value="/insert")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object insert(Jsclass jsclass) {
		System.out.println("---action.jsclass:"+jsclass);
		int i = 0;
		try {
			i = jsclassService.insert(jsclass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 * 修改用户
	 * @return
	 */
	//根据主键修改用户的信息
		@RequestMapping(value="/update")
		@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
		public Object update(Jsclass jsclass){
			System.out.println("---action.update.jsclass:"+jsclass);
			int i = 0;
			try {
				i = jsclassService.update(jsclass);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		@RequestMapping("/deleteList")
		@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
		public Object deleteList(String [] pks){
			System.out.println("---doAjax.deleteList:"+pks);
			int i = 0;
			try {
				i = jsclassService.deleteList(pks);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//通过关键字分页查询
		@RequestMapping("/selectPage")
		@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
		public Object selectPage(Page<Jsclass> page){
			Page p = jsclassService.selectPage(page);
			System.out.println("----page:"+page);
			return page.getPageMap();
		}
		//通过关键字分页查询
		@RequestMapping("/selectPageUseDyc")
		@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
		public Object selectPageUseDyc(Page<Jsclass> page,Jsclass jsclass){			
			page.setParamEntity(jsclass);
			System.out.println("----page:"+page);
			Page p = jsclassService.selectPageUseDyc(page);
			return p.getPageMap();
		}

}
