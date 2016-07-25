package com.softright.utils;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.handwin.db.DataService;
import com.softright.tbcards.Constants;
import com.softright.tbcards.PassportNew;
import com.softright.tbcards.po.User;

public class Validit {
	private static Logger logger = Logger.getLogger(Validit.class);
	/*****
	 * 验证ppt对象数据
	 * @author liucheng
	 * @param 
	 * @return 
	 * @exception/throws
	 */
	 public static User getUser(PassportNew ppt,DataService dao){
		 if(null==ppt){
			 return null;
		 }
		 if(StringUtils.isBlank(ppt.getId())){
			 return null;
		 }
		 User user = (User) dao.locate(User.class,ppt.getId());
		 return user;
	 }
	
	//计算账号的有效期
    public static String validity(User user){
    	String v="";
    	try {
	    	if(null!=user && null!=user.getVipTime()){
	       		 Date vip=user.getVipTime();
	       		 long between=DateSystem.getDateDifference_INT(new Date(), vip);
	       		 long day1=between/(24*3600);   
	       		 long hour1=between%(24*3600)/3600;   
	       		 long minute1=between%3600/60;   
	       		 long second1=between%60/60;  
	       		 v=day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒";
	    	}else{
	    		Date date=DateSystem.stringToDate(Constants.vipdate);//老用户时间
	    		if (user.getRegistTime().before(date)) {//老用户且订购时间没有过期
	    			//老用户
	    			Calendar c = Calendar.getInstance();
	    			c.setTime(user.getRegistTime());
	    			c.add(Calendar.YEAR, 1);//年
	    			long between=DateSystem.getDateDifference_INT(new Date(), c.getTime());//有效期
	       		    long day1=between/(24*3600);   
	       		    long hour1=between%(24*3600)/3600;   
	       		    long minute1=between%3600/60;   
	       		    long second1=between%60/60;  
		       		v=day1+"天"+hour1+"小时"+minute1+"分"+second1+"秒";
				}else {
					v="请稍后，正在获取中...";
				}
	    	}
    	} catch (Exception e) {
			// TODO: handle exception
			v="请稍后，正在获取中...";
		}
    	return v;
    }
}
