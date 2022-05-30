package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface BangDanJiLuMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(BangDanJiLu bangDanJiLu);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int edit(BangDanJiLu bangDanJiLu);

}
