package com.softright.tbcards.po;

import com.softright.tbcards.po.base.BaseApiOperation;

public class ApiOperation extends BaseApiOperation {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ApiOperation () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ApiOperation (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ApiOperation (
		java.lang.String id,
		java.util.Date time,
		java.lang.String api,
		java.lang.String content,
		java.lang.String result,
		java.lang.String ok_no) {

		super (
				id,
				time,
				api,
				content,
				result,
				ok_no);
	}

/*[CONSTRUCTOR MARKER END]*/


}