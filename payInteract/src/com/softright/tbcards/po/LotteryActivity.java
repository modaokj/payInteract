package com.softright.tbcards.po;

import com.softright.tbcards.po.base.BaseLotteryActivity;



public class LotteryActivity extends BaseLotteryActivity {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public LotteryActivity () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LotteryActivity (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public LotteryActivity (
		java.lang.String id,
		java.lang.String taobao_id,
		java.lang.String activity_name,
		java.util.Date activity_startDate,
		java.util.Date activity_endDate,
		java.util.Date activity_createDate,
		java.lang.String activity_status,
		java.lang.String maQrcode_url,
		java.lang.String maQrcode_url_long,
		java.lang.String maQrcode_img_url,
		java.lang.String remark ) {

		super (
				id,
				taobao_id,
				activity_name,
				activity_startDate,
				activity_endDate,
				activity_createDate,
				activity_status,
				maQrcode_url,
				maQrcode_url_long,
				maQrcode_img_url,
				remark);
	}

/*[CONSTRUCTOR MARKER END]*/


}