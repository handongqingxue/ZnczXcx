package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface ZhiJianJiLuService {

	int add(ZhiJianJiLu zjjl);

	boolean checkIfTbZt(String qyh, Integer qytb);

	List<ZhiJianJiLu> selectListByQytb(String qyh, Integer qytb);

	int updateTbZtByQytb(String qyh, int qytb, int xtbzt);

	boolean checkIfWtbToYf(String qyh);

	List<ZhiJianJiLu> selectListByQytb(Integer qytb, String qyh);

	int updateTbZtByQytb(Integer qytb, Integer xtbzt, String qyh);

	int syncToYf(List<ZhiJianJiLu> zjjlList, String qyh);

	List<ZhiJianJiLu> queryList(Integer jg, String ddh, Integer ddztId, String zjyZsxm, String qyh);

}
