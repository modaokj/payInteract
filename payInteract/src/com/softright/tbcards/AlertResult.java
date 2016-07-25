package com.softright.tbcards;

import com.google.gson.annotations.Expose;

public class AlertResult {
	public static final int CODE_SUCCESS=0;
	public static final int CODE_FAIL=500;
	@Expose
	private int code;
	@Expose
	private String txt;
	
	public AlertResult(int code, String text) {
		super();
		this.code = code;
		this.txt = text;
	}

	public AlertResult() {
		
	}
	public static AlertResult buildSuccess(String txt)
	{
		return new AlertResult(CODE_SUCCESS,txt);
	}
	public static AlertResult buildFail(String txt)
	{
		return new AlertResult(CODE_FAIL,txt);
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
}
