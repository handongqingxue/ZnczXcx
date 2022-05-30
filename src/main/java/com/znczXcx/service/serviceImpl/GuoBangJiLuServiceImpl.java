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
			Object yfwDdIdObj = mainDao.getYfwColValByQyColVal("id", gbjl.getQyDdId()+"", "qyjlId", "ding_dan", "yuejiazhuang");
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
}
