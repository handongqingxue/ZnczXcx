package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class YunShuShangServiceImpl implements YunShuShangService {

	@Autowired
	private YunShuShangMapper yunShuShangDao;

	@Override
	public int syncToYf(List<YunShuShang> yssList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (YunShuShang yss : yssList) {
			YunShuShang yunShuShang=yss;
			yunShuShang.setQyjlId(yss.getId());
			yunShuShang.setMc(yss.getMc());
			yunShuShang.setBjsj(yss.getBjsj());
			yunShuShang.setQytb(Main.YI_TONG_BU);
			yunShuShang.setQyh(qyh);
			
		    if(yunShuShangDao.getCountByQyjlId(yunShuShang.getQyjlId(),qyh)==0)
		    	count+=yunShuShangDao.add(yunShuShang);
		    else
		    	count+=yunShuShangDao.edit(yunShuShang);
		}
		return count;
	}
}
