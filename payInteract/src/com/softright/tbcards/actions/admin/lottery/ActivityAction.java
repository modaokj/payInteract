package com.softright.tbcards.actions.admin.lottery;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.google.gson.annotations.Expose;
import com.handwin.db.DataService;
import com.handwin.web.json.FormField;
import com.handwin.web.json.TransactionAction;
import com.softright.tbcards.Constants;
import com.softright.tbcards.PassportNew;
import com.softright.tbcards.actions.result.BaseResult;
import com.softright.tbcards.po.ActivityOptions;
import com.softright.tbcards.po.ActivityPublish;
import com.softright.tbcards.po.LotteryActivity;
import com.softright.tbcards.po.User;
import com.softright.utils.Validit;
import com.softright.utils.codeImage.CodeImageCompatibility;

public class ActivityAction extends TransactionAction{
	private static Logger logger = Logger.getLogger(ActivityAction.class);
	@FormField(name="操作类型",required=true)
	private int operationType;//1:预创建活动  2：创建活动 3：修改活动 4:发布活动 5:查看活动
	@FormField(name="活动id",required=false)
	private String id;
	@FormField(name="LotteryActivity参数",required=false)
	private LotteryActivity lotteryActivity;
	@FormField(name="ActivityOptions参数",required=false)
	private ActivityOptions activityOptions;
	@Override
	public Object exec() throws Exception {
		PassportNew ppt = PassportNew.fromString(this.getCookieValue(Constants.PASSPORT_COOKIE_NAME));
		Result rlt=new Result();
		DataService dao = new DataService();
		User user=Validit.getUser(ppt, dao);
		if(null==user){
			setRedirect("404");
			return rlt;
		};
		try {
			Criteria query = dao.getSession().createCriteria(LotteryActivity.class);
			List<LotteryActivity> list=new ArrayList<LotteryActivity>();
			//如果字符串不是null
			if(StringUtils.isNotBlank(id)){
				query.add(Restrictions.eq(LotteryActivity.ID, id));
			}else{
				query.add(Restrictions.eq(LotteryActivity.TAOBAO_ID, user.getId()));
				String status=LotteryActivity.STATUS_C;
				if(operationType==1 || operationType==2){//创建活动的时候去根据w状态查询  是否已经存在预创建活动
					status=LotteryActivity.STATUS_W;
				}else{
					//保证数据是正在进行中的活动
					query.add(Restrictions.le(LotteryActivity.ACTIVITY_STARTDATE, new Date()));//＜＝
			    	query.add(Restrictions.ge(LotteryActivity.ACTIVITY_ENDDATE, new Date()));//＞＝
				}
				query.add(Restrictions.eq(LotteryActivity.ACTIVITY_STATUS,status));
			}
			list=query.list();
			if(operationType==1){//预创建活动数据
				if(list.size()<=0){
					id=String.valueOf(new Date().getTime());
					LotteryActivity activity =new LotteryActivity();
					activity.setId(id);
					activity.setTaobao_id(user.getId());
					activity.setActivity_status(LotteryActivity.STATUS_W);
					dao.insert(activity);
					rlt.setStatus(activity.getActivity_status());
				}else{
					id=list.get(0).getId();
					rlt.setStatus(list.get(0).getActivity_status());
				}
				rlt.setActivity_id(id);
				setRedirect("admin/lottery/create_activity");
			}else if(operationType==2 || operationType==3){//2 创建活动  3 修改活动
				if(null==lotteryActivity || (null==lotteryActivity.getId() || lotteryActivity.getId().length()<=0)){
					rlt.setCode(1);
					rlt.setCodeText("输入的活动数据不存在！");
					return rlt;
				}
				if(null==activityOptions ){
					rlt.setCode(1);
					rlt.setCodeText("输入的活动数据不存在！");
					return rlt;
				}
				if(list.size()<=0){
					rlt.setCode(2);
					rlt.setCodeText("要创建的活动记录不存在！");
					return rlt;
				}
				LotteryActivity activity = list.get(0);
				lotteryActivity.setId(activity.getId());
				if(null==lotteryActivity.getActivity_startDate() || null==lotteryActivity.getActivity_endDate()){
					rlt.setCode(3);
					rlt.setCodeText("开始时间和结束时间输入不正确！");
					return rlt;
				}
				//判断开始时间是否大于等于结束时间
				if(lotteryActivity.getActivity_startDate().after(lotteryActivity.getActivity_endDate())){
					rlt.setCode(4);
					rlt.setCodeText("开始时间不能大于或等于结束时间！");
					return rlt;
				}
				if(operationType==2){
					lotteryActivity.setActivity_createDate(new Date());
					String url="http://"+Constants.LOTTERY_URL+Constants.LOTTERY_ACTION_URL+"?id="+activity.getId();
					lotteryActivity.setMaQrcode_url_long(url);//活动地址原始链接
					logger.info("二维码生成数据："+user.getSessionKey()+"| url="+url +" | name="+user.getNick() +" | user.getShopImgUrl()="+user.getShopImgUrl());
					try {
						 String imgout=CodeImageCompatibility.encodeQRCodeImage(url,activity.getId(), this.getRequest());
						 activity.setMaQrcode_img_url(imgout);//二维码图片地址
						 lotteryActivity.setMaQrcode_url(url);//二维码链接地址
					} catch (Exception e) {
						logger.error("二维码生成失败!",e);
						rlt.setCode(5);
						rlt.setCodeText("活动二维码生成失败！");
						return rlt;
					}
					activityOptions.setId(String.valueOf(lotteryActivity.getId()));
					activityOptions.setTaobao_id(lotteryActivity.getTaobao_id());
					activityOptions.setCreate_time(new Date());
				}else{
					//正在修改活动，需要查询出原有的设置信息
					ActivityOptions  options= (ActivityOptions) dao.locate(ActivityOptions.class,lotteryActivity.getId());
					if(null==options){
						rlt.setCode(6);
						rlt.setCodeText("活动参数不存在，当前不允许修改！");
					}
					activityOptions.setId(options.getId());
					activityOptions.setTaobao_id(options.getTaobao_id());
					activityOptions.setCreate_time(options.getCreate_time());
				}
				dao.save(lotteryActivity);
				dao.save(activityOptions);
				dao.commit();
			}else if(operationType==4){//发布活动
				if(list.size()<=0){
					rlt.setCode(1);
					rlt.setCodeText("要发布的活动不存在！");
					return rlt;
				}
				LotteryActivity activity = list.get(0);
				ActivityPublish  publish= (ActivityPublish) dao.locate(ActivityPublish.class,lotteryActivity.getId());
				if(null ==publish){
					publish=new ActivityPublish();
					publish.setId(activity.getId());
					publish.setTaobao_id(activity.getTaobao_id());
				}
				dao.save(publish);
				dao.commit();
			}else if(operationType==5){//查看活动
				if(list.size()<=0){
					rlt.setCode(1);
					rlt.setCodeText("要查看的活动不存在！");
					return rlt;
				}
				LotteryActivity activity = list.get(0);
				String url=null;
				if(StringUtils.isNotBlank(activity.getMaQrcode_img_url())){
					try {
						File file=new File(activity.getMaQrcode_img_url());
						if(!file.exists()){
							url="http://"+Constants.LOTTERY_URL+Constants.LOTTERY_ACTION_URL+"?id="+activity.getId();
							activity.setMaQrcode_url_long(url);//活动地址原始链接
							logger.info("二维码生成数据："+user.getSessionKey()+"| url="+url +" | name="+user.getNick() +" | user.getShopImgUrl()="+user.getShopImgUrl());
							try {
								 String imgout=CodeImageCompatibility.encodeQRCodeImage(url,activity.getId(), this.getRequest());
								 activity.setMaQrcode_img_url(imgout);//二维码图片地址
								 activity.setMaQrcode_url(url);//二维码链接地址
								 dao.save(activity);
								 dao.commit();
							} catch (Exception e) {
								logger.error("二维码生成失败!",e);
								rlt.setCode(5);
								rlt.setCodeText("活动二维码生成失败！");
								return rlt;
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
						logger.error("二维码图片文件校验失败!",e);
						rlt.setCode(5);
						rlt.setCodeText("二维码图片文件校验失败！");
						return rlt;
					}
					
				}
				rlt.setActivityUrl(url);
				rlt.setImgCodeUrl(activity.getMaQrcode_img_url());
			}
		} catch (Exception e) {
			// TODO: handle exception
			this.logger.error("操作失败！",e);
		}finally{
			if(null!=dao){
				dao.close();
			}
		}
		return rlt;
	}
	public class Result extends BaseResult{
		@Expose
		private String activity_id;
		@Expose
		private String status;
		@Expose
		private String imgCodeUrl;
		@Expose
		private String activityUrl;
		
		public String getImgCodeUrl() {
			return imgCodeUrl;
		}
		public void setImgCodeUrl(String imgCodeUrl) {
			this.imgCodeUrl = imgCodeUrl;
		}
		public String getActivityUrl() {
			return activityUrl;
		}
		public void setActivityUrl(String activityUrl) {
			this.activityUrl = activityUrl;
		}
		public String getActivity_id() {
			return activity_id;
		}
		public void setActivity_id(String activity_id) {
			this.activity_id = activity_id;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
    }
	@Override
	public Object onTransactionException(Exception e) {
		// TODO Auto-generated method stub
		return null;
	}
}
