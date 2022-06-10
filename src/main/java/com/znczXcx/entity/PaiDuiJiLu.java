package com.znczXcx.entity;

public class PaiDuiJiLu {

	public static final Integer PAI_DUI_ZHONG=1;//排队中
	public static final Integer YI_WAN_CHENG=2;//已完成
	public static final Integer YI_GUO_HAO=3;//已过号
	
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
	public Integer getYfwDdId() {
		return yfwDdId;
	}
	public void setYfwDdId(Integer yfwDdId) {
		this.yfwDdId = yfwDdId;
	}
	public Integer getQyDdId() {
		return qyDdId;
	}
	public void setQyDdId(Integer qyDdId) {
		this.qyDdId = qyDdId;
	}
	public String getPdsj() {
		return pdsj;
	}
	public void setPdsj(String pdsj) {
		this.pdsj = pdsj;
	}
	public Integer getDlh() {
		return dlh;
	}
	public void setDlh(Integer dlh) {
		this.dlh = dlh;
	}
	public Integer getPdh() {
		return pdh;
	}
	public void setPdh(Integer pdh) {
		this.pdh = pdh;
	}
	public Integer getQmsl() {
		return qmsl;
	}
	public void setQmsl(Integer qmsl) {
		this.qmsl = qmsl;
	}
	public Integer getZt() {
		return zt;
	}
	public void setZt(Integer zt) {
		this.zt = zt;
	}
	public Integer getQytb() {
		return qytb;
	}
	public void setQytb(Integer qytb) {
		this.qytb = qytb;
	}
	public String getCph() {
		return cph;
	}
	public void setCph(String cph) {
		this.cph = cph;
	}
	public String getEwmlj() {
		return ewmlj;
	}
	public void setEwmlj(String ewmlj) {
		this.ewmlj = ewmlj;
	}
	public String getQyh() {
		return qyh;
	}
	public void setQyh(String qyh) {
		this.qyh = qyh;
	}
	private Integer qyjlId;
	private Integer yfwDdId;
	private Integer qyDdId;
	private String pdsj;
	private Integer dlh;
	private Integer pdh;
	private Integer qmsl;
	private Integer zt;
	private Integer qytb;//企业同步 1.未同步 2.同步中 3.已同步
	private String cph;
	private String ewmlj;
	private String qyh;
}
