package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class ZhiJianJiLuServiceImpl implements ZhiJianJiLuService {

	@Autowired
	private ZhiJianJiLuMapper zhiJianJiLuDao;
	@Autowired
	private DingDanZhuangTaiMapper dingDanZhuangTaiDao;
	@Autowired
	private DingDanMapper dingDanDao;
	@Autowired
	private MainMapper mainDao;

	public int add(ZhiJianJiLu zjjl) {
		// TODO Auto-generated method stub
		int count=zhiJianJiLuDao.add(zjjl);
		if(count>0) {
			DingDan dd=new DingDan();
			dd.setId(zjjl.getDdId());
			int yfwDdztId = 0;
			if(zjjl.getJg()==ZhiJianJiLu.HE_GE) {
				yfwDdztId = dingDanZhuangTaiDao.getIdByMc(DingDanZhuangTai.YI_JIAN_PAI_DUI_ZHONG_TEXT, zjjl.getQyh());
			}
			else if(zjjl.getJg()==ZhiJianJiLu.BU_HE_GE) {
				yfwDdztId = dingDanZhuangTaiDao.getIdByMc(DingDanZhuangTai.DAI_ZHI_JIAN_TEXT, zjjl.getQyh());
			}
			dd.setYfwDdztId(yfwDdztId);
			
			//��ȡ��ҵ����״̬id
			Object qyDdztIdObj = mainDao.getYfwColValByQyColVal("qyjlId", dd.getYfwDdztId()+"", "id", "ding_dan_zhuang_tai", "yuejiazhuang");
			if(qyDdztIdObj!=null) {
				Integer qyDdztId=Integer.valueOf(qyDdztIdObj.toString());
				dd.setQyDdztId(qyDdztId);
			}
			dingDanDao.editById(dd);
		}
		return count;
	}

	public boolean checkIfTbZt(String qyh, Integer qytb) {
		// TODO Auto-generated method stub
		return zhiJianJiLuDao.getTbZtCount(qyh, qytb)>0?true:false;
	}

	public List<ZhiJianJiLu> selectListByQytb(String qyh, Integer qytb) {
		// TODO Auto-generated method stub
		return zhiJianJiLuDao.selectListByQytb(qyh, qytb);
	}

	public int updateTbZtByQytb(String qyh, int qytb, int xtbzt) {
		// TODO Auto-generated method stub
		return zhiJianJiLuDao.updateTbZtByQytb(qyh, qytb, xtbzt);
	}

	public int updateToYtb(String qyh) {
		// TODO Auto-generated method stub
		return zhiJianJiLuDao.updateToYtb(qyh);
	}
}
