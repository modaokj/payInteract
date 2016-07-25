package com.softright.tbcards;

import java.util.HashSet;
import java.util.Set;

public class LoginUserUtil {
	private static Set<String> USERS=new HashSet<String>();
	public static synchronized boolean logining(String taobaoId){
		if(USERS.contains(taobaoId))
			return false;
		else{
			USERS.add(taobaoId);
			return true;
		}	
	}
	public static synchronized void loginFinish(String taobaoId){
		USERS.remove(taobaoId);
	}
}
