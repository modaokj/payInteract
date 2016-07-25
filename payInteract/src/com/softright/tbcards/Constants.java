package com.softright.tbcards;

import javax.servlet.http.HttpServletRequest;


public class Constants {
	/*************************************
	 * 以下为支付宝平台内容
	 */
	 //私钥
    public static final String PRIVATE_KEY       = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALLBKi1P+Cdt7TSjyIMfQyowufsl6xm3yV3Ko876dAcKxOEq6sF8Uj3fvthZhfYpQWFehQlq/oyHaB8aJ+InEVpASBwdIol+UsD7HuYJx/UHOPYLXPaA1g+Ntoqq3EhVPoUZ7oZXOYsfuKbeKLzszTp9zi78Kryi8qk36EqbngFrAgMBAAECgYAkQ+w6pS7DURn+w/u6Hm2R8bDJszevUAoabTIum8FObHDk/cAC4SYOR4aAfikfd9870eFLt9lMyWvmY3gT+bkbL2nRz8pgaeZSx895cO7BIlGbWuKN7fG8aOno4+zxQ+Vo+SBwJyrhdFaVQFNE7C+5d+eEZoNQGrKRt/ySdfCoAQJBAOBGAv6h4I6aXDdZo0yAtYWL7Kf0QjutZWqPkGBfVRJ4J5DWJW9//GhsxhrXEjvSAz50KCeqaIfJ+t1jCJ8I9CsCQQDMCrNGAgrRZoNMgcVZncYb9mZ9onNCZImV8BuaeNhxeMs75fxUkQkIKX+XGh1NFF45esChNuHaag8wqCz9ckfBAkEAwpqdkJugQb0ZVYH3W7O3TulKcbZWHnhoLt3h9m3iYMNX+aqIE0coGuh/wdxrWvLxk6ixCzInv+P4RU/gtDbNvwJBAJuc9YjI+fMl2bE5r4dfWr3st9HNWVYjUwM1MfgnfftcgrNV/ZGJY3gEHjjhQ8OLaykvQ0YwkyN+i8MyH83ToIECQFv+tFlo9CFxf/6H7ZVzMUDHSoBpp0tCw9w60kVlch4kXX+i/KWJEgMKxp4NqkEvaDfduC4LPwIUl18Zw27vmyY=";
    //公钥
    public static final String PUBLIC_KEY        = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCywSotT/gnbe00o8iDH0MqMLn7JesZt8ldyqPO+nQHCsThKurBfFI9377YWYX2KUFhXoUJav6Mh2gfGifiJxFaQEgcHSKJflLA+x7mCcf1Bzj2C1z2gNYPjbaKqtxIVT6FGe6GVzmLH7im3ii87M06fc4u/Cq8ovKpN+hKm54BawIDAQAB";
    /**支付宝网关*/
    public static final String ALIPAY_GATEWAY    = "https://openapi.alipay.com/gateway.do";
    /**授权访问令牌的授权类型*/
    public static final String GRANT_TYPE        = "authorization_code";
    /**支付宝公钥-从支付宝服务窗获取*/
    public static final String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
    /**签名编码-视支付宝服务窗要求*/
    public static final String SIGN_CHARSET      = "GBK";
    /**字符编码-传递给支付宝的数据编码*/
    public static final String CHARSET           = "GBK";
    /**签名类型-视支付宝服务窗要求*/
    public static final String SIGN_TYPE         = "RSA";
    /*****
     * appid
     */
	public static final String APPID = "2016021901150650";
	
	/******
	 * 活动图片存放的地址
	 */
	public static final String CODEIMG = "/codeImg/";
	//获取用户信息
	public static final String yhauth_url="https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id="+Constants.APPID+"&scope=SCOPE&redirect_uri="+Constants.HOST_CESHI;
	
	
	/********
	 * 无线前端
	 */
	public static final  String  LOTTERY_URL = "m.wowlg.com";//抽奖
	public static final  String  LOTTERY_ACTION_URL="/wap/WxYyyMain.h4";//抽奖请求的action
	
	/*****
	 * 静态参数
	 */
	public static String  T= "T";
	public static String  F= "F";
	
	/*********
	 * !===================================
	 */
	
	
	
	public static final String   CORP_PUB_ID="2088601221712257";//公司账户
	public final static String NICKS="2601662241,775403680";
	/**
	 * 应用入口
	 */
	public final static String TOPIC_TRADE_TRADERATED = "taobao_trade_TradeRated";
	public final static String TOPIC_TRADE_TRADEBUYERPAY = "taobao_trade_TradeBuyerPay";
	public final static String TAOBAO_TRADE_TRADESUCCESS = "taobao_trade_TradeSuccess";
	
	
	public static boolean test;
	public static boolean debug;
	public static int sms_tunnel=-1;
	public static boolean service = true;
	public final static int MAX_SEND = 10;
	public final static int PAGE_VOLUME = 2;
	public final static int COOKIE_TIME = 0;
	public final static int COOKIE_TIME_VISIT = 60 * 10;
	public final static String COOKIEDOMAIN = "tb.card.cd";
	public final static String CARDDOMAIN = "card.cd";
	public final static String TB_CHARGE_CODE = "ts-17458";//淘名片收费代码
	
	public final static String FORMAL_HOST = "http://tb.card.cd/";
	public static final String HTTP_USER_AGENT = "User-Agent";
	public static final String ACTION_USER_AGENT = "user-agent";
	
	
	public static String QT_APP_KEY = "23087027";
	public static String APP_KEY = "23086820";
	public static String apiUrl = "http://gw.api.taobao.com/router/rest";
	public static String APP_Secret = "2368918e8d156871943bedbcd1bc5713";
	
	public static final  String  HOST_CESHI = "http://vzan-1.play.admin.jaeapp.com";//
	public static String vipdate ="2015-09-02 14:15:01";
	public static String SERVICEID ="FW_GOODS-1000036125";
	public static String VIP_SERVICEID ="FW_GOODS-1000036125-v2";
	
	public static final String PATTERN_EMAIL = "[\\w\\._-]+@[\\w-_\\.]+{1,3}\\w+";
	public static final String PATTERN_HTTP = "\\s*http://[\\w-_\\.]+{1,5}\\w+/?.*";
	public static final String PATTERN_MOBILE = "\\d{11}";
	public static final String PATTERN_PHONE = "\\d+\\-?\\d+";
	public static final String PATTERN_PRICE = "\\d+\\.?\\d{2}?";
	public static final String PASSPORT_COOKIE_NAME = "vmsessinon";
	public static final String PASSPORT_COOKIE_DMAIN = "";
	public static final String SUB_ID_COOKIE_NAME = "tbcardsubid";//子帐号ID

	/***
	 * 无线前端
	 */
	public static final  String  LOCALHOST_WAP = "192.168.1.1";//摇一摇无线前端(测试路径)
	public static final  String  WXQD_URL_CESHI = "vzan-1.play.m.jaeapp.com";//摇一摇无线前端(测试路径)
	public static final  String  WXQD_URL = "vzan.play.m.jaeapp.com";//摇一摇无线前端(正式路径)
	public static final  String  WXYYY_URL="/wap/WxYyyMain.h4";//无线前端的请求action
	public static final  String  WXYYY_TKL_URL="/wap/WxTklMain.h4";//无线前端(淘口令活动)的请求action
	public static final  String  WXYYY_CYC_URL="/wap/WxCycMain.h4";//无线前端(吹一吹活动)的请求action
	public static final  String  WXYYY_KJ_URL="/wap/bargain/WxKJMain.h4";//无线前端(砍价活动)的请求action
	public static final  String  WXYYY_KJQR_URL="/wap/bargain/WxKJQR.h4";//无线前端(砍价活动)的请求action
	public static final  String  WXREDURL="http://jump.app.jae.m.taobao.com/?redirectUrl=http%3a%2f%2fma.taobao.com%2f";
	public static final String   CORP_ID="775403680";//小玲店子id，为展示二维码设计  唯一能创建2个活动
	public static final String   CORP_TKL_ID="61503608";//娇英店子id  为展示二维码设计
	
	/**
	 * 统计相关
	 */
	public static final String TEMP_IMAGE_PATH="D:/tempimg/";//本地零时图片存储点
	public static final String TAOBAO_SYS_IMAGE_PATH="D:/tempimg/taobaoimg/";//
	public static final String CAED_VISIT_NUM = "d3"; // 店铺名片被访问次数 Field
	public static final String SMS_TRADE_NUM = "d4";
	public static final String SHARE_NUM = "d5"; // 分享次数
	
	public static String getGoodsUrlById(String shoptype,Long goodsid){
		if(shoptype.equals("C")){
			return "http://item.taobao.com/item.htm?id="+goodsid;
		}else {
			return "http://detail.tmall.com/item.htm?id="+goodsid;
		}
	}
	
	public static String WZZ_IMG_FILE_PATH="";
	public static String WZZ_IMG_URL="";
	
	public static String WZZ_STATUS_DEL="D";//删除
	public static String WZZ_STATUS_SCK="S";//素材库特有
	public static String WZZ_STATUS_VALID="I";//有效
	
	public static String WZZ_PUBLIE_WAIT="W";//等待审核
	public static String WZZ_PUBLIE_DENY="D";//不通过
	public static String WZZ_PUBLIE_TRUE="T";//审核通过
	public static String WZZ_PUBLIE_FALSE="F";//不公开
	
	
	public static String getAppCallUrl(HttpServletRequest request){
//		request.get
		StringBuffer url = request.getRequestURL();
		String host = url.substring(0, url.indexOf("/",8));
		System.out.println(host);
		return host+"/TaobaoEntry.h4";
//		public static String APP_AUTH_CALLURL = "http://vzan.play.admin.jaeapp.com/TaobaoEntry.h4";
//		if(shoptype.equals("C")){
//			return "http://item.taobao.com/item.htm?id="+goodsid;
//		}else {
//			return "http://detail.tmall.com/item.htm?id="+goodsid;
//		}
	}
}