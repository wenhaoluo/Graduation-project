package com.jsf.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsf.dao.JsclassMapper;

import com.jsf.entity.Jsclass;
import com.jsf.entity.Page;

import com.jsf.service.JsclassService;


@Service("jsclassService")
public class JsclassServiceImpl implements JsclassService{
	@Autowired
	private JsclassMapper jsclassMapper;

	@Override
	public int insert(Jsclass entity) throws Exception {
		// TODO Auto-generated method stub
		return jsclassMapper.insert(entity);
	}

	@Override
	public int delete(Jsclass entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Jsclass entity) throws Exception {
		// TODO Auto-generated method stub
		return jsclassMapper.update(entity);
	}

	@Override
	public Jsclass select(Jsclass entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int deleteList(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return jsclassMapper.deleteList(pks);
	}

	@Override
	public Page<Jsclass> selectPage(Page<Jsclass> page) {
		// TODO Auto-generated method stub
		page.setList(jsclassMapper.selectPageList(page));
		page.setTotalRecord(jsclassMapper.selectPageCount(page));
		return page;
	}

	@Override
	public Page<Jsclass> selectPageUseDyc(Page<Jsclass> page) {
		// TODO Auto-generated method stub
		page.setList(jsclassMapper.selectPageListUseDyc(page));
		page.setTotalRecord(jsclassMapper.selectPageCountUseDyc(page));
		return page;
	}


}
