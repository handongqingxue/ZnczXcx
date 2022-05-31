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
		String qyh = pdjl.getQyh();
		Integer lastDlh=paiDuiJiLuDao.getTodayLastDlh(qyh);
		lastDlh=lastDlh==null?0:lastDlh;
		lastDlh++;
		Integer lastPdh=paiDuiJiLuDao.getTodayLastPdh(qyh);
		lastPdh=lastPdh==null?0:lastPdh;
		lastPdh++;
		pdjl.setDlh(lastDlh);
		pdjl.setPdh(lastPdh);
		return paiDuiJiLuDao.add(pdjl);
	}

	public boolean checkIfExist(Integer ddId,String qyh) {
		// TODO Auto-generated method stub
		return paiDuiJiLuDao.getCountByDdIdZt(ddId,PaiDuiJiLu.PAI_DUI_ZHONG,qyh)==0?false:true;
	}

	public int updatePhdByDdId(Integer ddId,String qyh) {
		// TODO Auto-generated method stub
		Integer lastPdh=paiDuiJiLuDao.getTodayLastPdh(qyh);
		return paiDuiJiLuDao.updatePhdByDdId(++lastPdh,ddId,qyh);
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
