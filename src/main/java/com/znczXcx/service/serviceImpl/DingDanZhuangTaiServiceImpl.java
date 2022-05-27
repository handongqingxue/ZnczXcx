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
	public int addToYf(List<DingDanZhuangTai> ddztList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (DingDanZhuangTai ddzt : ddztList) {
			DingDanZhuangTai dingDanZhuangTai=ddzt;
			dingDanZhuangTai.setQyjlId(ddzt.getId());
			dingDanZhuangTai.setMc(ddzt.getMc());
			dingDanZhuangTai.setPx(ddzt.getPx());
			dingDanZhuangTai.setQytb(Main.YI_TONG_BU);
			dingDanZhuangTai.setQyh(qyh);
			count+=dingDanZhuangTaiDao.add(dingDanZhuangTai);
		}
		return count;
	}
}
