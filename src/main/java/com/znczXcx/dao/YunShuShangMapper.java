package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface YunShuShangMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(YunShuShang yunShuShang);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int edit(YunShuShang yunShuShang);
}
