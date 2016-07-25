package com.softright.tbcards.actions;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.google.gson.Gson;
import com.handwin.db.DataService;
import com.handwin.web.json.ActionTools;
import com.handwin.web.json.FormField;
import com.handwin.web.json.JsonAction;
import com.handwin.web.json.TransactionAction;
import com.softright.tbcards.Constants;
import com.softright.tbcards.LoginUserUtil;
import com.softright.tbcards.PassportNew;
import com.softright.tbcards.bo.AlipayAPIClientFactory;
import com.softright.tbcards.po.User;
/**
 * 认证登录流程
 * https://doc.open.alipay.com/doc2/detail.htm?treeId=115&articleId=104110&docType=1
 * 
 * @author conan
 *
 */
public class TaobaoEntryAction extends TransactionAction {
	private Log logger = LogFactory.getLog(TaobaoEntryAction.class);
	//商户访问
	private static final String shauth_url="https://openauth.alipay.com/oauth2/appToAppAuth.htm?app_id="+Constants.APPID+"&redirect_uri="+Constants.HOST_CESHI;
	@FormField(name = "app_auth_code", required = false)
	private String app_auth_code;

	@Override
	public Object exec() throws Exception {
		try {
			if(StringUtils.isBlank(app_auth_code)){
				logger.error("用户授权异常");
				JsonAction.setRedirect(shauth_url);
				return "您未正确授权，请再次授权";
			}else {
				try {
					
					LoginUserUtil.logining(app_auth_code);
	                AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient();
	                AlipayOpenAuthTokenAppRequest userinfoShareRequest = new AlipayOpenAuthTokenAppRequest();
	                Gson gson = new Gson();
	                Map map=new HashMap();
	                map.put("grant_type", Constants.GRANT_TYPE);
	                map.put("code", app_auth_code);
	                String pms = gson.toJson(map);
	                userinfoShareRequest.setBizContent(pms);
	                AlipayOpenAuthTokenAppResponse userinfo = alipayClient.execute(userinfoShareRequest);
	                //成功获得用户信息
	                if (null != userinfo && userinfo.isSuccess()) {
	                    //这里仅是简单打印， 请开发者按实际情况自行进行处理
	                	logger.info("获取用户信息成功：" + userinfo.getBody());
	                	TopUser topuser=new TopUser();
	                	topuser.setId(userinfo.getUserId());
	                	topuser.setSession_key(userinfo.getAppAuthToken());
	                	topuser.setRefresh_token(userinfo.getAppRefreshToken());
	                	topuser.setExpires_in(userinfo.getExpiresIn());
	                	DataService dao = new DataService();
	                	try {
		                	User user = (User) dao.locate(User.class, topuser.getId());
		                	// 判断是否为新用户
		        			if (user == null) {// 新用户
		        				user = reigster(topuser, dao);
		        				if (user == null) {
		        					this.logger.error("登陆出错，请从alipay应用重新登陆本系统1");
		        					JsonAction.setRedirect("jsps/error");
		        					return "登陆出错，请从alipay应用重新登陆本系统1";
		        				}
		        			} else {
		        				updateSession(topuser, dao, user);
		        			}
		        			// 生成登陆的cookie
		        			putPassport(user.getId(), user.getId(), "");
		        			logger.info(topuser.getId()+" 跳转到登录页面");
		        			String userHome = "http://"+ ActionTools.getClientInfo().getHost()+ this.getRequest().getContextPath()+ "/admin/Index.h4";
		        			// 跳转到登录页面
		        			JsonAction.setRedirect(userHome);
		        			logger.info(" sessionKey:" + topuser.getSession_key()+ " refreshToken:" + topuser.getRefresh_token());
		        			dao.commit();
		        			logger.info(topuser.getId()+" 正常提交---==");
						} catch (Exception e) {
							// TODO: handle exception
							if(dao!=null){
								dao.rollBack();
							}
							e.printStackTrace();
							this.logger.error("登陆出错，请从alipay应用重新登陆本系统2:"+e);
							JsonAction.setRedirect("jsps/error");
							return "登陆出错，请从alipay应用重新登陆本系统2";
						}finally {
							if(dao!=null){
								dao.close();
							}
						}
	                } else {
	                	logger.error("获取用户信息失败");
	    				JsonAction.setRedirect(shauth_url);
	                }
		        } catch (Exception e) {
		        	  logger.error("alipay授权相关接口调用异常："+e);
		        	  JsonAction.setRedirect(shauth_url);
		        }
			}
		}finally{
			LoginUserUtil.loginFinish(app_auth_code);
		}
			
		return null;
	}
	/******
	 * 页面端生成Cookie
	 * @param userId
	 * @param subId
	 * @param partitionId
	 * @return
	 */
	private String putPassport(String userId, String subId, String partitionId) {
		PassportNew passport = new PassportNew(userId, subId, partitionId,"cardid");
		String ppt = passport.toString();
		Cookie cookie = new Cookie(Constants.PASSPORT_COOKIE_NAME, ppt);
		cookie.setPath("/");
		JsonAction.addCookie(cookie);
		return ppt;
	}
	/*********
	 * 修改
	 * @param tUser
	 * @param dao
	 * @param user
	 */
	private void updateSession(TopUser tUser, DataService dao,User user) {
		user.setSessionKey(tUser.getSession_key());
		user.setRefreshToken(tUser.getRefresh_token());
		user.setExpiresIn(tUser.getExpires_in());
		user.setReExpiresIn(tUser.getExpires_in());
		user.setLastLogin(new Date());
		dao.save(user);
	}
	/**
	 * @param tUser
	 * @param dao
	 * @param seller
	 * @return 返回空表示失败
	 * @throws Exception
	 */
	private User reigster(TopUser tUser, DataService dao) throws Exception {
		User user = new User();
		user.setId(tUser.getId());
		user.setSessionKey(tUser.getSession_key());
		user.setRefreshToken(tUser.getRefresh_token());
		user.setExpiresIn(tUser.getExpires_in());
		user.setReExpiresIn(tUser.getExpires_in());
		user.setRegistTime(new Date());
		user.setLastLogin(new Date());
		dao.save(user);
		return user;
	}
	@Override
	public Object onTransactionException(Exception e) {
		JsonAction.setRedirect("jsps/error");
		logger.error(e.getMessage(), e);
		return "系统异常请重试";
	}

	@Override
	public Object onInputError(String errorMsg) {
		JsonAction.setRedirect("jsps/error");
		logger.error(errorMsg);
		return "系统异常请重试";
	}
	
	private  class TopUser {
		public String id = "";
		public String nick = "";
		public String session_key = "";
		public String refresh_token = "";
		public String shop_type = "";
		public String mobile = "";
		public String shop_name = "";
		public String shop_num = "";
		public String shop_url = "";
		public String level = "";
		public String regist_time = "";
		public String expires_in = "";
		public String last_login = "";
		public String vipTime = "";
		public String expire_date = "";
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNick() {
			return nick;
		}
		public void setNick(String nick) {
			this.nick = nick;
		}
		public String getSession_key() {
			return session_key;
		}
		public void setSession_key(String session_key) {
			this.session_key = session_key;
		}
		public String getRefresh_token() {
			return refresh_token;
		}
		public void setRefresh_token(String refresh_token) {
			this.refresh_token = refresh_token;
		}
		public String getShop_type() {
			return shop_type;
		}
		public void setShop_type(String shop_type) {
			this.shop_type = shop_type;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getShop_name() {
			return shop_name;
		}
		public void setShop_name(String shop_name) {
			this.shop_name = shop_name;
		}
		public String getShop_num() {
			return shop_num;
		}
		public void setShop_num(String shop_num) {
			this.shop_num = shop_num;
		}
		public String getShop_url() {
			return shop_url;
		}
		public void setShop_url(String shop_url) {
			this.shop_url = shop_url;
		}
		public String getLevel() {
			return level;
		}
		public void setLevel(String level) {
			this.level = level;
		}
		public String getRegist_time() {
			return regist_time;
		}
		public void setRegist_time(String regist_time) {
			this.regist_time = regist_time;
		}
		public String getExpires_in() {
			return expires_in;
		}
		public void setExpires_in(String expires_in) {
			this.expires_in = expires_in;
		}
		public String getLast_login() {
			return last_login;
		}
		public void setLast_login(String last_login) {
			this.last_login = last_login;
		}
		public String getVipTime() {
			return vipTime;
		}
		public void setVipTime(String vipTime) {
			this.vipTime = vipTime;
		}
		public String getExpire_date() {
			return expire_date;
		}
		public void setExpire_date(String expire_date) {
			this.expire_date = expire_date;
		}
		
	}
}
