package com.jsf.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jsf.dao.UserMapper;
import com.jsf.entity.Page;
import com.jsf.entity.User;
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //配置事务回滚
@Transactional			//事务管理
public class UserMapperTest{
	@Autowired
	private UserMapper UserMapper;
	
	private static String xmlPath = "classpath:applicationContext.xml";
	
	@Before
	public void setUp() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

		UserMapper = applicationContext.getBean(UserMapper.class);
	}
	
	@After
	public void tearDown() throws Exception{
		
	};

	@Test
	public void LoginUserTest() {
		User user = new User();
		user.setUsername("2333");
		user.setPassword("5555");
		user.setRole("管理员");
		User record = this.UserMapper.login(user);
		assertNotNull(record);
	}
	
	
	@Test
	public void Select1Test() {
		List<User> record = this.UserMapper.select1();
		assertNotNull(record);
	}
	
	@Test
	public void InsertUserTest() {
		User user = new User();
		user.setUserid(100);
		user.setUsername("testinsert");
		user.setPassword("Password01+");
		user.setRole("会员");
		user.setSex("男");
		user.setTruename("测试人员");
		user.setBirth("1990-11-11");
		user.setPhone("1234567");
		user.setVipendtime("2018-11-11");
		Integer record = this.UserMapper.insert(user);
		Integer Expected = 1;
		assertEquals(Expected,record);
	}
	
	@Test
	public void UpdatetUserTest() {
		User user = new User();
		user.setUserid(100);
		user.setUsername("testupdate");
		user.setPassword("Password01+up");
		user.setRole("员工");
		user.setSex("女");
		user.setTruename("测试人员更新");
		user.setBirth("2000-11-11");
		user.setPhone("7654321");
		user.setVipendtime("2018-11-11");
		Integer record = this.UserMapper.update(user);
		Integer Expected = 1;
		assertEquals(Expected,record);
	}
	
	@Test
	public void SelectPageListTest() {
		Page page = new Page();
		page.setKeyWord("员工");
		page.setPage(1);
		page.setRows(10);
		List<User> record = this.UserMapper.selectPageList(page);
		assertNotNull(record);
	}
	
	@Test
	public void SelectPageCountTest() {		
		Page page = new Page();
		page.setKeyWord("管理员");
		Integer record = this.UserMapper.selectPageCount(page);
		Integer Expected = 1;
		assertEquals(Expected,record);
	}
	
	@Test
	public void SelectPageListUseDycTest() {
		User user = new User();
		user.setUsername("test");
		user.setRole("管理员");

		Page page = new Page();
		page.setPage(1);
		page.setRows(10);
		page.setParamEntity(user);
		List<User> record = this.UserMapper.selectPageListUseDyc(page);
		assertNotNull(record);
	}
	
	@Test
	public void SelectPageCountUseDycTest() {
		User user = new User();
		user.setUsername("123");
		user.setRole("员工");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", user.getUsername());
		map.put("role", user.getRole());

		Page page = new Page();
		page.setParamEntity(map);
		Integer record = this.UserMapper.selectPageCountUseDyc(page);
		Integer Expected = 1;
		assertEquals(Expected,record);
	}
	
	@Test
	public void SelectUserTest() {
		User record = this.UserMapper.selectuser(20);
		assertNotNull(record);
	}
	
	@Test
	public void UpdateVipTest() {
		User record = new User();
		record.setNumber("1");
		record.setUserid(90);
		int UpVip = this.UserMapper.updatevip(record);
		assertEquals(1,UpVip);
	}
	
	@Test
	public void InsertVipTest() {
		User record = new User();
		record.setNumber("1");
		record.setUserid(90);
		int UpVip = this.UserMapper.insertvip(record);
		assertEquals(1,UpVip);
	}
	
	@Test
	public void DeleteListTest() {
		String[] arr = {"90","91"};
		Integer record = this.UserMapper.deleteList(arr);
		Integer Expected = 2;
		assertEquals(Expected,record);
	}
	
}
