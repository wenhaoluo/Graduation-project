package com.jsf.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsf.entity.Order;
import com.jsf.entity.Page;
import com.jsf.entity.User;
import com.jsf.service.OrderService;
import com.jsf.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction extends BaseAction{
	@Resource
	private UserService userService;
	@Resource
	private OrderService orderService;
	
	@RequestMapping(value="/login")
	public String login(User user,HttpServletRequest request,HttpSession session) throws ParseException{
		System.out.println("---action.user:"+user);
		User user1 = userService.login(user);	
		if (user1!=null ) {
			//存session
			session.setAttribute("user", user1);
			request.getSession().setAttribute("userid", user1.getUserid());
			//会员到期时间对比系统时间
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
			String date = sdf1.format(new Date());
			String vipendtime=user1.getVipendtime();
			Date vipendtime1 = sdf1.parse(vipendtime);
			Date date1 = sdf1.parse(date);
			boolean flag = vipendtime1.before(date1);
			if (flag) {
				request.setAttribute("vip", "您的会员已经过期,请充值");
			}else {
				switch (user1.getRole()) {
				case "教练":return "forward:/WEB-INF/main/jlmain.jsp";
						
				case "员工":return "forward:/WEB-INF/main/ygmain.jsp";
						
				case "会员":return "forward:/WEB-INF/main/hymain.jsp";	
				
				case "管理员":return "forward:/WEB-INF/main/main.jsp";	
				}
			}
			
		}else {
			request.setAttribute("msg", "用户名或密码错误或者身份错误");
		}
		return "forward:/login.jsp";
	}
	/**
	 * 用户注销
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String logout(User user,HttpSession session,HttpServletResponse response){

		session.removeAttribute("user");
		return "forward:/login.jsp";
	}
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping(value="/insert")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object insert(Order order,User user,HttpServletRequest request,HttpSession session) {
		System.out.println("---action.user:"+user.getUserid());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		user.setVipendtime(date);
//		order.setOrdertime(date);
//		order.setUserid(user.getUserid());
//		String vipendtime = request.getParameter("vipendtime");
//		String empid = request.getParameter("empid");	
//		order.setEmpid((Integer.valueOf(empid)));
//		
//		switch (vipendtime) {
//		case "1":order.setOrderprice(500);
//				break;
//		case "3":order.setOrderprice(1200);
//				break;
//		case "12":order.setOrderprice(4000);
//				break;
//		}
		
		int i = 0;
		try {
			i = userService.insert(user);
//			orderService.insert(order);
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
		public Object update(Order order,User user,HttpServletRequest request,HttpSession session){
			System.out.println("---action.update.user:"+user);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(new Date());
			order.setOrdertime(date);
			order.setEmpid(user.getUserid());
			int i = 0;
			try {
				i = userService.update(user);
				orderService.insert(order);
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
				i = userService.deleteList(pks);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
		//通过关键字分页查询
		@RequestMapping("/selectPage")
		@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
		public Object selectPage(Page<User> page){
			Page p = userService.selectPage(page);
			System.out.println("----page:"+page);
			return page.getPageMap();
		}
		//通过关键字分页查询
		@RequestMapping("/selectPageUseDyc")
		@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
		public Object selectPageUseDyc(Page<User> page,User user){			
			page.setParamEntity(user);
			System.out.println("----page:"+page);
			Page p = userService.selectPageUseDyc(page);
			return p.getPageMap();
		}


}
