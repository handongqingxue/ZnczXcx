package com.znczXcx.entity;

public class ZhiJianJiLu {

	public static final Integer HE_GE=1;//�ϸ�
	public static final Integer BU_HE_GE=2;//���ϸ�
	
	public static final Integer WEI_TONG_BU=1;//δͬ��
	public static final Integer TONG_BU_ZHONG=2;//ͬ����
	public static final Integer YI_TONG_BU=3;//��ͬ��
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDdId() {
		return ddId;
	}
	public void setDdId(Integer ddId) {
		this.ddId = ddId;
	}
	public Integer getZjyId() {
		return zjyId;
	}
	public void setZjyId(Integer zjyId) {
		this.zjyId = zjyId;
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
	private Integer ddId;
	private Integer zjyId;
	private String zjyZsxm;
	private String zjsj;
	private Integer jg;//��� 1.�ϸ� 2.���ϸ�
	private String bz;
	private Integer qytb;//��ҵͬ�� 1.δͬ�� 2.ͬ���� 3.��ͬ��
	private String qyh;
}
