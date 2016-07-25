package com.softright.tbcards.bo;

import org.apache.log4j.Logger;

import com.softright.tbcards.po.ApiOperation;

public class ApiBo {
	private static Logger logger = Logger.getLogger(ApiBo.class);
	public static void testApi() {
		ApiOperation apiOperation=new ApiOperation();
		apiOperation.setApi("测试");
		apiOperation.setContent("这是api调用参数内容");
		apiOperation.setResult("这是api返回数据");
		apiOperation.setOk_no("ok");
		ApiRecord.add(apiOperation);
	}
}
