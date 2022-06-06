package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface ShouHuoBuMenService {

	int syncToYf(List<ShouHuoBuMen> shbmList, String qyh);

	boolean checkIfWtbToYf(String qyh);

	List<ShouHuoBuMen> selectListByQytb(Integer qytb, String qyh);

	int updateTbZtByQytb(Integer qytb, Integer xtbzt, String qyh);

}
