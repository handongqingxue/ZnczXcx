package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class ShenHeJiLuServiceImpl implements ShenHeJiLuService {
	@Autowired
	private ShenHeJiLuMapper shenHeJiLuDao;
	@Autowired
	private MainMapper mainDao;

	@Override
	public int syncToYf(List<ShenHeJiLu> shjlList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (ShenHeJiLu shjl : shjlList) {
			ShenHeJiLu shenHeJiLu=shjl;
			shenHeJiLu.setQyjlId(shjl.getId());
			Object yfwDdIdObj = mainDao.getYfwColValByQyColVal("id", shjl.getQyDdId()+"", "qyjlId", "ding_dan", "yuejiazhuang");
			if(yfwDdIdObj!=null) {
				Integer yfwDdId=Integer.valueOf(yfwDdIdObj.toString());
				shenHeJiLu.setYfwDdId(yfwDdId);
			}
			shenHeJiLu.setQytb(Main.YI_TONG_BU);
			shenHeJiLu.setQyh(qyh);
			
		    if(shenHeJiLuDao.getCountByQyjlId(shenHeJiLu.getQyjlId(),qyh)==0)
		    	count+=shenHeJiLuDao.add(shenHeJiLu);
		    else
		    	count+=shenHeJiLuDao.edit(shenHeJiLu);
		}
		return count;
	}

}
