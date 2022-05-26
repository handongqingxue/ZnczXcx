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

	public int addToYf(List<DingDan> ddList, String qyh) {
		// TODO Auto-generated method stub
		int count=0;
		for (DingDan dd : ddList) {
			DingDan dingDan=dd;
			dingDan.setQyjlId(dd.getId());
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
