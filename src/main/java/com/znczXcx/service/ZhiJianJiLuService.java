package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface ZhiJianJiLuService {

	int add(ZhiJianJiLu zjjl);

	boolean checkIfTbZt(String qyh, Integer qytb);

	List<ZhiJianJiLu> selectListByQytb(String qyh, Integer qytb);

	int updateTbZtByQytb(String qyh, int qytb, int xtbzt);

	int updateToYtb(String qyh);

}
