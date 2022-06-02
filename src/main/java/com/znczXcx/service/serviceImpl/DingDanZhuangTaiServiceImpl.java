package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class DingDanZhuangTaiServiceImpl implements DingDanZhuangTaiService {

	@Autowired
	private DingDanZhuangTaiMapper dingDanZhuangTaiDao;

	@Override
	public int syncToYf(List<DingDanZhuangTai> ddztList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (DingDanZhuangTai ddzt : ddztList) {
			DingDanZhuangTai dingDanZhuangTai=ddzt;
			dingDanZhuangTai.setQyjlId(ddzt.getId());
			dingDanZhuangTai.setMc(ddzt.getMc());
			dingDanZhuangTai.setPx(ddzt.getPx());
			dingDanZhuangTai.setQytb(Main.YI_TONG_BU);
			dingDanZhuangTai.setQyh(qyh);
			
		    if(dingDanZhuangTaiDao.getCountByQyjlId(dingDanZhuangTai.getQyjlId(),qyh)==0)
		    	count+=dingDanZhuangTaiDao.add(dingDanZhuangTai);
		    else
		    	count+=dingDanZhuangTaiDao.edit(dingDanZhuangTai);
		}
		return count;
	}

	@Override
	public boolean checkIfWtbToYf(String qyh) {
		// TODO Auto-generated method stub
		int count=dingDanZhuangTaiDao.getWtbToYfCount(qyh);
		return count>0?true:false;
	}

	@Override
	public List<DingDanZhuangTai> selectListByQytb(Integer qytb, String qyh) {
		// TODO Auto-generated method stub
		return dingDanZhuangTaiDao.selectListByQytb(qytb, qyh);
	}

	@Override
	public int updateTbZtByQytb(int qytb, int xtbzt, String qyh) {
		// TODO Auto-generated method stub
		return dingDanZhuangTaiDao.updateTbZtByQytb(qytb, xtbzt, qyh);
	}
}
