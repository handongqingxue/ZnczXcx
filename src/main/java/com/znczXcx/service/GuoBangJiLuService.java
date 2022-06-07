package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface GuoBangJiLuService {

	int syncToYf(List<GuoBangJiLu> gbjlList, String qyh);

	boolean checkIfWtbToYf(String qyh);

	List<GuoBangJiLu> selectListByQytb(Integer qytb, String qyh);

	int updateTbZtByQytb(Integer qytb, Integer xtbzt, String qyh);

}
