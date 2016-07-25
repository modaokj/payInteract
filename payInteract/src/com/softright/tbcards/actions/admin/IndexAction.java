package com.softright.tbcards.actions.admin;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import com.google.gson.annotations.Expose;
import com.handwin.db.DataService;
import com.handwin.web.json.TransactionAction;
import com.softright.tbcards.Constants;
import com.softright.tbcards.PassportNew;
import com.softright.tbcards.po.User;
import com.softright.utils.DateSystem;

public class  IndexAction extends TransactionAction {
	private static Logger logger = Logger.getLogger(IndexAction.class);
	@Override
	public Object exec() throws Exception {
		    DataService dao = new DataService();
        	Result rlt= new Result();
        	PassportNew ppt = PassportNew.fromString(this.getCookieValue(Constants.PASSPORT_COOKIE_NAME));
        	User user = (User) dao.locate(User.class,ppt.getId());
        	//获得版本
	       	 Isvip(dao, user,rlt);
	       	 rlt.setValidity(validity(dao,user));
        	if(null==user){
        		setRedirect("404");
        		return rlt;
        	}
        	rlt.setUserName(user.getNick());
        	setRedirect("admin/buyer_index");
        	return rlt;
	}
	//计算账号的有效期
    private String validity(DataService dao,User user){
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
		       		user.setVipTime(c.getTime());
				}else {
					v="请稍后，正在获取中...";
				}
	    	}
	    	user.setExpire_date(user.getVipTime());
	    	dao.save(user);
			dao.commit();
    	} catch (Exception e) {
			// TODO: handle exception
			v="请稍后，正在获取中...";
		}
    	this.logger.warn("账户["+user.getId()+"]过期时间："+v);
    	return v;
    }
	/*******
     * 获得订购版本  默认vip时间是5年
     * @param dao
     * @param user
     * @param rlt
     */
    private  void Isvip(DataService dao,User user,Result rlt){
    	if (null==user.getVipTime()) {
    		Date vipTime=DateUtils.addYears(user.getRegistTime(), 5);
        	user.setVipTime(vipTime);
        	dao.save(user);
		}
    }
	@Override
	public Object onTransactionException(Exception arg0) {
		return null;
	}
	public class Result{
		@Expose
		private String validity;
		@Expose
		private String userName;
		@Expose
		private int status;
		@Expose
		private String ewm_url;
		@Expose
		private  boolean vip_3;
		@Expose
		private  String v_date;
		@Expose
		private int status_tkl;
		@Expose
		private  String ewm_tkl_url;
		@Expose
		private int opType;
		@Expose
		private int opTypeC;
		@Expose
		private int status_cyc;
		@Expose
		private  String ewm_cyc_url;
		@Expose
		private int status_kj;
		@Expose
		private  String ewm_kj_url;
		
		public int getStatus_kj() {
			return status_kj;
		}
		public void setStatus_kj(int status_kj) {
			this.status_kj = status_kj;
		}
		public String getEwm_kj_url() {
			return ewm_kj_url;
		}
		public void setEwm_kj_url(String ewm_kj_url) {
			this.ewm_kj_url = ewm_kj_url;
		}
		public int getStatus_cyc() {
			return status_cyc;
		}
		public void setStatus_cyc(int status_cyc) {
			this.status_cyc = status_cyc;
		}
		public String getEwm_cyc_url() {
			return ewm_cyc_url;
		}
		public void setEwm_cyc_url(String ewm_cyc_url) {
			this.ewm_cyc_url = ewm_cyc_url;
		}
		public int getOpTypeC() {
			return opTypeC;
		}
		public void setOpTypeC(int opTypeC) {
			this.opTypeC = opTypeC;
		}
		public int getOpType() {
			return opType;
		}
		public void setOpType(int opType) {
			this.opType = opType;
		}
		public String getEwm_tkl_url() {
			return ewm_tkl_url;
		}
		public void setEwm_tkl_url(String ewm_tkl_url) {
			this.ewm_tkl_url = ewm_tkl_url;
		}
		public int getStatus_tkl() {
			return status_tkl;
		}
		public void setStatus_tkl(int status_tkl) {
			this.status_tkl = status_tkl;
		}
		public String getV_date() {
			return v_date;
		}
		public void setV_date(String v_date) {
			this.v_date = v_date;
		}
		public boolean isVip_3() {
			return vip_3;
		}
		public void setVip_3(boolean vip_3) {
			this.vip_3 = vip_3;
		}
		public String getEwm_url() {
			return ewm_url;
		}
		public void setEwm_url(String ewm_url) {
			this.ewm_url = ewm_url;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getValidity() {
			return validity;
		}
		public void setValidity(String validity) {
			this.validity = validity;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}

	}
}
