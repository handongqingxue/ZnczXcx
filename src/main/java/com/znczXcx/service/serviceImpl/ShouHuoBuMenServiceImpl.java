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
}
