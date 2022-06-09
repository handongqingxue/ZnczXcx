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
			dd.setId(zjjl.getYfwDdId());
			int yfwDdztId = 0;
			if(zjjl.getJg()==ZhiJianJiLu.HE_GE) {
				yfwDdztId = dingDanZhuangTaiDao.getIdByMc(DingDanZhuangTai.YI_JIAN_PAI_DUI_ZHONG_TEXT, zjjl.getQyh());
			}
			else if(zjjl.getJg()==ZhiJianJiLu.BU_HE_GE) {
				yfwDdztId = dingDanZhuangTaiDao.getIdByMc(DingDanZhuangTai.DAI_ZHI_JIAN_TEXT, zjjl.getQyh());
			}
			dd.setYfwDdztId(yfwDdztId);
			
			//获取企业订单状态id
			Object qyDdztIdObj = mainDao.getYfwColValByQyColVal("qyjlId", dd.getYfwDdztId()+"", "id", "ding_dan_zhuang_tai", "yuejiazhuang");
			if(qyDdztIdObj!=null) {
				Integer qyDdztId=Integer.valueOf(qyDdztIdObj.toString());
				dd.setQyDdztId(qyDdztId);
			}
			dd.setQyh(zjjl.getQyh());
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

	@Override
	public boolean checkIfWtbToYf(String qyh) {
		// TODO Auto-generated method stub
		int count=zhiJianJiLuDao.getWtbToYfCount(qyh);
		return count>0?true:false;
	}

	@Override
	public List<ZhiJianJiLu> selectListByQytb(Integer qytb, String qyh) {
		// TODO Auto-generated method stub
		return zhiJianJiLuDao.selectListByQytb(qytb, qyh);
	}

	@Override
	public int updateTbZtByQytb(Integer qytb, Integer xtbzt, String qyh) {
		// TODO Auto-generated method stub
		return zhiJianJiLuDao.updateTbZtByQytb(qyh, qytb, xtbzt);
	}

	@Override
	public int syncToYf(List<ZhiJianJiLu> zjjlList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (ZhiJianJiLu zjjl : zjjlList) {
			ZhiJianJiLu zhiJianJiLu=zjjl;
			zhiJianJiLu.setQyjlId(zjjl.getId());
			Object yfwDdIdObj = mainDao.getYfwColValByQyColVal("id", zjjl.getQyDdId()+"", "qyjlId", "ding_dan", "yuejiazhuang");
			if(yfwDdIdObj!=null) {
				Integer yfwDdId=Integer.valueOf(yfwDdIdObj.toString());
				zhiJianJiLu.setYfwDdId(yfwDdId);
			}
			zhiJianJiLu.setQytb(Main.YI_TONG_BU);
			zhiJianJiLu.setQyh(qyh);
			
		    if(zhiJianJiLuDao.getCountByQyjlId(zhiJianJiLu.getQyjlId(),qyh)==0)
		    	count+=zhiJianJiLuDao.add(zhiJianJiLu);
		    else
		    	count+=zhiJianJiLuDao.edit(zhiJianJiLu);
		}
		return count;
	}
}
