package com.znczXcx.entity;

public class YongHu {
	
	public static final Boolean WEI_SHEN_HE_TEXT=false;
	public static final Boolean YI_SHEN_HE_TEXT=true;

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
	public String getYhm() {
		return yhm;
	}
	public void setYhm(String yhm) {
		this.yhm = yhm;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getZsxm() {
		return zsxm;
	}
	public void setZsxm(String zsxm) {
		this.zsxm = zsxm;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public Boolean getCheck() {
		return check;
	}
	public void setCheck(Boolean check) {
		this.check = check;
	}
	public String getJs() {
		return js;
	}
	public void setJs(String js) {
		this.js = js;
	}
	public String getQxIds() {
		return qxIds;
	}
	public void setQxIds(String qxIds) {
		this.qxIds = qxIds;
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
	//https://blog.csdn.net/qq_43416276/article/details/102981480
	public YongHu() {
		super();
	}
	
	public YongHu(String yhm,String mm) {
		this.yhm=yhm;
		this.mm=mm;
	}
	private Integer qyjlId;
	private String yhm;
	private String mm;
	private String zsxm;
	private String cjsj;
	private Boolean check;
	private String js;
	private String qxIds;
	private Integer qytb;//��ҵͬ�� 1.δͬ�� 2.ͬ���� 3.��ͬ��
	private String qyh;
}