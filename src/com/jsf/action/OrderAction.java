package com.jsf.action;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/order")
public class OrderAction extends BaseAction{
	
	@Resource
	private OrderService orderService;
	@Resource
	private UserService userService;
	
	/**
	 * 添加vip
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/updatevip")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public void insert(Order order,User user,HttpServletRequest request,HttpSession session) throws Exception {
		String number = request.getParameter("number");
		String vipendtime = request.getParameter("vipendtime");
		String empid = request.getParameter("empid");	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		Date vipendtime1 = sdf1.parse(vipendtime);
		Date date1 = sdf1.parse(date);
		boolean flag = vipendtime1.before(date1);
		order.setOrdertime(date);
		order.setEmpid(Integer.valueOf(empid));
		switch (number) {
		case "1":order.setOrderprice(500);
				break;
		case "3":order.setOrderprice(1200);
				break;
		case "12":order.setOrderprice(4000);
				break;
		}
		try {
			if (flag) {
				userService.insertvip(user);
			}else {
				userService.updatevip(user);
			}
			orderService.insert(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//通过关键字分页查询
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectPageUseDyc(Page<Order> page,Order order){			
	page.setParamEntity(order);
	System.out.println("----page:"+page);
	Page p = orderService.selectPageUseDyc(page);
	return p.getPageMap();
	}

	
}
