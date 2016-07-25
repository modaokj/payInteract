package com.softright.tbcards.po;

import com.softright.tbcards.po.base.BaseActivityHistory;

public class ActivityHistory extends BaseActivityHistory {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ActivityHistory () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ActivityHistory (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ActivityHistory (
		java.lang.String id,
		java.lang.String operation,
		java.util.Date operation_time,
		java.lang.String activity_id,
		java.lang.String taobao_id,
		java.lang.String activity_name,
		java.util.Date activity_startDate,
		java.util.Date activity_endDate,
		java.util.Date activity_createDate,
		java.lang.String activity_status,
		java.lang.String maQrcode_url,
		java.lang.String maQrcode_url_long,
		java.lang.String maQrcode_img_url,
		java.lang.String remark,
		java.lang.Integer to_shop_count,
		java.lang.Integer fx_claim,
		java.lang.Integer fx_count,
		java.lang.Integer scdp_count,
		java.lang.Integer scsp_claim,
		java.lang.Integer scsp_count,
		java.lang.Integer gz_count,
		java.lang.Integer jgwc_claim,
		java.lang.Integer jgwc_count,
		java.lang.Integer winning_lock,
		java.lang.String is_dpsy,
		java.util.Date dpsy_time,
		java.lang.String is_wt,
		java.util.Date wt_time) {

		super (
				id,
				operation,
				operation_time,
				activity_id,
				taobao_id,
				activity_name,
				activity_startDate,
				activity_endDate,
				activity_createDate,
				activity_status,
				maQrcode_url,
				maQrcode_url_long,
				maQrcode_img_url,
				remark,
				to_shop_count,
				fx_claim,
				fx_count,
				scdp_count,
				scsp_claim,
				scsp_count,
				gz_count,
				jgwc_claim,
				jgwc_count,
				winning_lock,
				is_dpsy,
				dpsy_time,
				is_wt,
				wt_time);
	}

/*[CONSTRUCTOR MARKER END]*/


}