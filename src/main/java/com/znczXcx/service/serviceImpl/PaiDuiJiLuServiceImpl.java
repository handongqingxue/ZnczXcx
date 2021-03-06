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
			updateDDZTById(pdjl.getYfwDdId(),qyh);
		}
		return count;
	}

	public boolean checkIfExist(Integer yfwDdId,String qyh) {
		// TODO Auto-generated method stub
		return paiDuiJiLuDao.getCountByDdIdZt(yfwDdId,PaiDuiJiLu.PAI_DUI_ZHONG,qyh)==0?false:true;
	}

	public int updatePhdByDdId(Integer yfwDdId,String qyh) {
		// TODO Auto-generated method stub
		Integer lastPdh=paiDuiJiLuDao.getTodayLastPdh(qyh);
		lastPdh=lastPdh==null?0:lastPdh;
		int count=paiDuiJiLuDao.updatePhdByDdId(++lastPdh,yfwDdId,qyh);
		if(count>0) {
			updateDDZTById(yfwDdId,qyh);
		}
		return count;
	}
	
	public void updateDDZTById(Integer yfwDdId, String qyh) {
		DingDan dd=new DingDan();
		dd.setId(yfwDdId);
		int ddztId=dingDanZhuangTaiDao.getIdByMc(DingDanZhuangTai.ZHI_JIAN_PAI_DUI_ZHONG_TEXT,qyh);
		dd.setYfwDdztId(ddztId);
		//??????????????????id
		Object qyDdztIdObj = mainDao.getYfwColValByQyColVal("qyjlId", dd.getYfwDdztId()+"", "id", "ding_dan_zhuang_tai", qyh);
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
		PaiDuiJiLu pdjl=paiDuiJiLuDao.selectByDdIdZt(ddId, PaiDuiJiLu.PAI_DUI_ZHONG, qyh);
		int qmsl=paiDuiJiLuDao.getQmslByPdh(pdjl.getPdh(),qyh);
		pdjl.setQmsl(qmsl);
		return pdjl;
	}

	@Override
	public boolean checkIfWtbToYf(String qyh) {
		// TODO Auto-generated method stub
		int count=paiDuiJiLuDao.getWtbToYfCount(qyh);
		return count>0?true:false;
	}

	@Override
	public List<PaiDuiJiLu> selectListByQytb(Integer qytb, String qyh) {
		// TODO Auto-generated method stub
		return paiDuiJiLuDao.selectListByQytb(qytb, qyh);
	}

	@Override
	public int updateTbZtByQytb(Integer qytb, Integer xtbzt, String qyh) {
		// TODO Auto-generated method stub
		return paiDuiJiLuDao.updateTbZtByQytb(qytb, xtbzt, qyh);
	}

	@Override
	public int syncToYf(List<PaiDuiJiLu> pdjlList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (PaiDuiJiLu pdjl : pdjlList) {
			PaiDuiJiLu paiDuiJiLu=pdjl;
			paiDuiJiLu.setQyjlId(pdjl.getId());
			Object yfwDdIdObj = mainDao.getYfwColValByQyColVal("id", pdjl.getQyDdId()+"", "qyjlId", "ding_dan", qyh);
			if(yfwDdIdObj!=null) {
				Integer yfwDdId=Integer.valueOf(yfwDdIdObj.toString());
				paiDuiJiLu.setYfwDdId(yfwDdId);
			}
			paiDuiJiLu.setQytb(Main.YI_TONG_BU);
			paiDuiJiLu.setQyh(qyh);
			
		    if(paiDuiJiLuDao.getCountByQyjlId(paiDuiJiLu.getQyjlId(),qyh)==0)
		    	count+=paiDuiJiLuDao.add(paiDuiJiLu);
		    else
		    	count+=paiDuiJiLuDao.edit(paiDuiJiLu);
		}
		return count;
	}
}
