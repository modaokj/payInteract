package com.softright.tbcards.bo;

import java.util.HashMap;
import java.util.Map;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayOfflineMarketProductBatchqueryRequest;
import com.alipay.api.response.AlipayOfflineMarketProductBatchqueryResponse;
import com.google.gson.Gson;
import com.softright.tbcards.Constants;



/**
 * 订单接口bo
 * @author conan
 *
 */
public class TaobaoApiBo {
	public static String getjsonstr(Map map){
		  Gson gson = new Gson();
          String pms = gson.toJson(map);
         return pms;
	}
	  public  static AlipayOfflineMarketProductBatchqueryResponse getGoods(Map map) {
		  AlipayOfflineMarketProductBatchqueryRequest request = new AlipayOfflineMarketProductBatchqueryRequest();
		  request.setBizContent(getjsonstr(map));
		  AlipayOfflineMarketProductBatchqueryResponse response=null;
		  try {
			   response = AlipayAPIClientFactory.getAlipayClient().execute(request);
		  } catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			  e.printStackTrace();
		   }
		return response;
	}
}
