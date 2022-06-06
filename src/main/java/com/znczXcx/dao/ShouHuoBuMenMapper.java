package com.znczXcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface ShouHuoBuMenMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(ShouHuoBuMen shouHuoBuMen);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int edit(ShouHuoBuMen shouHuoBuMen);

	int getWtbToYfCount(@Param("qyh") String qyh);

	List<ShouHuoBuMen> selectListByQytb(@Param("qytb") Integer qytb, @Param("qyh") String qyh);

	int updateTbZtByQytb(@Param("qytb") Integer qytb, @Param("xtbzt") Integer xtbzt, @Param("qyh") String qyh);
}
