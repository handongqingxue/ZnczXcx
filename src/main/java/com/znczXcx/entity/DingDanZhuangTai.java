package com.znczXcx.entity;

public class DingDanZhuangTai {
	
	public static final String DAI_SHEN_HE_TEXT="�����";//1
	public static final String YI_SHEN_HE_TEXT="�����";//2
	public static final String DAI_ZHI_JIAN_TEXT="���ʼ�";//3
	public static final String ZHI_JIAN_PAI_DUI_ZHONG_TEXT="�ʼ��Ŷ���";//4
	public static final String ZHI_JIAN_ZHONG_TEXT="�ʼ���";//5
	public static final String YI_JIAN_PAI_DUI_ZHONG_TEXT="һ���Ŷ���";//6
	public static final String YI_JIAN_SHANG_BANG_TEXT="һ���ϰ�";//7
	public static final String YI_JIAN_DAI_SHEN_HE_TEXT="һ������";//8
	public static final String DAI_RU_KU_TEXT="�����";//9
	public static final String ER_JIAN_PAI_DUI_ZHONG_TEXT="�����Ŷ���";//10
	public static final String ER_JIAN_SHANG_BANG_TEXT="�����ϰ�";//11
	public static final String ER_JIAN_DAI_SHEN_HE_TEXT="��������";//12
	public static final String YI_WAN_CHENG_TEXT="�����";//13

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
	private Integer qytb;//��ҵͬ�� 1.δͬ�� 2.ͬ���� 3.��ͬ��
	private String qyh;
}
