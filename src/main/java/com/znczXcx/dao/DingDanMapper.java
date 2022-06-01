package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface DingDanMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(DingDan dd);

	int editById(DingDan dingDan);

	int editByQyjlId(DingDan dingDan);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	DingDan selectByDdh(@Param("ddh") String ddh, @Param("qyh") String qyh);

	DingDan selectByYfwDdztIdDdh(@Param("yfwDdztId") int yfwDdztId, @Param("ddh") String ddh, @Param("qyh") String qyh);

}
