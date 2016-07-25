package com.softright.tbcards.po;

import com.softright.tbcards.po.base.BaseActivityPublish;

public class ActivityPublish extends BaseActivityPublish {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ActivityPublish () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ActivityPublish (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ActivityPublish (
		java.lang.String id,
		java.lang.String taobao_id,
		java.lang.String is_dpsy,
		java.util.Date dpsy_time,
		java.lang.String is_wt,
		java.util.Date wt_time) {

		super (
				id,
				taobao_id,
				is_dpsy,
				dpsy_time,
				is_wt,
				wt_time);
	}

/*[CONSTRUCTOR MARKER END]*/


}