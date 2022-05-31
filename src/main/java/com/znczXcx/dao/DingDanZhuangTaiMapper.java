package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface DingDanZhuangTaiMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(DingDanZhuangTai dingDanZhuangTai);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int edit(DingDanZhuangTai dingDanZhuangTai);

	int getIdByMc(@Param("mc") String mc, @Param("qyh") String qyh);
}
