package com.softright.tbcards.po.base;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseActivityOptions  implements Serializable {

	public static String ACTIVITYOPTIONS = "ActivityOptions";
	public static String  ID= "id";
	public static String  TAOBAO_ID= "taobao_id";
	public static String  CREATE_TIME= "create_time";
	public static String  TO_SHOP_COUNT= "to_shop_count";
	public static String  FX_CLAIM= "fx_claim";
	public static String  FX_COUNT= "fx_count";
	public static String  SCDP_COUNT= "scdp_count";
	public static String  SCSP_CLAIM= "scsp_claim";
	public static String  SCSP_COUNT= "scsp_count";
	public static String  GZ_COUNT= "gz_count";
	public static String  JGWC_CLAIM= "jgwc_claim";
	public static String  JGWC_COUNT= "jgwc_count";
	public static String  WINNING_LOCK= "winning_lock";
	//============静态参数
	

	// constructors
	public BaseActivityOptions () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseActivityOptions (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */

	protected void initialize () {}
	public BaseActivityOptions(String id, String taobao_id, Date create_time, Integer to_shop_count, Integer fx_claim,
			Integer fx_count, Integer scdp_count, Integer scsp_claim, Integer scsp_count, Integer gz_count,
			Integer jgwc_claim, Integer jgwc_count, Integer winning_lock) {
		super();
		this.id = id;
		this.taobao_id = taobao_id;
		this.create_time = create_time;
		this.to_shop_count = to_shop_count;
		this.fx_claim = fx_claim;
		this.fx_count = fx_count;
		this.scdp_count = scdp_count;
		this.scsp_claim = scsp_claim;
		this.scsp_count = scsp_count;
		this.gz_count = gz_count;
		this.jgwc_claim = jgwc_claim;
		this.jgwc_count = jgwc_count;
		this.winning_lock = winning_lock;
	}
	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String taobao_id;
	private java.util.Date create_time;
	private java.lang.Integer to_shop_count;
	private java.lang.Integer fx_claim;
	private java.lang.Integer fx_count;
	private java.lang.Integer scdp_count;
	private java.lang.Integer scsp_claim;
	private java.lang.Integer scsp_count;
	private java.lang.Integer gz_count;
	private java.lang.Integer jgwc_claim;
	private java.lang.Integer jgwc_count;
	private java.lang.Integer winning_lock;

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getTaobao_id() {
		return taobao_id;
	}

	public void setTaobao_id(java.lang.String taobao_id) {
		this.taobao_id = taobao_id;
	}

	public java.util.Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.lang.Integer getTo_shop_count() {
		return to_shop_count;
	}

	public void setTo_shop_count(java.lang.Integer to_shop_count) {
		this.to_shop_count = to_shop_count;
	}

	public java.lang.Integer getFx_claim() {
		return fx_claim;
	}

	public void setFx_claim(java.lang.Integer fx_claim) {
		this.fx_claim = fx_claim;
	}

	public java.lang.Integer getFx_count() {
		return fx_count;
	}

	public void setFx_count(java.lang.Integer fx_count) {
		this.fx_count = fx_count;
	}

	public java.lang.Integer getScdp_count() {
		return scdp_count;
	}

	public void setScdp_count(java.lang.Integer scdp_count) {
		this.scdp_count = scdp_count;
	}

	public java.lang.Integer getScsp_claim() {
		return scsp_claim;
	}

	public void setScsp_claim(java.lang.Integer scsp_claim) {
		this.scsp_claim = scsp_claim;
	}

	public java.lang.Integer getScsp_count() {
		return scsp_count;
	}

	public void setScsp_count(java.lang.Integer scsp_count) {
		this.scsp_count = scsp_count;
	}

	public java.lang.Integer getGz_count() {
		return gz_count;
	}

	public void setGz_count(java.lang.Integer gz_count) {
		this.gz_count = gz_count;
	}

	public java.lang.Integer getJgwc_claim() {
		return jgwc_claim;
	}

	public void setJgwc_claim(java.lang.Integer jgwc_claim) {
		this.jgwc_claim = jgwc_claim;
	}

	public java.lang.Integer getJgwc_count() {
		return jgwc_count;
	}

	public void setJgwc_count(java.lang.Integer jgwc_count) {
		this.jgwc_count = jgwc_count;
	}

	public java.lang.Integer getWinning_lock() {
		return winning_lock;
	}

	public void setWinning_lock(java.lang.Integer winning_lock) {
		this.winning_lock = winning_lock;
	}

}