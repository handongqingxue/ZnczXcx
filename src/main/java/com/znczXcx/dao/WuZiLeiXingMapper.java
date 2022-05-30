package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface WuZiLeiXingMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(WuZiLeiXing wuZiLeiXing);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int edit(WuZiLeiXing wuZiLeiXing);
}
