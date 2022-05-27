package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

public interface WuZiLeiXingMapper {

	int createTabByQyh(@Param("qyh") String qyh);
}
