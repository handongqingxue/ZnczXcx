package com.znczXcx.service.serviceImpl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znczXcx.dao.*;
import com.znczXcx.entity.*;
import com.znczXcx.service.*;
import com.znczXcx.util.*;

@Service
public class DingDanServiceImpl implements DingDanService {
	@Autowired
	private DingDanMapper dingDanDao;
	@Autowired
	private DingDanZhuangTaiMapper dingDanZhuangTaiDao;
	@Autowired
	private MainMapper mainDao;

	public int syncToYf(List<DingDan> ddList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (DingDan dd : ddList) {
			DingDan dingDan=dd;
			dingDan.setQyjlId(dd.getId());

			//获取云服务端订单状态id
			Object yfwDdztIdObj = mainDao.getYfwColValByQyColVal("id", dd.getQyDdztId()+"", "qyjlId", "ding_dan_zhuang_tai", "yuejiazhuang");
			if(yfwDdztIdObj!=null) {
				Integer yfwDdztId=Integer.valueOf(yfwDdztIdObj.toString());
				dingDan.setYfwDdztId(yfwDdztId);
			}

			//获取云服务端物资类型id
			Object yfwWzlxIdObj = mainDao.getYfwColValByQyColVal("id", dd.getQyWzlxId()+"", "qyjlId", "wu_zi_lei_xing", "yuejiazhuang");
			if(yfwWzlxIdObj!=null) {
				Integer yfwWzlxId=Integer.valueOf(yfwWzlxIdObj.toString());
				dingDan.setYfwWzlxId(yfwWzlxId);
			}

			//获取云服务端物资id
			Object yfwWzIdObj = mainDao.getYfwColValByQyColVal("id", dd.getQyWzId()+"", "qyjlId", "wu_zi", "yuejiazhuang");
			if(yfwWzIdObj!=null) {
				Integer yfwWzId=Integer.valueOf(yfwWzIdObj.toString());
				dingDan.setYfwWzId(yfwWzId);
			}
			
			//获取云服务端运输商id
			Object yfwYssIdObj = mainDao.getYfwColValByQyColVal("id", dd.getQyYssId()+"", "qyjlId", "yun_shu_shang", "yuejiazhuang");
			if(yfwYssIdObj!=null) {
				Integer yfwYssId=Integer.valueOf(yfwYssIdObj.toString());
				dingDan.setYfwYssId(yfwYssId);
			}
			
			//获取云服务端发货单位id
			Object yfwFhdwIdObj = mainDao.getYfwColValByQyColVal("id", dd.getQyFhdwId()+"", "qyjlId", "fa_huo_dan_wei", "yuejiazhuang");
			if(yfwFhdwIdObj!=null) {
				Integer yfwFhdwId=Integer.valueOf(yfwFhdwIdObj.toString());
				dingDan.setYfwFhdwId(yfwFhdwId);
			}
			
			//获取云服务端收货部门id
			Object yfwShbmIdObj = mainDao.getYfwColValByQyColVal("id", dd.getQyShbmId()+"", "qyjlId", "shou_huo_bu_men", "yuejiazhuang");
			if(yfwShbmIdObj!=null) {
				Integer yfwShbmId=Integer.valueOf(yfwShbmIdObj.toString());
				dingDan.setYfwShbmId(yfwShbmId);
			}
			
			dingDan.setQytb(Main.YI_TONG_BU);
			dingDan.setQyh(qyh);

	    	String ddh = dingDan.getDdh();
			String fileName = ddh + ".jpg";
			File file = new File("D:/resource/ZnczXcx/DDQrcode/"+fileName);
		    //判断文件或文件夹是否存在
		    boolean flag = file.exists();
		    if(!flag) {
				String avaPath="/ZnczXcx/upload/DDQrcode/"+fileName;
				String path = "D:/resource/ZnczXcx/DDQrcode";
		        QrcodeUtil.createQrCode(ddh, path, fileName);
				
		        dingDan.setEwmlj(avaPath);
		    }
		    
		    if(dingDanDao.getCountByQyjlId(dingDan.getQyjlId(),qyh)==0)
		    	count+=dingDanDao.add(dingDan);
		    else
		    	count+=dingDanDao.editByQyjlId(dingDan);
		}
		return count;
	}

	@Override
	public DingDan selectByDdh(String ddh, String qyh) {
		// TODO Auto-generated method stub
		return dingDanDao.selectByDdh(ddh, qyh);
	}

	@Override
	public DingDan getZjpdzByDdh(String ddh, String qyh) {
		// TODO Auto-generated method stub
		int yfwDdztId=dingDanZhuangTaiDao.getIdByMc(DingDanZhuangTai.ZHI_JIAN_PAI_DUI_ZHONG_TEXT,qyh);
		return dingDanDao.selectByYfwDdztIdDdh(yfwDdztId, ddh, qyh);
	}

	@Override
	public boolean checkIfWtbToYf(String qyh) {
		// TODO Auto-generated method stub
		int count=dingDanDao.getWtbToYfCount(qyh);
		return count>0?true:false;
	}

	@Override
	public List<DingDan> selectListByQytb(Integer qytb, String qyh) {
		// TODO Auto-generated method stub
		return dingDanDao.selectListByQytb(qytb, qyh);
	}

	@Override
	public int updateTbZtByQytb(Integer qytb, Integer xtbzt, String qyh) {
		// TODO Auto-generated method stub
		return dingDanDao.updateTbZtByQytb(qytb, xtbzt, qyh);
	}

}
