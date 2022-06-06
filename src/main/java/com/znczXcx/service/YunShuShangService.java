package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface YunShuShangService {

	int syncToYf(List<YunShuShang> yssList, String qyh);

	boolean checkIfWtbToYf(String qyh);

	List<YunShuShang> selectListByQytb(Integer qytb, String qyh);

	int updateTbZtByQytb(int qytb, int xtbzt, String qyh);

}
