package com.znczXcx.entity;

public class WuZi {

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
	public String getBjsj() {
		return bjsj;
	}
	public void setBjsj(String bjsj) {
		this.bjsj = bjsj;
	}
	public Integer getWzlxId() {
		return wzlxId;
	}
	public void setWzlxId(Integer wzlxId) {
		this.wzlxId = wzlxId;
	}
	public String getWzlxmc() {
		return wzlxmc;
	}
	public void setWzlxmc(String wzlxmc) {
		this.wzlxmc = wzlxmc;
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
	private String bjsj;
	private Integer wzlxId;
	private String wzlxmc;
	private Integer qytb;//企业同步 1.未同步 2.同步中 3.已同步
	private String qyh;
}
