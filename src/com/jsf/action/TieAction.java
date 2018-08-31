package com.jsf.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsf.entity.Huifu;
import com.jsf.entity.Jsclass;
import com.jsf.entity.Page;
import com.jsf.entity.Tie;
import com.jsf.entity.User;
import com.jsf.service.HuifuService;
import com.jsf.service.TieService;





@Controller
@RequestMapping("/tie")
public class TieAction extends BaseAction{
	
	@Resource
	private TieService tieService;
	
	@Resource
	private HuifuService huifuService;
	
	
	
	
	
	@RequestMapping("/selecttie")
//	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selecttie(HttpServletRequest request,HttpSession session) throws Exception{			
		
		System.out.println("----page:tie");
		List<Tie> tie = tieService.selecttie();

		System.out.println(tie);
		request.setAttribute("tie",tie);
		System.out.println("----page:huifu");
		List<Huifu> huifu = huifuService.selecthuifu();
		System.out.println(huifu);
		request.setAttribute("huifu",huifu);
		return "forward:/WEB-INF/bbs/tie.jsp";
	}
	/**
	 * 查看我的留言
	 * @return
	 */
	@RequestMapping("/selectmytie")
//	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectmytie(Tie tie,HttpServletRequest request,HttpSession session) throws Exception{			
		
		System.out.println("----page:tie");
		String userid = request.getParameter("userid");
		
		System.out.println("----userid=:"+userid);
		tie.setUserid(Integer.valueOf(userid));
		System.out.println(tie.getUserid());
		List<Tie> mytie = tieService.selectmytie(tie);

		System.out.println(mytie);
		request.setAttribute("mytie",mytie);
		System.out.println("----page:huifu");
		List<Huifu> tiehuifu = huifuService.selecthuifu();
		System.out.println(tiehuifu);
		request.setAttribute("tiehuifu",tiehuifu);
		return "forward:/WEB-INF/bbs/huifu.jsp";
	}
	
	/**
	 * 添加留言
	 * @return
	 */
	@RequestMapping(value="/inserttie")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public String insert(Tie tie,HttpServletRequest request,HttpSession session) {
		System.out.println("---action.user:"+tie.getUserid());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		tie.setTiedate(date);
		
		try {
			 tieService.insert(tie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return "success";
	}
	
	/**
	 * 添加回复
	 * @return
	 */
	@RequestMapping(value="/inserthuifu")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public String insert(Huifu huifu,HttpServletRequest request,HttpSession session) {
		System.out.println("---action.user:"+huifu.getUserid());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		huifu.setHfdate(date);
		
		System.out.println("---action.user:"+huifu.getHfdate());
		try {
			huifuService.insert(huifu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return "success";
	}
	
	
	/**
	 * 添加课程
	 * @return
	 */
	@RequestMapping(value="/insert")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object insert(Tie tie) {
		System.out.println("---action.tie:"+tie);
		int i = 0;
		try {
			i = tieService.insert(tie);
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
		public Object update(Tie tie){
			System.out.println("---action.update.tie:"+tie);
			int i = 0;
			try {
				i = tieService.update(tie);
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
				i = tieService.deleteList(pks);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//通过关键字分页查询
		@RequestMapping("/selectPage")
		@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
		public Object selectPage(Page<Tie> page){
			Page p = tieService.selectPage(page);
			System.out.println("----page:"+page);
			return page.getPageMap();
		}
		//通过关键字分页查询
		@RequestMapping("/selectPageUseDyctie")
		@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
		public Object selectPageUseDyctie(Page<Tie> page,Tie Tie){			
			page.setParamEntity(Tie);
			System.out.println("----page:"+page);
			Page p = tieService.selectPageUseDyc(page);
			return p.getPageMap();
		}
	
}
