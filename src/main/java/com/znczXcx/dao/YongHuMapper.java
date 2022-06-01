package com.znczXcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface YongHuMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int add(YongHu yongHu);

	int edit(YongHu yongHu);

}
