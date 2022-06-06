package com.znczXcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface WuZiLeiXingMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(WuZiLeiXing wuZiLeiXing);

	int getCountByQyjlId(@Param("qyjlId") Integer qyjlId, @Param("qyh") String qyh);

	int edit(WuZiLeiXing wuZiLeiXing);

	int getWtbToYfCount(@Param("qyh") String qyh);

	List<WuZiLeiXing> selectListByQytb(@Param("qytb") Integer qytb, @Param("qyh") String qyh);

	int updateTbZtByQytb(@Param("qytb") int qytb, @Param("xtbzt") int xtbzt, @Param("qyh") String qyh);
}
