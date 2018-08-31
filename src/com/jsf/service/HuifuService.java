package com.jsf.service;


import java.util.List;

import com.jsf.entity.Huifu;



public interface HuifuService extends BaseService<Huifu>{
	public List<Huifu> selecthuifu() throws Exception;
}
