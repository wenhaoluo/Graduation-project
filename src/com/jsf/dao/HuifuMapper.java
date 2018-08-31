package com.jsf.dao;

import java.util.List;

import com.jsf.entity.Huifu;




public interface HuifuMapper extends BaseMapper<Huifu>{
	public List<Huifu> selecthuifu();
}