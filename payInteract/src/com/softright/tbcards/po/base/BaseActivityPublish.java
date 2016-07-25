package com.softright.tbcards.po.base;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseActivityPublish  implements Serializable {

	public static String ACTIVITYPUBLISH = "ActivityPublish";
	public static String  ID= "id";
	public static String  TAOBAO_ID= "taobao_id";
	public static String  IS_DPSY= "is_dpsy";
	public static String  DPSY_TIME= "dpsy_time";
	public static String  IS_WT= "is_wt";
	public static String  WT_TIME= "wt_time";
	//============静态参数
	

	// constructors
	public BaseActivityPublish () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseActivityPublish (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	public BaseActivityPublish(String id, String taobao_id, String is_dpsy, Date dpsy_time, String is_wt,
			Date wt_time) {
		super();
		this.id = id;
		this.taobao_id = taobao_id;
		this.is_dpsy = is_dpsy;
		this.dpsy_time = dpsy_time;
		this.is_wt = is_wt;
		this.wt_time = wt_time;
	}

	/**
	 * Constructor for required fields
	 */

	protected void initialize () {}
	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String taobao_id;
	private java.lang.String is_dpsy;
	private java.util.Date dpsy_time;
	private java.lang.String is_wt;
	private java.util.Date wt_time;


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

	public java.lang.String getIs_dpsy() {
		return is_dpsy;
	}

	public void setIs_dpsy(java.lang.String is_dpsy) {
		this.is_dpsy = is_dpsy;
	}

	public java.util.Date getDpsy_time() {
		return dpsy_time;
	}

	public void setDpsy_time(java.util.Date dpsy_time) {
		this.dpsy_time = dpsy_time;
	}

	public java.lang.String getIs_wt() {
		return is_wt;
	}

	public void setIs_wt(java.lang.String is_wt) {
		this.is_wt = is_wt;
	}

	public java.util.Date getWt_time() {
		return wt_time;
	}

	public void setWt_time(java.util.Date wt_time) {
		this.wt_time = wt_time;
	}
	

}