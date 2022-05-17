package com.znczXcx.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.service.*;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private GuoBangJiLuMapper guoBangJiLuDao;

	public boolean createTabByQyh(String qyh) {
		// TODO Auto-generated method stub
		boolean bool=false;
		int count=guoBangJiLuDao.createTabByQyh(qyh);
		return bool;
	}
}
