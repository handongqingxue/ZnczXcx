package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

public interface MainMapper {

	int getTabCountByTabName(@Param("tabName") String tabName);
	
	Object getYfwColValByQyColVal(@Param("yfwColName") String yfwColName, @Param("qyColVal") String qyColVal, @Param("qyColName") String qyColName, @Param("tabName") String tabName, @Param("qyh") String qyh);

}
