package com.softright.utils;

import java.util.Map;

import com.google.gson.GsonBuilder;


public class Gson {
	public static Object jsonToObject(String json,Class<?> type){
		com.google.gson.Gson gson=null;
		GsonBuilder builder=new GsonBuilder();
		gson=builder.create();
		return gson.fromJson(json, type);
	}
	public static String objectToJson(Object obj){
		com.google.gson.Gson gson=null;
		GsonBuilder builder=new GsonBuilder();
		gson=builder.create();
		return gson.toJson(obj);
	}
	public static String maptoJsonstr(Map map){
		GsonBuilder builder=new GsonBuilder();
		com.google.gson.Gson gson =builder.create();
       return gson.toJson(map);
	}
}
