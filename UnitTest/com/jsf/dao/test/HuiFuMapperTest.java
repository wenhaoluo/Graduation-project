package com.jsf.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.jsf.dao.HuifuMapper;
import com.jsf.entity.Huifu;
import com.jsf.entity.Page;

@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) //配置事务回滚
@Transactional			//事务管理
public class HuiFuMapperTest {
	@Autowired
	private HuifuMapper HuiFuMapper;
	
	private static String xmlPath = "classpath:applicationContext.xml";
	
	@Before
	public void setUp() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		HuiFuMapper = applicationContext.getBean(HuifuMapper.class);
	}
	
	@Test
	public void InsertHuiFuTest() {
		Huifu HuiFu = new Huifu();
		HuiFu.setHfid(100);
		HuiFu.setHfauthor("单元测试人员1");
		HuiFu.setHfcontext("单元回复内容1");
		HuiFu.setHfdate("2018-02-27 10:01:30");
		HuiFu.setTieid(22);
		HuiFu.setUserid(90);
		Integer record = this.HuiFuMapper.insert(HuiFu);
		Integer Expected = 1;
		assertEquals(Expected,record);
		
	}
	
	@Test
	public void UpdateHuiFuTest() {
		Huifu HuiFu = new Huifu();
		HuiFu.setHfid(100);
		HuiFu.setHfauthor("单元测试人员修改1");
		HuiFu.setHfcontext("单元回复内容修改1");
		HuiFu.setHfdate("2016-12-06 17:10:58");
		HuiFu.setTieid(23);
		HuiFu.setUserid(91);
		Integer record = this.HuiFuMapper.update(HuiFu);
		Integer Expected = 1;
		assertEquals(Expected,record);		
	}
	
//	tietitle参数不存在
	@Test
	@Transactional
	@Ignore
	public void SelectPageListTest() {
		Page page = new Page();
		page.setKeyWord("回复");
		page.setPage(1);
		page.setRows(10);
		List<Huifu> record = this.HuiFuMapper.selectPageList(page);
		assertNotNull(record);
		
	}
	
//	tietitle参数不存在
	@Test
	@Transactional
	@Ignore
	public void SelectPageCountTest() {
		Page page = new Page();
		page.setKeyWord("回复");
		Integer record = this.HuiFuMapper.selectPageCount(page);
		Integer Expected = 3;
		assertEquals(Expected,record);
	}
	
	@Test
	public void SelectHuiFuTest() {
		List<Huifu> record = this.HuiFuMapper.selecthuifu();
		assertNotNull(record);
	}
	
	//没有#{paramEntity.tietitle}，#{paramEntity.tiecontext}
	@Test
	@Transactional
	@Ignore
	public void SelectPageListUseDycTest() {
		Huifu HuiFu = new Huifu();
		HuiFu.setHfauthor("人员");
		HuiFu.setHfcontext("留言");
		
		Page page = new Page();
		page.setStart(0);
		page.setRows(100);
		page.setParamEntity(HuiFu.getHfauthor());
		page.setParamEntity(HuiFu.getHfcontext());
		List<Huifu> record = this.HuiFuMapper.selectPageListUseDyc(page);
		assertNotNull(record);
	}
	
	//没有#{paramEntity.tietitle}，#{paramEntity.tiecontext}
	@Test
	@Transactional
	@Ignore
	public void SelectPageCountUseDycTest() {
		Huifu HuiFu = new Huifu();
		HuiFu.setHfauthor("人员");
		HuiFu.setHfcontext("留言");
		
		Page page = new Page();
		page.setParamEntity(HuiFu.getHfauthor());
		page.setParamEntity(HuiFu.getHfcontext());
		Integer record = this.HuiFuMapper.selectPageCountUseDyc(page);
		Integer Expected = 2;
		assertEquals(Expected,record);
	}
	
	@Test
	public void DeleteListTest() {
		String[] arr = {"21","22","23"};
		Integer record = this.HuiFuMapper.deleteList(arr);
		Integer Expected = 3;
		assertEquals(Expected,record);
	}
	
}
