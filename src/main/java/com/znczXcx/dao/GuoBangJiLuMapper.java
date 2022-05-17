package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

public interface GuoBangJiLuMapper {

	int createTabByQyh(@Param("qyh") String qyh);

}
