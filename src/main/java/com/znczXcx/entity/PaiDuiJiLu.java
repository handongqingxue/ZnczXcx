package com.znczXcx.entity;

public class PaiDuiJiLu {

	public static final Integer PAI_DUI_ZHONG=1;//�Ŷ���
	public static final Integer YI_WAN_CHENG=2;//�����
	public static final Integer YI_GUO_HAO=3;//�ѹ���
	
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
	public Integer getDdId() {
		return ddId;
	}
	public void setDdId(Integer ddId) {
		this.ddId = ddId;
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
	public String getQyh() {
		return qyh;
	}
	public void setQyh(String qyh) {
		this.qyh = qyh;
	}
	private Integer qyjlId;
	private Integer ddId;
	private String pdsj;
	private Integer dlh;
	private Integer pdh;
	private Integer zt;
	private Integer qytb;//��ҵͬ�� 1.δͬ�� 2.ͬ���� 3.��ͬ��
	private String qyh;
}