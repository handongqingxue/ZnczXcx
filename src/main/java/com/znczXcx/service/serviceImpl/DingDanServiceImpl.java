package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class DingDanServiceImpl implements DingDanService {
	@Autowired
	private DingDanMapper dingDanDao;

	public int addToYf(List<DingDan> ddList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (DingDan dd : ddList) {
			DingDan dingDan=dd;
			dingDan.setQyjlId(dd.getId());
			dingDan.setQytb(Main.YI_TONG_BU);
			dingDan.setQyh(qyh);
			count+=dingDanDao.add(dd);
		}
		return count;
	}

}
