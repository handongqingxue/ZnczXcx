package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface GuoBangJiLuMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(GuoBangJiLu guoBangJiLu);

}
