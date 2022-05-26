package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface DingDanMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(DingDan dd);

	DingDan selectByDdh(@Param("ddh") String ddh, @Param("qyh") String qyh);

}