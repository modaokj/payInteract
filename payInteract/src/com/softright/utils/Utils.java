package com.softright.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {

	// 转换int 分 为货币显示
	public static String priceToStr(Integer v) {
		if (v == null)
			return "0.00";
		StringBuffer str = new StringBuffer();
		str.append(v.intValue() / 100);
		str.append(".");
		int y = v.intValue() % 100;
		if (y < 10)
			str.append("0");
		str.append(y);
		return str.toString();
	}

	public static String getLevelImgurl(int level) {
		if (4 <= level && level <= 10)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_1_1.gif";
		if (11 <= level && level <= 40)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_1_2.gif";
		if (41 <= level && level <= 90)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_1_3.gif";
		if (91 <= level && level <= 150)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_1_4.gif";
		if (151 <= level && level <= 250)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_1_5.gif";
		if (251 <= level && level <= 500)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_2_1.gif";
		if (501 <= level && level <= 1000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_2_2.gif";
		if (1001 <= level && level <= 2000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_2_3.gif";
		if (2001 <= level && level <= 5000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_2_4.gif";
		if (5001 <= level && level <= 10000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_2_5.gif";
		if (10001 <= level && level <= 20000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_3_1.gif";
		if (20001 <= level && level <= 50000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_3_2.gif";
		if (50001 <= level && level <= 100000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_3_3.gif";
		if (100001 <= level && level <= 200000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_3_4.gif";
		if (200001 <= level && level <= 500000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_3_5.gif";
		if (500001 <= level && level <= 1000000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_4_1.gif";
		if (1000001 <= level && level <= 2000000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_4_2.gif";
		if (2000001 <= level && level <= 5000000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_4_3.gif";
		if (5000001 <= level && level <= 10000000)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_4_4.gif";
		if (10000001 <= level)
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_4_5.gif";
		return "";
	}

	public static String getBuyerLevelImgurl(int level) {
		switch (level) {
		case 1:
			return "http://pics.taobaocdn.com/newrank/b_red_1.gif";
		case 2:
			return "http://pics.taobaocdn.com/newrank/b_red_2.gif";
		case 3:
			return "http://pics.taobaocdn.com/newrank/b_red_3.gif";
		case 4:
			return "http://pics.taobaocdn.com/newrank/b_red_4.gif";
		case 5:
			return "http://pics.taobaocdn.com/newrank/b_red_5.gif";
		case 6:
			return "http://pics.taobaocdn.com/newrank/b_blue_1.gif";
		case 7:
			return "http://pics.taobaocdn.com/newrank/b_blue_2.gif";
		case 8:
			return "http://pics.taobaocdn.com/newrank/b_blue_3.gif";
		case 9:
			return "http://pics.taobaocdn.com/newrank/b_blue_4.gif";
		case 10:
			return "http://pics.taobaocdn.com/newrank/b_blue_5.gif";
		case 11:
			return "http://pics.taobaocdn.com/newrank/b_cap_1.gif";
		case 12:
			return "http://pics.taobaocdn.com/newrank/b_cap_2.gif";
		case 13:
			return "http://pics.taobaocdn.com/newrank/b_cap_3.gif";
		case 14:
			return "http://pics.taobaocdn.com/newrank/b_cap_4.gif";
		case 15:
			return "http://pics.taobaocdn.com/newrank/b_cap_5.gif";
		case 16:
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_4_1.gif";
		case 17:
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_4_2.gif";
		case 18:
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_4_3.gif";
		case 19:
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_4_4.gif";
		case 20:
			return "http://a.tbcdn.cn/sys/common/icon/rank/b_4_5.gif";
		}
		return "";
	}

	private static Map<Integer,String> buyerLevelImgUrlMap;
	public static Map<Integer,String> getBuyerLevelImgurls() {
		if(buyerLevelImgUrlMap ==null){
			buyerLevelImgUrlMap = new HashMap<Integer, String>();
			buyerLevelImgUrlMap.put(1, "http://pics.taobaocdn.com/newrank/b_red_1.gif");
			buyerLevelImgUrlMap.put(2, "http://pics.taobaocdn.com/newrank/b_red_2.gif");
			buyerLevelImgUrlMap.put(3, "http://pics.taobaocdn.com/newrank/b_red_3.gif");
			buyerLevelImgUrlMap.put(4, "http://pics.taobaocdn.com/newrank/b_red_4.gif");
			buyerLevelImgUrlMap.put(5, "http://pics.taobaocdn.com/newrank/b_red_5.gif");

			buyerLevelImgUrlMap.put(6, "http://pics.taobaocdn.com/newrank/b_blue_1.gif");
			buyerLevelImgUrlMap.put(7, "http://pics.taobaocdn.com/newrank/b_blue_2.gif");
			buyerLevelImgUrlMap.put(8, "http://pics.taobaocdn.com/newrank/b_blue_3.gif");
			buyerLevelImgUrlMap.put(9, "http://pics.taobaocdn.com/newrank/b_blue_4.gif");
			buyerLevelImgUrlMap.put(10, "http://pics.taobaocdn.com/newrank/b_blue_5.gif");

			buyerLevelImgUrlMap.put(11, "http://pics.taobaocdn.com/newrank/b_cap_1.gif");
			buyerLevelImgUrlMap.put(12, "http://pics.taobaocdn.com/newrank/b_cap_2.gif");
			buyerLevelImgUrlMap.put(13, "http://pics.taobaocdn.com/newrank/b_cap_3.gif");
			buyerLevelImgUrlMap.put(14, "http://pics.taobaocdn.com/newrank/b_cap_4.gif");
			buyerLevelImgUrlMap.put(15, "http://pics.taobaocdn.com/newrank/b_cap_5.gif");

			buyerLevelImgUrlMap.put(16, "http://a.tbcdn.cn/sys/common/icon/rank/b_4_1.gif");
			buyerLevelImgUrlMap.put(17, "http://a.tbcdn.cn/sys/common/icon/rank/b_4_2.gif");
			buyerLevelImgUrlMap.put(18, "http://a.tbcdn.cn/sys/common/icon/rank/b_4_3.gif");
			buyerLevelImgUrlMap.put(19, "http://a.tbcdn.cn/sys/common/icon/rank/b_4_4.gif");
			buyerLevelImgUrlMap.put(20, "http://a.tbcdn.cn/sys/common/icon/rank/b_4_5.gif");
		}
		return buyerLevelImgUrlMap;
	}
	private static Map<Integer,String> buyerLevelNameMap;
	public static Map<Integer,String> getBuyerLevelNames() {
		if(buyerLevelNameMap ==null){
			buyerLevelNameMap = new HashMap<Integer, String>();
			buyerLevelNameMap.put(1, "1心");
			buyerLevelNameMap.put(2, "2心");
			buyerLevelNameMap.put(3, "3心");
			buyerLevelNameMap.put(4, "4心");
			buyerLevelNameMap.put(5, "5心");

			buyerLevelNameMap.put(6, "1钻");
			buyerLevelNameMap.put(7, "2钻");
			buyerLevelNameMap.put(8, "3钻");
			buyerLevelNameMap.put(9, "4钻");
			buyerLevelNameMap.put(10, "5钻");

			buyerLevelNameMap.put(11, "1皇冠");
			buyerLevelNameMap.put(12, "2皇冠");
			buyerLevelNameMap.put(13, "3皇冠");
			buyerLevelNameMap.put(14, "4皇冠");
			buyerLevelNameMap.put(15, "5皇冠");
		}
		return buyerLevelNameMap;
	}

	/**
	 * 去掉Date中的时分秒 00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date clearHms(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	public static Date clearHms(Calendar c) {
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	/**
	 * 得到减去天数day的日期
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date subDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, 0 - day);
		return c.getTime();
	}

	/**
	 * 得到加上天数day的日期
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, day);
		return c.getTime();
	}

	public static int priceToInt(String price) {
		if (price == null)
			return 0;

		int index = price.indexOf('.');
		try {
			if (index != -1) {
				int len = price.length() - index - 1;
				price = price.replace(".", "");
				if (len < 2) {
					for (int i = 0; i < 2 - len; i++) {
						price += "0";
					}
				} else if (len > 2) {
					price = price.substring(0, price.length() - len + 2);
				}
			} else {
				price += "00";
			}
			return Integer.parseInt(price);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean isPhonenumber(String number) {
		if (number == null || "".equals(number)) {
			return false;
		}
		Pattern pattern = Pattern.compile(
				"^((\\+86)|(86))?(1(3|4|5|6|7|8|9))\\d{9}$", Pattern.DOTALL);
		Matcher m = pattern.matcher(number);
		return m.matches();
	}

	public static float roundFloat(float f,int vi){
		double v=Math.pow(10,vi);
		return (float) (Math.round(f*v)/v);
	}
	public static Object jsonToObject(String json,Class<?> type){
		Gson gson=null;
		GsonBuilder builder=new GsonBuilder();
		gson=builder.create();
		return gson.fromJson(json, type);
	}
	public static String objectToJson(Object obj){
		Gson gson=null;
		GsonBuilder builder=new GsonBuilder();
		gson=builder.create();
		return gson.toJson(obj);
	}
	public static String getIpAddr(HttpServletRequest request) {
		String ip = null;
		Enumeration<?> enu = request.getHeaderNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			if (name.equalsIgnoreCase("X-Forwarded-For"))
				ip = request.getHeader(name);
			else if (name.equalsIgnoreCase("Proxy-Client-IP"))
				ip = request.getHeader(name);
			else if (name.equalsIgnoreCase("WL-Proxy-Client-IP")) {
				ip = request.getHeader(name);
			}

			if ((ip != null) && (ip.length() != 0)) {
				break;
			}
		}
		if ((ip == null) || (ip.length() == 0)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
