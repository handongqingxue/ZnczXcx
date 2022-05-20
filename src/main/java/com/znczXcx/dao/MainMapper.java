package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

public interface MainMapper {

	int getTabCountByTabName(@Param("tabName") String tabName);

}
