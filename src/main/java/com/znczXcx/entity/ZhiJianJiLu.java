package com.znczXcx.entity;

public class ZhiJianJiLu {

	public static final Integer HE_GE=1;//合格
	public static final Integer BU_HE_GE=2;//不合格
	
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
	public String getDdh() {
		return ddh;
	}
	public void setDdh(String ddh) {
		this.ddh = ddh;
	}
	public String getDdztMc() {
		return ddztMc;
	}
	public void setDdztMc(String ddztMc) {
		this.ddztMc = ddztMc;
	}
	public Integer getYfwZjyId() {
		return yfwZjyId;
	}
	public void setYfwZjyId(Integer yfwZjyId) {
		this.yfwZjyId = yfwZjyId;
	}
	public Integer getQyZjyId() {
		return qyZjyId;
	}
	public void setQyZjyId(Integer qyZjyId) {
		this.qyZjyId = qyZjyId;
	}
	public String getZjyZsxm() {
		return zjyZsxm;
	}
	public void setZjyZsxm(String zjyZsxm) {
		this.zjyZsxm = zjyZsxm;
	}
	public String getZjsj() {
		return zjsj;
	}
	public void setZjsj(String zjsj) {
		this.zjsj = zjsj;
	}
	public Integer getJg() {
		return jg;
	}
	public void setJg(Integer jg) {
		this.jg = jg;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
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
	private Integer yfwDdId;
	private Integer qyDdId;
	private String ddh;//订单号
	private String ddztMc;
	private Integer yfwZjyId;
	private Integer qyZjyId;
	private String zjyZsxm;
	private String zjsj;
	private Integer jg;//结果 1.合格 2.不合格
	private String bz;
	private Integer qytb;//企业同步 1.未同步 2.同步中 3.已同步
	private String qyh;
}
