package com.softright.tbcards.po.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the Vb_taobao_user table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Vb_taobao_user"
 */

public abstract class BaseUser  implements Serializable {

	public static String TAOBAOUSER = "TaobaoUser";
	public static String NICK="nick";
	public static String SESSIONKEY="sessionKey";
	public static String REFRESHTOKEN="refreshToken";
	public static String SHOPTYPE="shopType";
	public static String MOBILE="mobile";
	public static String SHOPNAME="shopName";
	public static String SHOPNUM="shopNum";
	public static String SHOPURL="shopUrl";
	public static String SHOPLOGO="shopLogo";
	public static String LEVEL="level";
	public static String REGISTTIME="registTime";
	public static String EXPIRESIN="expiresIn";
	public static String REEXPIRESIN="reExpiresIn";
	public static String REFRESHTIME="refreshTime";
	public static String SHOPIMGURL="shopImgUrl";
	public static String LASTLOGIN="lastLogin";
	public static String VIPTIME="vipTime";
	public static String EXPIRE_DATE="expire_date";
	

	// constructors
	public BaseUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUser (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUser (
		java.lang.String id,
		java.lang.String nick,
		java.lang.String shopType,
		java.util.Date lastLogin,
		java.util.Date vipTime,java.util.Date expire_date) {

		this.setId(id);
		this.setNick(nick);
		this.setShopType(shopType);
		this.setLastLogin(lastLogin);
        this.setVipTime(vipTime);	
        this.setExpire_date(expire_date);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String nick;
	private java.lang.String sessionKey;
	private java.lang.String refreshToken;
	private java.lang.String shopType;
	private java.lang.String mobile;
	private java.lang.String shopName;
	private java.lang.String shopNum;
	private java.lang.String shopUrl;
	private java.lang.String shopLogo;
	private java.lang.Integer level;
	private java.util.Date registTime;
	private java.lang.String expiresIn;
	private java.lang.String reExpiresIn;
	private java.util.Date refreshTime;
	private java.lang.String shopImgUrl;
	private java.util.Date lastLogin;
	private java.util.Date  vipTime;
	private java.util.Date expire_date;


	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public java.lang.String getId() {
		return id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getNick() {
		return nick;
	}

	public void setNick(java.lang.String nick) {
		this.nick = nick;
	}

	public java.lang.String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(java.lang.String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public java.lang.String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(java.lang.String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public java.lang.String getShopType() {
		return shopType;
	}

	public void setShopType(java.lang.String shopType) {
		this.shopType = shopType;
	}

	public java.lang.String getMobile() {
		return mobile;
	}

	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	public java.lang.String getShopName() {
		return shopName;
	}

	public void setShopName(java.lang.String shopName) {
		this.shopName = shopName;
	}

	public java.lang.String getShopNum() {
		return shopNum;
	}

	public void setShopNum(java.lang.String shopNum) {
		this.shopNum = shopNum;
	}

	public java.lang.String getShopUrl() {
		return shopUrl;
	}

	public void setShopUrl(java.lang.String shopUrl) {
		this.shopUrl = shopUrl;
	}

	public java.lang.String getShopLogo() {
		return shopLogo;
	}

	public void setShopLogo(java.lang.String shopLogo) {
		this.shopLogo = shopLogo;
	}

	public java.lang.Integer getLevel() {
		return level;
	}

	public void setLevel(java.lang.Integer level) {
		this.level = level;
	}

	public java.util.Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(java.util.Date registTime) {
		this.registTime = registTime;
	}

	public java.lang.String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(java.lang.String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public java.lang.String getReExpiresIn() {
		return reExpiresIn;
	}

	public void setReExpiresIn(java.lang.String reExpiresIn) {
		this.reExpiresIn = reExpiresIn;
	}

	public java.util.Date getRefreshTime() {
		return refreshTime;
	}

	public void setRefreshTime(java.util.Date refreshTime) {
		this.refreshTime = refreshTime;
	}

	public java.lang.String getShopImgUrl() {
		return shopImgUrl;
	}

	public void setShopImgUrl(java.lang.String shopImgUrl) {
		this.shopImgUrl = shopImgUrl;
	}

	public java.util.Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(java.util.Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public java.util.Date getVipTime() {
		return vipTime;
	}

	public void setVipTime(java.util.Date vipTime) {
		this.vipTime = vipTime;
	}

	public java.util.Date getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(java.util.Date expire_date) {
		this.expire_date = expire_date;
	}

	


}