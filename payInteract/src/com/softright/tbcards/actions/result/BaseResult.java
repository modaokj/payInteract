package com.softright.tbcards.actions.result;

import com.google.gson.annotations.Expose;

public class BaseResult {
	@Expose
	private int code;
	@Expose
	private String codeText;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCodeText() {
		return codeText;
	}
	public void setCodeText(String codeText) {
		this.codeText = codeText;
	}
}
