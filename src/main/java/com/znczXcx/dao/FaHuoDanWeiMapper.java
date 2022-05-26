package com.znczXcx.dao;

import org.apache.ibatis.annotations.Param;

import com.znczXcx.entity.*;

public interface FaHuoDanWeiMapper {

	int createTabByQyh(@Param("qyh") String qyh);

	int add(FaHuoDanWei faHuoDanWei);
}
