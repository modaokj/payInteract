package com.softright.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Lz77 {
	public static char[] NC= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&*()-=[];',./_+{}|:\"<>?".toCharArray();
	public static Map<Character,Integer> CN = new HashMap<Character,Integer>(); 
	static{
		for(int i =0;i<NC.length;i++){
			CN.put(NC[i],i);
		}
	}
	public static String Lz77Decompress(char[] input) 
	{ 
	    /*LZ77解压缩算法 - Hutia - JS版*/ 
	     
	    /*变量声明*/ 
	    int p = 0; //扫描指针 
	    int len = input.length; //输入字符串的长度 
	    StringBuffer output= new StringBuffer();
	    int match_off = 0; //匹配位置的偏移量 
	    int match_len = 0; //发生匹配的长度 
	     
	    /*循环扫描*/ 
	    for (p=0; p<len; p++) 
	    { 
	        if (input[p]== '`') //如果发现前缀标记 
	        { 
	            if (input[p + 1] == '`') //如果是转义前缀 
	            { 
	                output.append("`"); //直接输出字符 "`" 
	                p++; //指针后移，跳过下一个字符 
	            } 
	            else //如果是压缩编码 
	            { 
	                match_off = C2N(input[p+1]+""+input[p+2]+input[p+3]); //取出其 1-3 个字符，算出偏移量 
	                match_len = C2N(input[p+4]+""+input[p+5]); //取出其 4-5 字符，算出匹配长度 
	                output.append(output.substring(match_off, match_off + match_len));
	                p += 5; //指针后移，跳过下5个字符 
	            } 
	        } 
	        else //如果没有发现前缀标记 
	        { 
	            output.append(input[p]); //直接输出相应的字符 
	        } 
	    } 
	     
	    /*输出*/ 
	    return output.toString(); 
	} 
	public static int C2N(String c) //将 92 进制字符串（高位在右）转换为 10 进制数字 
	{ 
		char []ct = c.toCharArray();
	    int len = ct.length; 
	    int re = 0; 
	    for (int i=0; i<len; i++) 
	    {
	        re += CN.get(ct[i]) * Math.pow(92, i); 
	    } 
	    return re; 
	} 
	//获取昨天日期
	public static Date getYesterDay(){
		Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date d=cal.getTime();
      //获取昨天日期
		SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sp.parse(sp.format(d));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	public static Date getMothDay(){
		Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-30);
        Date d=cal.getTime();
		SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sp.parse(sp.format(d));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	public static Date getServenDay(){
		Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-7);
        Date d=cal.getTime();
		SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sp.parse(sp.format(d));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	public static long getToDayNum(String date){
		Calendar cal=Calendar.getInstance();
		 cal.add(Calendar.DATE,-1);
        Date d=cal.getTime();
		SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return (sp.parse(sp.format(d)).getTime()-sp.parse(date).getTime())/86400000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static Date getDyDay(String date){
		Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-7);
        Date d=cal.getTime();
		SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sp.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
}
