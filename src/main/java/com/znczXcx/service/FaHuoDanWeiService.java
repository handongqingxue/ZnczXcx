package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface FaHuoDanWeiService {

	int syncToYf(List<FaHuoDanWei> fhdwList, String qyh);

	boolean checkIfWtbToYf(String qyh);

	List<FaHuoDanWei> selectListByQytb(Integer qytb, String qyh);

	int updateTbZtByQytb(int qytb, int xtbzt, String qyh);

}
