package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface WuZiLeiXingService {

	int syncToYf(List<WuZiLeiXing> wzlxList, String qyh);

	boolean checkIfWtbToYf(String qyh);

	List<WuZiLeiXing> selectListByQytb(Integer qytb, String qyh);

	int updateTbZtByQytb(int qytb, int xtbzt, String qyh);

}
