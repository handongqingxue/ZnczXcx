package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

public interface YongHuMapper {

	int createTabByQyh(@Param("qyh") String qyh);

}
