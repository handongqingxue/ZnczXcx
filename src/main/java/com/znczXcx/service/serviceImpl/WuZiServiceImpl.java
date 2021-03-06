package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class WuZiServiceImpl implements WuZiService {

	@Autowired
	private WuZiMapper wuZiDao;

	@Override
	public int syncToYf(List<WuZi> wzList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (WuZi wz : wzList) {
			WuZi wuZi=wz;
			wuZi.setQyjlId(wz.getId());
			wuZi.setMc(wz.getMc());
			wuZi.setBjsj(wz.getBjsj());
			wuZi.setWzlxId(wz.getWzlxId());
			wuZi.setQytb(Main.YI_TONG_BU);
			wuZi.setQyh(qyh);
			
		    if(wuZiDao.getCountByQyjlId(wuZi.getQyjlId(),qyh)==0)
		    	count+=wuZiDao.add(wuZi);
		    else
		    	count+=wuZiDao.edit(wuZi);
		}
		return count;
	}

	@Override
	public boolean checkIfWtbToYf(String qyh) {
		// TODO Auto-generated method stub
		int count=wuZiDao.getWtbToYfCount(qyh);
		return count>0?true:false;
	}

	@Override
	public List<WuZi> selectListByQytb(Integer qytb, String qyh) {
		// TODO Auto-generated method stub
		return wuZiDao.selectListByQytb(qytb, qyh);
	}

	@Override
	public int updateTbZtByQytb(int qytb, int xtbzt, String qyh) {
		// TODO Auto-generated method stub
		return wuZiDao.updateTbZtByQytb(qytb, xtbzt, qyh);
	}

}
