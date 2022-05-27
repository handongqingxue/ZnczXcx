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
	public int addToYf(List<WuZi> wzList, String qyh) {
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
			count+=wuZiDao.add(wuZi);
		}
		return count;
	}
}
