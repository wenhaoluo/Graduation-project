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

import com.jsf.dao.AmMapper;
import com.jsf.entity.Page;
import com.jsf.entity.Tie;
import com.jsf.dao.TieMapper;
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //配置事务回滚
@Transactional			//事务管理
public class TieMapperTest {
	@Autowired
	private TieMapper TieMapper;
	
	private static String xmlPath = "classpath:applicationContext.xml";
	
	@Before
	public void setUp() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

		TieMapper = applicationContext.getBean(TieMapper.class);
	}
	
	@After
	public void tearDown() throws Exception{
		
	};
	
	@Test
	public void InsertTieTest() {
		Tie tie = new Tie();
		tie.setTieid(100);
		tie.setTietitle("inserttest");
		tie.setTieauthor("测试人员");
		tie.setTiecontext("测试插入内容");
		tie.setTiedate("2018-02-26 16:17:04");
		tie.setUserid(90);
		Integer record = this.TieMapper.insert(tie);
		Integer Expected = 1;
		assertEquals(Expected,record);
	}
	
	@Test
	public void SelectTieTest() {
		List<Tie> record = this.TieMapper.selecttie();
		assertNotNull(record);
	}
	
	@Test
	public void SelectMyTieTest() {
		Tie tie = new Tie();
		tie.setUserid(90);
		List<Tie> record = this.TieMapper.selectmytie(tie);
		assertNotNull(record);
	}
	

	@Test
	public void selectPageList() {
		Page page = new Page();
		page.setKeyWord("管理员提问");
		page.setPage(1);
		page.setRows(10);
		List<Tie> record = this.TieMapper.selectPageList(page);
		assertNotNull(record);
	}
	
	@Test
	public void SelectPageCountTest() {
		Page page = new Page();
		page.setKeyWord("管理员提问");
		Integer record = this.TieMapper.selectPageCount(page);
		Integer Expected = 1;
		assertEquals(Expected,record);
	}
	
	@Test
	public void SelectPageListUseDycTest() {
		Tie tie = new Tie();
		tie.setTietitle("管理员提问");
		tie.setTiecontext("管理员提问");
		
		Page page = new Page();
		page.setPage(1);
		page.setRows(10);
		page.setParamEntity(tie);
		List<Tie> record = this.TieMapper.selectPageList(page);
		assertNotNull(record);
	}
	
	@Test
	public void SelectPageCountUseDycTest() {
		Tie tie = new Tie();
		tie.setTietitle("管理员提问");
		tie.setTiecontext("管理员提问");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("tietitle",tie.getTietitle());
		map.put("tiecontext",tie.getTiecontext());
		
		Page page = new Page();
		page.setParamEntity(map);
		Integer record = this.TieMapper.selectPageCountUseDyc(page);
		Integer Expected = 1;
		assertEquals(Expected,record);
	
	}
	
	@Test
	public void DeleteListTest() {
		String[] arr = {"21","22"};
		Integer record = this.TieMapper.deleteList(arr);
		Integer Expected = 2;
		assertEquals(Expected,record);
	}
	
}
