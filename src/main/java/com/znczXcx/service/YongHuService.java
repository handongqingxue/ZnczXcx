package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface YongHuService {

	int syncToYf(List<YongHu> yhList, String qyh);

	boolean checkIfWtbToYf(String qyh);

	List<YongHu> selectListByQytb(Integer qytb, String qyh);

	int updateTbZtByQytb(int qytb, int xtbzt, String qyh);

	YongHu login(String yhm, String mm, String qyh);
}
