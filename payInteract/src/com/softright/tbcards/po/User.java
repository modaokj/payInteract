package com.softright.tbcards.po;

import com.softright.tbcards.po.base.BaseUser;



public class User extends BaseUser {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public User () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public User (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public User (
		java.lang.String id,
		java.lang.String nick,
		java.lang.String shopType,
		java.util.Date lastLogin,
		java.util.Date vipTime,
		java.util.Date expire_date) {

		super (
			id,
			nick,
			shopType,
			lastLogin,
			vipTime,
			expire_date);
	}

/*[CONSTRUCTOR MARKER END]*/


}