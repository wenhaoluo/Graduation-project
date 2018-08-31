package com.jsf.dao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jsf.dao.AmMapper;
import com.jsf.entity.Am;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //配置事务回滚
@Transactional			//事务管理
//@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
//@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件   
public class AmMapperTest {
	@Autowired
	private AmMapper amMapper;
	
	private static String xmlPath = "classpath:applicationContext.xml";
	
	@Before
	public void setUp() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

		amMapper = applicationContext.getBean(AmMapper.class);
	}
	
	@After
	public void tearDown() throws Exception{
		
	};
	
	@Test
	public void LoginAdminTest() {
		Am record =new Am();
		record.setAmpassword("123");
		record.setAmusername("123");
		Am admin = this.amMapper.login(record);
		assertNotNull(admin);
	}
	
}
