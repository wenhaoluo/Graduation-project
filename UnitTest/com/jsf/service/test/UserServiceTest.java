package com.jsf.service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsf.entity.User;
import com.jsf.service.UserService;

public class UserServiceTest {

	@Autowired
	private UserService userservice;
	
	private static String xmlPath = "classpath:applicationContext.xml";
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		userservice = applicationContext.getBean(UserService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() {
		User user = new User();
		user.setUsername("2333");
		user.setPassword("5555");
		user.setRole("管理员");
		
		User result = this.userservice.login(user);
		assertNotNull(result);
	}

	@Test
	public void testUpdatevip() throws Exception {
		User user = new User();
		user.setUserid(93);
		
		int result = this.userservice.updatevip(user);
		assertEquals(1,result);
	}

	@Test
	public void testInsertvip() throws Exception {
		User user = new User();
		user.setUserid(94);
		
		int result = this.userservice.insertvip(user);
		assertEquals(1,result);
	}

	@Test
	public void testSelectuser() throws Exception {
		int id = 19;
		User result = this.userservice.selectuser(id);
		assertNotNull(result);
	}

	@Test
	public void testSelect1() {
		List<User> result = this.userservice.select1();
		assertNotNull(result);
	}

}
