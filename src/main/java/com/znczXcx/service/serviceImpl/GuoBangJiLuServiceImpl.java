package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class GuoBangJiLuServiceImpl implements GuoBangJiLuService {
	@Autowired
	private GuoBangJiLuMapper guoBangJiLuDao;
	@Autowired
	private MainMapper mainDao;

	public int syncToYf(List<GuoBangJiLu> gbjlList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (GuoBangJiLu gbjl : gbjlList) {
			GuoBangJiLu guoBangJiLu=gbjl;
			guoBangJiLu.setQyjlId(gbjl.getId());
			Object yfwDdIdObj = mainDao.getYfwColValByQyColVal("id", gbjl.getQyDdId()+"", "qyjlId", "ding_dan", qyh);
			if(yfwDdIdObj!=null) {
				Integer yfwDdId=Integer.valueOf(yfwDdIdObj.toString());
				guoBangJiLu.setYfwDdId(yfwDdId);
			}
			guoBangJiLu.setQytb(Main.YI_TONG_BU);
			guoBangJiLu.setQyh(qyh);
			count+=guoBangJiLuDao.add(guoBangJiLu);
		}
		return count;
	}

	@Override
	public boolean checkIfWtbToYf(String qyh) {
		// TODO Auto-generated method stub
		int count=guoBangJiLuDao.getWtbToYfCount(qyh);
		return count>0?true:false;
	}

	@Override
	public List<GuoBangJiLu> selectListByQytb(Integer qytb, String qyh) {
		// TODO Auto-generated method stub
		return guoBangJiLuDao.selectListByQytb(qytb, qyh);
	}

	@Override
	public int updateTbZtByQytb(Integer qytb, Integer xtbzt, String qyh) {
		// TODO Auto-generated method stub
		return guoBangJiLuDao.updateTbZtByQytb(qytb, xtbzt, qyh);
	}
}
