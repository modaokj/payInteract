package com.softright.tbcards.po;

import com.softright.tbcards.po.base.BaseActivityOptions;

public class ActivityOptions extends BaseActivityOptions {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ActivityOptions () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ActivityOptions (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ActivityOptions (
		java.lang.String id,
		java.lang.String taobao_id,
		java.util.Date create_time,
		java.lang.Integer to_shop_count,
		java.lang.Integer fx_claim,
		java.lang.Integer fx_count,
		java.lang.Integer scdp_count,
		java.lang.Integer scsp_claim,
		java.lang.Integer scsp_count,
		java.lang.Integer gz_count,
		java.lang.Integer jgwc_claim,
		java.lang.Integer jgwc_count,
		java.lang.Integer winning_lock) {

		super (
				id,
				taobao_id,
				create_time,
				to_shop_count,
				fx_claim,
				fx_count,
				scdp_count,
				scsp_claim,
				scsp_count,
				gz_count,
				jgwc_claim,
				jgwc_count,
				winning_lock);
	}

/*[CONSTRUCTOR MARKER END]*/


}