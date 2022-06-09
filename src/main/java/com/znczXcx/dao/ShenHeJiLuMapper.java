package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface ShenHeJiLuMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int add(ShenHeJiLu shenHeJiLu);

	int edit(ShenHeJiLu shenHeJiLu);

}
