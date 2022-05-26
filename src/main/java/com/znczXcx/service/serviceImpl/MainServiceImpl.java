package com.znczXcx.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;

@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	private MainMapper mainDao;
	@Autowired
	private YongHuMapper yongHuDao;
	@Autowired
	private YunShuShangMapper yunShuShangDao;
	@Autowired
	private DingDanMapper dingDanDao;
	@Autowired
	private PaiDuiJiLuMapper paiDuiJiLuDao;
	@Autowired
	private ZhiJianJiLuMapper zhiJianJiLuDao;
	@Autowired
	private BangDanJiLuMapper bangDanJiLuDao;
	@Autowired
	private GuoBangJiLuMapper guoBangJiLuDao;

	public boolean createTabByQyh(String qyh) {
		// TODO Auto-generated method stub
		boolean bool=false;
		if(mainDao.getTabCountByTabName(Main.YONG_HU+"_"+qyh)==0)
			yongHuDao.createTabByQyh(qyh);
		if(mainDao.getTabCountByTabName(Main.YUN_SHU_SHANG+"_"+qyh)==0)
			yunShuShangDao.createTabByQyh(qyh);
		if(mainDao.getTabCountByTabName(Main.DING_DAN+"_"+qyh)==0)
			dingDanDao.createTabByQyh(qyh);
		if(mainDao.getTabCountByTabName(Main.PAI_DUI_JI_LU+"_"+qyh)==0)
			paiDuiJiLuDao.createTabByQyh(qyh);
		if(mainDao.getTabCountByTabName(Main.ZHI_JIAN_JI_LU+"_"+qyh)==0)
			zhiJianJiLuDao.createTabByQyh(qyh);
		if(mainDao.getTabCountByTabName(Main.BANG_DAN_JI_LU+"_"+qyh)==0)
			bangDanJiLuDao.createTabByQyh(qyh);
		if(mainDao.getTabCountByTabName(Main.GUO_BANG_JI_LU+"_"+qyh)==0)
			guoBangJiLuDao.createTabByQyh(qyh);
		return bool;
	}
}
