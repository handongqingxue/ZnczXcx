package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

public interface DingDanMapper {

	int createTabByQyh(@Param("qyh") String qyh);

}
