package com.znczXcx.entity;

public class DingDanZhuangTai {
	
	public static final String DAI_SHEN_HE_TEXT="待审核";//1
	public static final String YI_SHEN_HE_TEXT="已审核";//2
	public static final String DAI_ZHI_JIAN_TEXT="待质检";//3
	public static final String ZHI_JIAN_PAI_DUI_ZHONG_TEXT="质检排队中";//4
	public static final String ZHI_JIAN_ZHONG_TEXT="质检中";//5
	public static final String YI_JIAN_PAI_DUI_ZHONG_TEXT="一检排队中";//6
	public static final String YI_JIAN_SHANG_BANG_TEXT="一检上磅";//7
	public static final String YI_JIAN_DAI_SHEN_HE_TEXT="一检待审核";//8
	public static final String DAI_RU_KU_TEXT="待入库";//9
	public static final String ER_JIAN_PAI_DUI_ZHONG_TEXT="二检排队中";//10
	public static final String ER_JIAN_SHANG_BANG_TEXT="二检上磅";//11
	public static final String ER_JIAN_DAI_SHEN_HE_TEXT="二检待审核";//12
	public static final String YI_WAN_CHENG_TEXT="已完成";//13

	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQyjlId() {
		return qyjlId;
	}
	public void setQyjlId(Integer qyjlId) {
		this.qyjlId = qyjlId;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public Integer getPx() {
		return px;
	}
	public void setPx(Integer px) {
		this.px = px;
	}
	public Integer getQytb() {
		return qytb;
	}
	public void setQytb(Integer qytb) {
		this.qytb = qytb;
	}
	public String getQyh() {
		return qyh;
	}
	public void setQyh(String qyh) {
		this.qyh = qyh;
	}
	private Integer qyjlId;
	private String mc;
	private Integer px;
	private Integer qytb;//企业同步 1.未同步 2.同步中 3.已同步
	private String qyh;
}
