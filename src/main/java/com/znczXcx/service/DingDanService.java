package com.znczXcx.service;

import java.util.List;

import com.znczXcx.entity.*;

public interface DingDanService {

	int addToYf(List<DingDan> ddList, String qyh);

	DingDan selectByDdh(String ddh, String qyh);

}