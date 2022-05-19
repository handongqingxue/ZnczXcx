package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class ZhiJianJiLuServiceImpl implements ZhiJianJiLuService {

	@Autowired
	private ZhiJianJiLuMapper zhiJianJiLuDao;

	public int add(ZhiJianJiLu zjjl) {
		// TODO Auto-generated method stub
		return zhiJianJiLuDao.add(zjjl);
	}

	public boolean checkIfTbZt(String qyh, Integer qytb) {
		// TODO Auto-generated method stub
		return zhiJianJiLuDao.getTbZtCount(qyh, qytb)>0?true:false;
	}

	public List<ZhiJianJiLu> selectListByQytb(String qyh, Integer qytb) {
		// TODO Auto-generated method stub
		return zhiJianJiLuDao.selectListByQytb(qyh, qytb);
	}

	public int updateTbZtByQytb(String qyh, int qytb, int xtbzt) {
		// TODO Auto-generated method stub
		return zhiJianJiLuDao.updateTbZtByQytb(qyh, qytb, xtbzt);
	}

	public int updateToYtb(String qyh) {
		// TODO Auto-generated method stub
		return zhiJianJiLuDao.updateToYtb(qyh);
	}
}
