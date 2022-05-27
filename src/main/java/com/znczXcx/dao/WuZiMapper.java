package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface WuZiMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(WuZi wuZi);
}
