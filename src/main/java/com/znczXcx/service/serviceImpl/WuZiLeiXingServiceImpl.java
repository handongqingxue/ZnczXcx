package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class WuZiLeiXingServiceImpl implements WuZiLeiXingService {

	@Autowired
	private WuZiLeiXingMapper wuZiLeiXingDao;

	@Override
	public int syncToYf(List<WuZiLeiXing> wzlxList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (WuZiLeiXing wzlx : wzlxList) {
			WuZiLeiXing wuZiLeiXing=wzlx;
			wuZiLeiXing.setQyjlId(wzlx.getId());
			wuZiLeiXing.setMc(wzlx.getMc());
			wuZiLeiXing.setCjsj(wzlx.getCjsj());
			wuZiLeiXing.setBjsj(wzlx.getBjsj());
			wuZiLeiXing.setPx(wzlx.getPx());
			wuZiLeiXing.setBz(wzlx.getBz());
			wuZiLeiXing.setQytb(Main.YI_TONG_BU);
			wuZiLeiXing.setQyh(qyh);
			
		    if(wuZiLeiXingDao.getCountByQyjlId(wuZiLeiXing.getQyjlId(),qyh)==0)
		    	count+=wuZiLeiXingDao.add(wuZiLeiXing);
		    else
		    	count+=wuZiLeiXingDao.edit(wuZiLeiXing);
		}
		return count;
	}

	@Override
	public boolean checkIfWtbToYf(String qyh) {
		// TODO Auto-generated method stub
		int count=wuZiLeiXingDao.getWtbToYfCount(qyh);
		return count>0?true:false;
	}

	@Override
	public List<WuZiLeiXing> selectListByQytb(Integer qytb, String qyh) {
		// TODO Auto-generated method stub
		return wuZiLeiXingDao.selectListByQytb(qytb, qyh);
	}

	@Override
	public int updateTbZtByQytb(int qytb, int xtbzt, String qyh) {
		// TODO Auto-generated method stub
		return wuZiLeiXingDao.updateTbZtByQytb(qytb, xtbzt, qyh);
	}
}
