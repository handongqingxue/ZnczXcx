package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface BangDanJiLuService {

	int syncToYf(List<BangDanJiLu> bdjlList, String qyh);

	boolean checkIfWtbToYf(String qyh);

	List<BangDanJiLu> selectListByQytb(Integer qytb, String qyh);

	int updateTbZtByQytb(Integer qytb, Integer xtbzt, String qyh);

}
