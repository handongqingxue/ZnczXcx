package com.znczXcx.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.PaiDuiJiLu;
import com.znczXcx.service.*;

@Service
public class PaiDuiJiLuServiceImpl implements PaiDuiJiLuService {

	@Autowired
	private PaiDuiJiLuMapper paiDuiJiLuDao;

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
		return paiDuiJiLuDao.add(pdjl);
	}

	public boolean checkIfExist(Integer ddId,String qyh) {
		// TODO Auto-generated method stub
		return paiDuiJiLuDao.getCountByDdIdZt(ddId,PaiDuiJiLu.PAI_DUI_ZHONG,qyh)==0?false:true;
	}

	public int updatePhdByDdId(Integer ddId,String qyh) {
		// TODO Auto-generated method stub
		Integer lastPdh=paiDuiJiLuDao.getTodayLastPdh(qyh);
		return paiDuiJiLuDao.updatePhdByDdId(lastPdh++,ddId,qyh);
	}
}
