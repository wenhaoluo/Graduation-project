package com.jsf.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsf.dao.HuifuMapper;
import com.jsf.dao.TieMapper;
import com.jsf.entity.Huifu;
import com.jsf.entity.Page;
import com.jsf.entity.Tie;
import com.jsf.service.HuifuService;
import com.jsf.service.TieService;


@Service("huifuService")
public class HuifuServiceImpl extends BaseServiceImpl<Huifu> implements HuifuService{

	@Override
	public List<Huifu> selecthuifu() throws Exception {
		// TODO Auto-generated method stub
		return huifuMapper.selecthuifu();
	}

	
}
