package com.znczXcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface BangDanJiLuMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(BangDanJiLu bangDanJiLu);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int edit(BangDanJiLu bangDanJiLu);

	int getWtbToYfCount(@Param("qyh") String qyh);

	List<BangDanJiLu> selectListByQytb(@Param("qytb") Integer qytb, @Param("qyh") String qyh);

	int updateTbZtByQytb(@Param("qytb") Integer qytb, @Param("xtbzt") Integer xtbzt, @Param("qyh") String qyh);

}
