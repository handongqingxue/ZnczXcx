package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class PaiDuiJiLuServiceImpl implements PaiDuiJiLuService {

	@Autowired
	private MainMapper mainDao;
	@Autowired
	private PaiDuiJiLuMapper paiDuiJiLuDao;
	@Autowired
	private DingDanMapper dingDanDao;
	@Autowired
	private DingDanZhuangTaiMapper dingDanZhuangTaiDao;

	public boolean checkIfTbZt(String qyh, Integer qytb) {
		// TODO Auto-generated method stub
		return paiDuiJiLuDao.getTbZtCount(qyh, qytb)>0?true:false;
	}

	public List<PaiDuiJiLu> selectListByQytb(String qyh, Integer qytb) {
		// TODO Auto-generated method stub
		return paiDuiJiLuDao.selectListByQytb(qyh, qytb);
	}

	public int updateTbZtByQytb(String qyh, int qytb, int xtbzt) {
		// TODO Auto-generated method stub
		return paiDuiJiLuDao.updateTbZtByQytb(qyh, qytb, xtbzt);
	}

	public int updateToYtb(String qyh) {
		// TODO Auto-generated method stub
		return paiDuiJiLuDao.updateToYtb(qyh);
	}

	public int add(PaiDuiJiLu pdjl) {
		// TODO Auto-generated method stub
		String qyh = pdjl.getQyh();
		Integer lastDlh=paiDuiJiLuDao.getTodayLastDlh(qyh);
		lastDlh=lastDlh==null?0:lastDlh;
		lastDlh++;
		Integer lastPdh=paiDuiJiLuDao.getTodayLastPdh(qyh);
		lastPdh=lastPdh==null?0:lastPdh;
		lastPdh++;
		pdjl.setDlh(lastDlh);
		pdjl.setPdh(lastPdh);
		int count=paiDuiJiLuDao.add(pdjl);
		if(count>0) {
			updateDDZTById(pdjl.getDdId(),qyh);
		}
		return count;
	}

	public boolean checkIfExist(Integer ddId,String qyh) {
		// TODO Auto-generated method stub
		return paiDuiJiLuDao.getCountByDdIdZt(ddId,PaiDuiJiLu.PAI_DUI_ZHONG,qyh)==0?false:true;
	}

	public int updatePhdByDdId(Integer ddId,String qyh) {
		// TODO Auto-generated method stub
		Integer lastPdh=paiDuiJiLuDao.getTodayLastPdh(qyh);
		lastPdh=lastPdh==null?0:lastPdh;
		int count=paiDuiJiLuDao.updatePhdByDdId(++lastPdh,ddId,qyh);
		if(count>0) {
			updateDDZTById(ddId,qyh);
		}
		return count;
	}
	
	public void updateDDZTById(Integer ddId, String qyh) {
		DingDan dd=new DingDan();
		dd.setId(ddId);
		int ddztId=dingDanZhuangTaiDao.getIdByMc(DingDanZhuangTai.ZHI_JIAN_PAI_DUI_ZHONG_TEXT,qyh);
		dd.setYfwDdztId(ddztId);
		//获取企业端订单状态id
		Object qyDdztIdObj = mainDao.getYfwColValByQyColVal("qyjlId", dd.getYfwDdztId()+"", "id", "ding_dan_zhuang_tai", "yuejiazhuang");
		if(qyDdztIdObj!=null) {
			Integer qyDdztId=Integer.valueOf(qyDdztIdObj.toString());
			dd.setQyDdztId(qyDdztId);
		}
		dd.setQytb(Main.WEI_TONG_BU);
		dd.setQyh(qyh);
		dingDanDao.editById(dd);
	}

	@Override
	public PaiDuiJiLu selectByDdId(Integer ddId, String qyh) {
		// TODO Auto-generated method stub
		PaiDuiJiLu pdjl=paiDuiJiLuDao.selectByDdId(ddId, qyh);
		int qmsl=paiDuiJiLuDao.getQmslByPdh(pdjl.getPdh(),qyh);
		pdjl.setQmsl(qmsl);
		return pdjl;
	}
}
