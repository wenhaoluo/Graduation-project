package com.jsf.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsf.entity.Course;
import com.jsf.entity.Order;
import com.jsf.entity.Page;
import com.jsf.entity.User;
import com.jsf.service.CourseService;


@Controller
@RequestMapping("/course")
public class CourseAction extends BaseAction{
	@Resource
	private CourseService courseService;
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping(value="/insert")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object insert(Course course) {
		System.out.println("---action.user:"+course);
		int i = 0;
		try {
			i = courseService.insert(course);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	
		@RequestMapping("/deleteList")
		@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
		public Object deleteList(String [] pks){
			int i = 0;
			try {
				i = courseService.deleteList(pks);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		
		//通过关键字分页查询
		@RequestMapping("/selectPageListteacher")
		@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
		public Object selectPageListteacher(Page<Course> page,Course course,HttpServletRequest request){			
			String userid = request.getParameter("userid");
			course.setTeacherid(Integer.valueOf(userid));
			page.setParamEntity(course);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userid", Integer.valueOf(userid));
			map.put("cid", course.getCid());
			map.put("page", page);
			page.setUserid(Integer.valueOf(userid));
			Page p= courseService.selectPageListteacher(page);
			return p.getPageMap();

		}

		//通过关键字分页查询
				@RequestMapping("/selectPageUseDyc")
				@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
				public Object selectPageUseDyc(Page<Course> page,Course course,HttpServletRequest request){			
					String userid = request.getParameter("userid");
					course.setStudentid(Integer.valueOf(userid));
					page.setParamEntity(course);
					//Page p = courseService.selectPageUseDyc(page);
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("userid", Integer.valueOf(userid));
					map.put("cid", course.getCid());
					map.put("page", page);
					page.setUserid(Integer.valueOf(userid));
					Page p= courseService.selectPageUseDyc(page);
					return p.getPageMap();

				}
}
