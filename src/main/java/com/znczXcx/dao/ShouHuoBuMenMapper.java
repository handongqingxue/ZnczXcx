package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface ShouHuoBuMenMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(ShouHuoBuMen shouHuoBuMen);
}
