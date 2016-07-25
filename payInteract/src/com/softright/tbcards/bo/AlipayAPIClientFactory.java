/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.softright.tbcards.bo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.softright.tbcards.Constants;


/**
 * API调用客户端工厂
 * 
 * @author taixu.zqq
 * @version $Id: AlipayAPIClientFactory.java, v 0.1 2014年7月23日 下午5:07:45 taixu.zqq Exp $
 */
public class AlipayAPIClientFactory {
	private static  Log logger = LogFactory.getLog(AlipayAPIClientFactory.class);
    /** API调用客户端 */
    private static AlipayClient alipayClient;
    
    /**
     * 获得API调用客户端
     */
    public static AlipayClient getAlipayClient(){
        if(null == alipayClient){
            alipayClient = new DefaultAlipayClient(Constants.ALIPAY_GATEWAY, Constants.APPID, 
            		Constants.PRIVATE_KEY, "json", Constants.CHARSET,Constants.ALIPAY_PUBLIC_KEY);
        }
        return alipayClient;
    }
}
