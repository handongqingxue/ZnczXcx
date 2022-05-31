package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface PaiDuiJiLuService {

	boolean checkIfTbZt(String qyh, Integer qytb);

	List<PaiDuiJiLu> selectListByQytb(String qyh, Integer qytb);

	int updateTbZtByQytb(String qyh, int qytb, int xtbzt);

	int updateToYtb(String qyh);

	int add(PaiDuiJiLu pdjl);

	boolean checkIfExist(Integer ddId,String qyh);

	int updatePhdByDdId(Integer ddId,String qyh);

	PaiDuiJiLu selectByDdId(Integer ddId, String qyh);

}
