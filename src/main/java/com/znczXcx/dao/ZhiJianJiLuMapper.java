package com.znczXcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface ZhiJianJiLuMapper {

	int add(ZhiJianJiLu zjjl);

	int getTbZtCount(@Param("qyh") String qyh, @Param("qytb") Integer qytb);

	List<ZhiJianJiLu> selectListByQytb(@Param("qyh") String qyh, @Param("qytb") Integer qytb);

	int updateTbZtByQytb(@Param("qyh") String qyh, @Param("qytb") int qytb, @Param("xtbzt") int xtbzt);

	int updateToYtb(@Param("qyh") String qyh);

}
