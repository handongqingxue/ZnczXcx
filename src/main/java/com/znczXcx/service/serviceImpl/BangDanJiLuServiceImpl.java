package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class BangDanJiLuServiceImpl implements BangDanJiLuService {
	@Autowired
	private BangDanJiLuMapper bangDanJiLuDao;
	@Autowired
	private MainMapper mainDao;

	public int addToYf(List<BangDanJiLu> bdjlList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (BangDanJiLu bdjl : bdjlList) {
			BangDanJiLu bangDanJiLu=bdjl;
			bangDanJiLu.setQyjlId(bdjl.getId());
			Object yfwDdIdObj = mainDao.getYfwColValByQyColVal("id", bdjl.getQyDdId()+"", "qyjlId", "ding_dan", "yuejiazhuang");
			if(yfwDdIdObj!=null) {
				Integer yfwDdId=Integer.valueOf(yfwDdIdObj.toString());
				bangDanJiLu.setYfwDdId(yfwDdId);
			}
			bangDanJiLu.setQytb(Main.YI_TONG_BU);
			bangDanJiLu.setQyh(qyh);
			
		    if(bangDanJiLuDao.getCountByQyjlId(bangDanJiLu.getQyjlId(),qyh)==0)
		    	count+=bangDanJiLuDao.add(bangDanJiLu);
		    else
		    	count+=bangDanJiLuDao.edit(bangDanJiLu);
		}
		return count;
	}

}
