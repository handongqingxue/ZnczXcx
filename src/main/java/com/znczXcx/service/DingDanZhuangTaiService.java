package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface DingDanZhuangTaiService {

	int syncToYf(List<DingDanZhuangTai> ddztList, String qyh);

	boolean checkIfWtbToYf(String qyh);

	List<DingDanZhuangTai> selectListByQytb(Integer qytb, String qyh);

	int updateTbZtByQytb(int qytb, int xtbzt, String qyh);

}
