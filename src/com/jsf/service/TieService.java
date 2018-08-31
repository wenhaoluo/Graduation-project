package com.jsf.service;


import java.util.List;

import com.jsf.entity.Tie;


public interface TieService extends BaseService<Tie>{
	public List<Tie> selecttie() throws Exception;
	public List<Tie> selectmytie(Tie tie) throws Exception;
}
