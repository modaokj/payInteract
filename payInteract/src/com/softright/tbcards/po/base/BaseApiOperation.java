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

public abstract class BaseApiOperation  implements Serializable {

	public static String APIOPERATION = "ApiOperation";
	public static String ID = "id";
	public static String TIME = "time";
	public static String API = "api";
	public static String CONTENT = "content";
	public static String RESULT = "result";
	public static String OK_NO = "ok_no";
	

	// constructors
	public BaseApiOperation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseApiOperation (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	public BaseApiOperation(String id, Date time, String api, String content, String result, String ok_no) {
		super();
		this.id = id;
		this.time = time;
		this.api = api;
		this.content = content;
		this.result = result;
		this.ok_no = ok_no;
	}

	/**
	 * Constructor for required fields
	 */

	protected void initialize () {}
	// primary key
	private java.lang.String id;

	// fields
	private java.util.Date time;
	private java.lang.String api;
	private java.lang.String content;
	private java.lang.String result;
	private java.lang.String ok_no;

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.util.Date getTime() {
		return time;
	}

	public void setTime(java.util.Date time) {
		this.time = time;
	}

	public java.lang.String getApi() {
		return api;
	}

	public void setApi(java.lang.String api) {
		this.api = api;
	}

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getResult() {
		return result;
	}

	public void setResult(java.lang.String result) {
		this.result = result;
	}

	public java.lang.String getOk_no() {
		return ok_no;
	}

	public void setOk_no(java.lang.String ok_no) {
		this.ok_no = ok_no;
	}


}