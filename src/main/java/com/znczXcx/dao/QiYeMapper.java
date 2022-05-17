package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface QiYeMapper {

	int add(QiYe qy);

	int getCountByQyh(@Param("qyh") String qyh);

	QiYe getByQyhMm(QiYe qy);

}
