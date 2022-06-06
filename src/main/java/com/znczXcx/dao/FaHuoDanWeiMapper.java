package com.znczXcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface FaHuoDanWeiMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(FaHuoDanWei faHuoDanWei);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int edit(FaHuoDanWei faHuoDanWei);

	int getWtbToYfCount(@Param("qyh") String qyh);
	
	List<FaHuoDanWei> selectListByQytb(@Param("qytb") Integer qytb, @Param("qyh") String qyh);

	int updateTbZtByQytb(@Param("qytb") int qytb, @Param("xtbzt") int xtbzt, @Param("qyh") String qyh);
}
