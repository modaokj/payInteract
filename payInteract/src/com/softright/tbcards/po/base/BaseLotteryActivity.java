package com.softright.tbcards.po.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the Vb_taobao_user table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Vb_taobao_user"
 */

public abstract class BaseLotteryActivity  implements Serializable {

	public static String LOTTERYACTIVITY = "LotteryActivity";
	public static String ID = "id";
	public static String TAOBAO_ID = "taobao_id";
	public static String ACTIVITY_NAME = "activity_name";
	public static String ACTIVITY_STARTDATE = "activity_startDate";
	public static String ACTIVITY_ENDDATE = "activity_endDate";
	public static String ACTIVITY_CREATEDATE = "activity_createDate";
	public static String ACTIVITY_STATUS = "activity_status";
	public static String MAQRCODE_URL = "maQrcode_url";
	public static String MAQRCODE_URL_LONG = "maQrcode_url_long";
	public static String MAQRCODE_IMG_URL = "maQrcode_img_url";
	public static String REMARK = "remark";
	
	//============静态参数
	public static String STATUS_W = "W";//预创建
	public static String STATUS_C = "C";//进行中
	public static String STATUS_D = "D";//已删除
	public static String STATUS_Y = "Y";//已结束
	public static String STATUS_S = "S";//已暂停
	

	// constructors
	public BaseLotteryActivity () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLotteryActivity (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */

	protected void initialize () {}
	public BaseLotteryActivity(String id, String taobao_id, String activity_name, Date activity_startDate,
			Date activity_endDate, Date activity_createDate, String activity_status, String maQrcode_url,
			String maQrcode_url_long, String maQrcode_img_url, String remark) {
		super();
		this.id = id;
		this.taobao_id = taobao_id;
		this.activity_name = activity_name;
		this.activity_startDate = activity_startDate;
		this.activity_endDate = activity_endDate;
		this.activity_createDate = activity_createDate;
		this.activity_status = activity_status;
		this.maQrcode_url = maQrcode_url;
		this.maQrcode_url_long = maQrcode_url_long;
		this.maQrcode_img_url = maQrcode_img_url;
		this.remark = remark;
	}
	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String taobao_id;
	private java.lang.String activity_name;
	private java.util.Date activity_startDate;
	private java.util.Date activity_endDate;
	private java.util.Date activity_createDate;
	private java.lang.String activity_status;
	private java.lang.String maQrcode_url;
	private java.lang.String maQrcode_url_long;
	private java.lang.String maQrcode_img_url;
	private java.lang.String remark;



	public java.lang.String getTaobao_id() {
		return taobao_id;
	}

	public void setTaobao_id(java.lang.String taobao_id) {
		this.taobao_id = taobao_id;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(java.lang.String activity_name) {
		this.activity_name = activity_name;
	}

	public java.util.Date getActivity_startDate() {
		return activity_startDate;
	}

	public void setActivity_startDate(java.util.Date activity_startDate) {
		this.activity_startDate = activity_startDate;
	}

	public java.util.Date getActivity_endDate() {
		return activity_endDate;
	}

	public void setActivity_endDate(java.util.Date activity_endDate) {
		this.activity_endDate = activity_endDate;
	}

	public java.util.Date getActivity_createDate() {
		return activity_createDate;
	}

	public void setActivity_createDate(java.util.Date activity_createDate) {
		this.activity_createDate = activity_createDate;
	}

	public java.lang.String getActivity_status() {
		return activity_status;
	}

	public void setActivity_status(java.lang.String activity_status) {
		this.activity_status = activity_status;
	}

	public java.lang.String getMaQrcode_url() {
		return maQrcode_url;
	}

	public void setMaQrcode_url(java.lang.String maQrcode_url) {
		this.maQrcode_url = maQrcode_url;
	}

	public java.lang.String getMaQrcode_url_long() {
		return maQrcode_url_long;
	}

	public void setMaQrcode_url_long(java.lang.String maQrcode_url_long) {
		this.maQrcode_url_long = maQrcode_url_long;
	}

	public java.lang.String getMaQrcode_img_url() {
		return maQrcode_img_url;
	}

	public void setMaQrcode_img_url(java.lang.String maQrcode_img_url) {
		this.maQrcode_img_url = maQrcode_img_url;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}


}