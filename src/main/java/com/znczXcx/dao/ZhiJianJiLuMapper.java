package com.znczXcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface ZhiJianJiLuMapper {

	int add(ZhiJianJiLu zjjl);

	int edit(ZhiJianJiLu zhiJianJiLu);

	int getTbZtCount(@Param("qyh") String qyh, @Param("qytb") Integer qytb);

	List<ZhiJianJiLu> selectListByQytb(@Param("qyh") String qyh, @Param("qytb") Integer qytb);

	int updateTbZtByQytb(@Param("qyh") String qyh, @Param("qytb") int qytb, @Param("xtbzt") int xtbzt);

	int createTabByQyh(@Param("qyh") String qyh);

	int getWtbToYfCount(@Param("qyh") String qyh);

	List<ZhiJianJiLu> selectListByQytb(@Param("qytb") Integer qytb, @Param("qyh") String qyh);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	List<ZhiJianJiLu> queryList(@Param("jg") Integer jg, @Param("ddh") String ddh, @Param("ddztId") Integer ddztId, @Param("zjyZsxm") String zjyZsxm, @Param("qyh") String qyh);

}
