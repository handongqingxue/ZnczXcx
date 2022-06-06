package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface DingDanService {

	int syncToYf(List<DingDan> ddList, String qyh);

	DingDan selectByDdh(String ddh, String qyh);

	DingDan getZjpdzByDdh(String ddh, String qyh);

	boolean checkIfWtbToYf(String qyh);

	List<DingDan> selectListByQytb(Integer qytb, String qyh);

	int updateTbZtByQytb(Integer qytb, Integer xtbzt, String qyh);

}
