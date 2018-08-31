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

import com.jsf.entity.Am;
import com.jsf.entity.Order;
import com.jsf.entity.Page;
import com.jsf.entity.User;
import com.jsf.service.AmService;
import com.jsf.service.OrderService;
import com.jsf.service.UserService;

@Controller
@RequestMapping("/am")
public class AmAction extends BaseAction{
	@Resource
	private AmService amService;

	
	@RequestMapping(value="/login")
	public String login(Am am,HttpServletRequest request,HttpSession session) throws ParseException{
		System.out.println("---action.user:"+am);
		
		Am am1 = amService.login(am);

		if (am1!=null ) {
			//存session
			session.setAttribute("user", am1);
			request.getSession().setAttribute("userid", am1.getAmid());
			return "forward:/WEB-INF/main/main.jsp";	
		}else {
			request.setAttribute("msg", "用户名或密码错误或者身份错误");
		}
		return "forward:/login.jsp";
	}
	

}
