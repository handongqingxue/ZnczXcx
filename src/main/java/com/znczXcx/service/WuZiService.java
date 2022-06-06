package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface WuZiService {

	int syncToYf(List<WuZi> wzList, String qyh);

	boolean checkIfWtbToYf(String qyh);

	List<WuZi> selectListByQytb(Integer qytb, String qyh);

	int updateTbZtByQytb(int qytb, int xtbzt, String qyh);

}
