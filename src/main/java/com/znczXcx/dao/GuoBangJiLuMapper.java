package com.znczXcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface GuoBangJiLuMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(GuoBangJiLu guoBangJiLu);

	int getWtbToYfCount(@Param("qyh") String qyh);

	List<GuoBangJiLu> selectListByQytb(@Param("qytb") Integer qytb, @Param("qyh") String qyh);

	int updateTbZtByQytb(@Param("qytb") Integer qytb, @Param("xtbzt") Integer xtbzt, @Param("qyh") String qyh);

}
