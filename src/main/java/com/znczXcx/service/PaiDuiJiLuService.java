package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface PaiDuiJiLuService {

	boolean checkIfTbZt(String qyh, Integer qytb);

	List<PaiDuiJiLu> selectListByQytb(String qyh, Integer qytb);

	int updateTbZtByQytb(String qyh, int qytb, int xtbzt);

	int add(PaiDuiJiLu pdjl);

	boolean checkIfExist(Integer ddId,String qyh);

	int updatePhdByDdId(Integer ddId,String qyh);

	PaiDuiJiLu selectByDdId(Integer ddId, String qyh);

	boolean checkIfWtbToYf(String qyh);

	List<PaiDuiJiLu> selectListByQytb(Integer qytb, String qyh);

	int updateTbZtByQytb(Integer qytb, Integer xtbzt, String qyh);

	int syncToYf(List<PaiDuiJiLu> pdjlList, String qyh);

}
