package com.znczXcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface PaiDuiJiLuMapper {

	int getTbZtCount(@Param("qyh") String qyh, @Param("qytb") Integer qytb);

	List<PaiDuiJiLu> selectListByQytb(@Param("qyh") String qyh, @Param("qytb") Integer qytb);

	int updateTbZtByQytb(@Param("qyh") String qyh, @Param("qytb") int qytb, @Param("xtbzt") int xtbzt);

	int createTabByQyh(@Param("qyh") String qyh);

	int add(PaiDuiJiLu pdjl);

	int edit(PaiDuiJiLu paiDuiJiLu);

	int getCountByDdIdZt(@Param("yfwDdId") Integer yfwDdId,@Param("zt") Integer zt,@Param("qyh") String qyh);

	Integer getTodayLastDlh(@Param("qyh") String qyh);

	Integer getTodayLastPdh(@Param("qyh") String qyh);

	int updatePhdByDdId(@Param("pdh") Integer pdh, @Param("yfwDdId") Integer yfwDdId, @Param("qyh") String qyh);

	PaiDuiJiLu selectByDdIdZt(@Param("ddId") Integer ddId, @Param("zt") Integer zt, @Param("qyh") String qyh);

	int getQmslByPdh(@Param("pdh") Integer pdh, @Param("qyh") String qyh);

	int getWtbToYfCount(@Param("qyh") String qyh);

	List<PaiDuiJiLu> selectListByQytb(@Param("qytb") Integer qytb, @Param("qyh") String qyh);

	int updateTbZtByQytb(@Param("qytb") Integer qytb, @Param("xtbzt") Integer xtbzt, @Param("qyh") String qyh);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int updateZtByYfwDdId(@Param("zt") Integer zt, @Param("yfwDdId") Integer yfwDdId, @Param("qyh") String qyh);

}
