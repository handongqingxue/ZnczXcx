package com.znczXcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface PaiDuiJiLuMapper {

	int getTbZtCount(@Param("qyh") String qyh, @Param("qytb") Integer qytb);

	List<PaiDuiJiLu> selectListByQytb(@Param("qyh") String qyh, @Param("qytb") Integer qytb);

	int updateTbZtByQytb(@Param("qyh") String qyh, @Param("qytb") int qytb, @Param("xtbzt") int xtbzt);

	int updateToYtb(@Param("qyh") String qyh);

	int createTabByQyh(@Param("qyh") String qyh);

}
