package com.softright.tbcards.actions.wap;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.annotations.Expose;
import com.handwin.web.json.TransactionAction;

public class TestAction extends TransactionAction{
	private static Logger logger = Logger.getLogger(TestAction.class);
	@Override
	public Object exec() throws Exception {
		Result rlt =new Result();
		this.logger.error("进入测试action");
		setRedirect("wap/test");
		return rlt;
	}

	@Override
	public Object onTransactionException(Exception arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public class Result{
		@Expose
		private String shopname;
		@Expose
		private int lotteryNumber;
		@Expose
		private String resText;
		@Expose
		private String activity_id;
		@Expose
		private String user_id;
		@Expose
		private String user_name;
		@Expose
		private String activity_hdsm;
		@Expose
		private int res;
		@Expose
		private String activity_url;
		@Expose
		private String  shopNum;
		@Expose
		private String  fx_li;
		@Expose
		private String  sc_li;
		@Expose
		private String  gz_li;
		@Expose
		private String  jrgwc_li;
		@Expose
		private String activity_name;
		@Expose
		private String jp_imgurl;
		@Expose
		private String yd_imgurl;
		@Expose
		private String bj_imgurl;
		@Expose
		private String template_id;//使用的是哪个系统模板标准
		@Expose
		private String notice;//滚动字幕
		@Expose
		private String shop_url;//店铺id
		@Expose
		private String tkllr;//淘口令
		@Expose
		private String  sc_li1;
		@Expose
		private String  sc_li2;
		@Expose
		private String fxlogurl;
		@Expose
		private boolean fg;
		@Expose
		private boolean fgzjjl;
		
		public boolean isFgzjjl() {
			return fgzjjl;
		}
		public void setFgzjjl(boolean fgzjjl) {
			this.fgzjjl = fgzjjl;
		}
		public boolean isFg() {
			return fg;
		}
		public void setFg(boolean fg) {
			this.fg = fg;
		}
		public String getFxlogurl() {
			return fxlogurl;
		}
		public void setFxlogurl(String fxlogurl) {
			this.fxlogurl = fxlogurl;
		}
		public String getSc_li1() {
			return sc_li1;
		}
		public void setSc_li1(String sc_li1) {
			this.sc_li1 = sc_li1;
		}
		public String getSc_li2() {
			return sc_li2;
		}
		public void setSc_li2(String sc_li2) {
			this.sc_li2 = sc_li2;
		}
		public String getTkllr() {
			return tkllr;
		}
		public void setTkllr(String tkllr) {
			this.tkllr = tkllr;
		}
		public String getShop_url() {
			return shop_url;
		}
		public void setShop_url(String shop_url) {
			this.shop_url = shop_url;
		}
		public String getNotice() {
			return notice;
		}
		public void setNotice(String notice) {
			this.notice = notice;
		}
		public String getTemplate_id() {
			return template_id;
		}
		public void setTemplate_id(String template_id) {
			this.template_id = template_id;
		}
		public String getJp_imgurl() {
			return jp_imgurl;
		}
		public void setJp_imgurl(String jp_imgurl) {
			this.jp_imgurl = jp_imgurl;
		}
		public String getYd_imgurl() {
			return yd_imgurl;
		}
		public void setYd_imgurl(String yd_imgurl) {
			this.yd_imgurl = yd_imgurl;
		}
		public String getBj_imgurl() {
			return bj_imgurl;
		}
		public void setBj_imgurl(String bj_imgurl) {
			this.bj_imgurl = bj_imgurl;
		}
		public String getActivity_name() {
			return activity_name;
		}
		public void setActivity_name(String activity_name) {
			this.activity_name = activity_name;
		}
		public String getFx_li() {
			return fx_li;
		}
		public void setFx_li(String fx_li) {
			this.fx_li = fx_li;
		}
		public String getSc_li() {
			return sc_li;
		}
		public void setSc_li(String sc_li) {
			this.sc_li = sc_li;
		}
		public String getGz_li() {
			return gz_li;
		}
		public void setGz_li(String gz_li) {
			this.gz_li = gz_li;
		}
		public String getJrgwc_li() {
			return jrgwc_li;
		}
		public void setJrgwc_li(String jrgwc_li) {
			this.jrgwc_li = jrgwc_li;
		}
		public String getShopNum() {
			return shopNum;
		}
		public void setShopNum(String shopNum) {
			this.shopNum = shopNum;
		}
		public String getActivity_url() {
			return activity_url;
		}
		public void setActivity_url(String activity_url) {
			this.activity_url = activity_url;
		}
		public int getRes() {
			return res;
		}
		public void setRes(int res) {
			this.res = res;
		}
		public String getActivity_hdsm() {
			return activity_hdsm;
		}
		public void setActivity_hdsm(String activity_hdsm) {
			this.activity_hdsm = activity_hdsm;
		}
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getActivity_id() {
			return activity_id;
		}
		public void setActivity_id(String activity_id) {
			this.activity_id = activity_id;
		}
		public String getShopname() {
			return shopname;
		}
		public void setShopname(String shopname) {
			this.shopname = shopname;
		}
		public int getLotteryNumber() {
			return lotteryNumber;
		}
		public void setLotteryNumber(int lotteryNumber) {
			this.lotteryNumber = lotteryNumber;
		}
		public String getResText() {
			return resText;
		}
		public void setResText(String resText) {
			this.resText = resText;
		}
		
	}
}