package com.softright.tbcards.bo;



public class BoFactory {
	private static TaobaoApiBo taobaoBoImpl = new TaobaoApiBo();

	public static TaobaoApiBo getTaobaoApiBo() {
		return taobaoBoImpl;
	}
}
