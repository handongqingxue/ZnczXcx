package com.znczXcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface DingDanZhuangTaiMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(DingDanZhuangTai dingDanZhuangTai);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int edit(DingDanZhuangTai dingDanZhuangTai);

	int getIdByMc(@Param("mc") String mc, @Param("qyh") String qyh);

	int getWtbToYfCount(@Param("qyh") String qyh);

	List<DingDanZhuangTai> selectListByQytb(@Param("qytb") Integer qytb, @Param("qyh") String qyh);

	int updateTbZtByQytb(@Param("qytb") int qytb, @Param("xtbzt") int xtbzt, @Param("qyh") String qyh);
}
