package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class ShouHuoBuMenServiceImpl implements ShouHuoBuMenService {

	@Autowired
	private ShouHuoBuMenMapper shouHuoBuMenDao;

	@Override
	public int syncToYf(List<ShouHuoBuMen> shbmList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (ShouHuoBuMen shbm : shbmList) {
			ShouHuoBuMen shouHuoBuMen=shbm;
			shouHuoBuMen.setQyjlId(shbm.getId());
			shouHuoBuMen.setMc(shbm.getMc());
			shouHuoBuMen.setBjsj(shbm.getBjsj());
			shouHuoBuMen.setQytb(Main.YI_TONG_BU);
			shouHuoBuMen.setQyh(qyh);
			
		    if(shouHuoBuMenDao.getCountByQyjlId(shouHuoBuMen.getQyjlId(),qyh)==0)
		    	count+=shouHuoBuMenDao.add(shouHuoBuMen);
		    else
		    	count+=shouHuoBuMenDao.edit(shouHuoBuMen);
		}
		return count;
	}

	@Override
	public boolean checkIfWtbToYf(String qyh) {
		// TODO Auto-generated method stub
		int count=shouHuoBuMenDao.getWtbToYfCount(qyh);
		return count>0?true:false;
	}

	@Override
	public List<ShouHuoBuMen> selectListByQytb(Integer qytb, String qyh) {
		// TODO Auto-generated method stub
		return shouHuoBuMenDao.selectListByQytb(qytb, qyh);
	}

	@Override
	public int updateTbZtByQytb(Integer qytb, Integer xtbzt, String qyh) {
		// TODO Auto-generated method stub
		return shouHuoBuMenDao.updateTbZtByQytb(qytb, xtbzt, qyh);
	}
}
