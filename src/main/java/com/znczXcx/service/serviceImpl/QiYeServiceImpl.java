package com.znczXcx.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class QiYeServiceImpl implements QiYeService {

	@Autowired
	private QiYeMapper qiYeDao;

	public int add(QiYe qy) {
		// TODO Auto-generated method stub
		return qiYeDao.add(qy);
	}

	public boolean checkQyhIfExist(String qyh) {
		// TODO Auto-generated method stub
		int count=qiYeDao.getCountByQyh(qyh);
		return count==0?false:true;
	}
}
