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
	private MainMapper mainDao;

	public int addToYf(List<DingDan> ddList, String qyh) {
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
			Object yfwWzlxIdObj = mainDao.getYfwColValByQyColVal("yfwWzlxId", dd.getQyWzlxId()+"", "qyWzlxId", "yun_shu_shang", "yuejiazhuang");
			if(yfwWzlxIdObj!=null) {
				Integer yfwWzlxId=Integer.valueOf(yfwWzlxIdObj.toString());
				dingDan.setYfwWzlxId(yfwWzlxId);
			}

			//获取云服务端物资id
			Object yfwWzIdObj = mainDao.getYfwColValByQyColVal("yfwWzId", dd.getQyWzId()+"", "qyWzId", "yun_shu_shang", "yuejiazhuang");
			if(yfwWzIdObj!=null) {
				Integer yfwWzId=Integer.valueOf(yfwWzIdObj.toString());
				dingDan.setYfwWzId(yfwWzId);
			}
			
			//获取云服务端运输商id
			Object yfwYssIdObj = mainDao.getYfwColValByQyColVal("yfwYssId", dd.getQyYssId()+"", "qyYssId", "yun_shu_shang", "yuejiazhuang");
			if(yfwYssIdObj!=null) {
				Integer yfwYssId=Integer.valueOf(yfwYssIdObj.toString());
				dingDan.setYfwYssId(yfwYssId);
			}
			
			//获取云服务端发货单位id
			Object yfwFhdwIdObj = mainDao.getYfwColValByQyColVal("yfwFhdwId", dd.getQyFhdwId()+"", "qyFhdwId", "yun_shu_shang", "yuejiazhuang");
			if(yfwFhdwIdObj!=null) {
				Integer yfwFhdwId=Integer.valueOf(yfwFhdwIdObj.toString());
				dingDan.setYfwFhdwId(yfwFhdwId);
			}
			
			//获取云服务端收货部门id
			Object yfwShbmIdObj = mainDao.getYfwColValByQyColVal("yfwShbmId", dd.getQyFhdwId()+"", "qyShbmId", "yun_shu_shang", "yuejiazhuang");
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
		    
			count+=dingDanDao.add(dingDan);
		}
		return count;
	}

	@Override
	public DingDan selectByDdh(String ddh, String qyh) {
		// TODO Auto-generated method stub
		return dingDanDao.selectByDdh(ddh, qyh);
	}

}
