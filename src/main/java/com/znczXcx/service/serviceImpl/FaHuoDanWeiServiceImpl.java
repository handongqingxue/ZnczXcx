package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class FaHuoDanWeiServiceImpl implements FaHuoDanWeiService {

	@Autowired
	private FaHuoDanWeiMapper faHuoDanWeiDao;

	@Override
	public int addToYf(List<FaHuoDanWei> fhdwList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (FaHuoDanWei fhdw : fhdwList) {
			FaHuoDanWei faHuoDanWei=fhdw;
			faHuoDanWei.setQyjlId(fhdw.getId());
			faHuoDanWei.setMc(fhdw.getMc());
			faHuoDanWei.setBjsj(fhdw.getBjsj());
			faHuoDanWei.setQytb(Main.YI_TONG_BU);
			faHuoDanWei.setQyh(qyh);
			count+=faHuoDanWeiDao.add(faHuoDanWei);
		}
		return count;
	}
}
