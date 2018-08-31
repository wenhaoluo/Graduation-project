package com.jsf.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsf.dao.TieMapper;
import com.jsf.entity.Page;
import com.jsf.entity.Tie;
import com.jsf.service.TieService;


@Service("tieService")
public class TieServiceImpl extends BaseServiceImpl<Tie> implements TieService{

	@Override
	public List<Tie> selecttie() throws Exception {
		// TODO Auto-generated method stub
		return tieMapper.selecttie();
	}

	@Override
	public List<Tie> selectmytie(Tie tie) throws Exception {
		// TODO Auto-generated method stub
		return tieMapper.selectmytie(tie);
	}
	


	
}
