package com.softright.tbcards.po.base;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseActivityHistory  implements Serializable {

	public static String ACTIVITYOPTIONS = "ActivityOptions";

	// constructors
	public BaseActivityHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseActivityHistory (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	public BaseActivityHistory(String id, String operation, Date operation_time, String activity_id, String taobao_id,
			String activity_name, Date activity_startDate, Date activity_endDate, Date activity_createDate,
			String activity_status, String maQrcode_url, String maQrcode_url_long, String maQrcode_img_url,
			String remark, Integer to_shop_count, Integer fx_claim, Integer fx_count, Integer scdp_count,
			Integer scsp_claim, Integer scsp_count, Integer gz_count, Integer jgwc_claim, Integer jgwc_count,
			Integer winning_lock, String is_dpsy, Date dpsy_time, String is_wt, Date wt_time) {
		super();
		this.id = id;
		this.operation = operation;
		this.operation_time = operation_time;
		this.activity_id = activity_id;
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
	private java.lang.String operation;
	private java.util.Date operation_time;
	private java.lang.String activity_id;
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

	public java.lang.String getOperation() {
		return operation;
	}

	public void setOperation(java.lang.String operation) {
		this.operation = operation;
	}

	public java.util.Date getOperation_time() {
		return operation_time;
	}

	public void setOperation_time(java.util.Date operation_time) {
		this.operation_time = operation_time;
	}

	public java.lang.String getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(java.lang.String activity_id) {
		this.activity_id = activity_id;
	}

	public java.lang.String getTaobao_id() {
		return taobao_id;
	}

	public void setTaobao_id(java.lang.String taobao_id) {
		this.taobao_id = taobao_id;
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