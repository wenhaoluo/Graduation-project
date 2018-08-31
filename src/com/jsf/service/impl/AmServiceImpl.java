package com.jsf.service.impl;


import org.springframework.stereotype.Service;


import com.jsf.entity.Am;
import com.jsf.service.AmService;


@Service("AmService")
public class AmServiceImpl extends BaseServiceImpl<Am> implements AmService{

	@Override
	public Am login(Am am) {
		// TODO Auto-generated method stub
		return amMapper.login(am);
	}



}
