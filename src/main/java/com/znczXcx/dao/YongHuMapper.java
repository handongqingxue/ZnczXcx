package com.znczXcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface YongHuMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int add(YongHu yongHu);

	int edit(YongHu yongHu);

	int getWtbToYfCount(@Param("qyh") String qyh);

	List<YongHu> selectListByQytb(@Param("qytb") Integer qytb, @Param("qyh") String qyh);

	int updateTbZtByQytb(@Param("qytb") int qytb, @Param("xtbzt") int xtbzt, @Param("qyh") String qyh);

}
