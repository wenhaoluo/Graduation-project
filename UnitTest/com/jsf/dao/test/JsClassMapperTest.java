package com.jsf.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jsf.dao.HuifuMapper;
import com.jsf.dao.JsclassMapper;
import com.jsf.entity.Jsclass;
import com.jsf.entity.Page;
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //配置事务回滚
@Transactional			//事务管理
public class JsClassMapperTest {
	private JsclassMapper JsClassMapper;
	
	private static String xmlPath = "classpath:applicationContext.xml";
	
	@Before
	public void setUp() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				xmlPath//, "classpath:generatorConfig.xml", "classpath:myBatis-config.xml", "classpath:spring-mvc.xml"
				);
		
		JsClassMapper = applicationContext.getBean(JsclassMapper.class);
	}
	
	@Test
	public void InsertJsClassTest() {
		Jsclass jc = new Jsclass();
		jc.setCid(6);
		jc.setCname("测试健身课程名称");
		jc.setCtext("测试健身课程内容");
		Integer record = this.JsClassMapper.insert(jc);
		Integer Expected = 1;
		assertEquals(Expected,record);
	}
	
	@Test
	public void UpdateJsClassTest() {
		Jsclass jc = new Jsclass();
		jc.setCid(6);
		jc.setCname("测试健身课程名称修改");
		jc.setCtext("测试健身课程内容修改");
		Integer record = this.JsClassMapper.update(jc);
		Integer Expected = 1;
		assertEquals(Expected,record);
	}
	
	
	@Test
	@Ignore
	public void SelectPageListUseDycTest() {
		Jsclass jc = new Jsclass();
		jc.setCname("哑铃");
		
		Page<Jsclass> page = new Page<Jsclass>();
		page.setPage(1);
		page.setRows(20);
		page.setParamEntity(jc);
		List<Jsclass> record = this.JsClassMapper.selectPageListUseDyc(page);
		assertNotNull(record);
	}
	
	@Test
	public void SelectPageCountUseDycTest() {
		Jsclass jc = new Jsclass();
		jc.setCname("哑铃卧推");
		
		Page page = new Page();
		page.setParamEntity(jc);
		Integer record = this.JsClassMapper.selectPageCountUseDyc(page);
		Integer Expected = 1;
		assertEquals(Expected,record);
	}
	
	@Test
	public void DeleteListTest() {
		String[] arr = {"582","583"};
		Integer record = this.JsClassMapper.deleteList(arr);
		Integer Expected = 2;
		assertEquals(Expected,record);
	}
	
}
