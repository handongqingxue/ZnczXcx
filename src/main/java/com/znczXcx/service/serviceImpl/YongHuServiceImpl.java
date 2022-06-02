package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class YongHuServiceImpl implements YongHuService {

	@Autowired
	private YongHuMapper yongHuDao;

	@Override
	public int syncToYf(List<YongHu> yhList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (YongHu yh : yhList) {
			YongHu yongHu=yh;
			yongHu.setQyjlId(yh.getId());
			yongHu.setYhm(yh.getYhm());
			yongHu.setMm(yh.getMm());
			yongHu.setZsxm(yh.getZsxm());
			yongHu.setCjsj(yh.getCjsj());
			yongHu.setCheck(yh.getCheck());
			yongHu.setJs(yh.getJs());
			yongHu.setQxIds(yh.getQxIds());
			yongHu.setQytb(Main.YI_TONG_BU);
			yongHu.setQyh(qyh);
			
		    if(yongHuDao.getCountByQyjlId(yongHu.getQyjlId(),qyh)==0)
		    	count+=yongHuDao.add(yongHu);
		    else
		    	count+=yongHuDao.edit(yongHu);
		}
		return count;
	}

	@Override
	public boolean checkIfWtbToYf(String qyh) {
		// TODO Auto-generated method stub
		int count=yongHuDao.getWtbToYfCount(qyh);
		return count>0?true:false;
	}

	@Override
	public List<YongHu> selectListByQytb(Integer qytb, String qyh) {
		// TODO Auto-generated method stub
		return yongHuDao.selectListByQytb(qytb, qyh);
	}

	@Override
	public int updateTbZtByQytb(int qytb, int xtbzt, String qyh) {
		// TODO Auto-generated method stub
		return yongHuDao.updateTbZtByQytb(qytb, xtbzt, qyh);
	}
}
