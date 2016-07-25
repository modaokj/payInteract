package com.softright.tbcards.actions.admin.groupon;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.handwin.db.DataService;
import com.handwin.db.FlipResult;
import com.handwin.web.json.FormField;
import com.handwin.web.json.TransactionAction;
import com.softright.tbcards.AlertResult;
import com.softright.tbcards.Constants;
import com.softright.tbcards.PassportNew;

public class GrouponActivityAction extends TransactionAction{
	private static Logger logger = Logger.getLogger(GrouponActivityAction.class);
	@FormField(name="操作类型",required=true)
	private int operationType;//1为跳转到添加视图，2为进行添加操作，3为跳转到活动发布 4为正在进行的活动 5为已经结束的活动 6为删除 7修改活动  8  活动列表主页 9修改活动的页面 
	@FormField(name="条数",required=false)
	private int pageSize=5;
	@FormField(name="当前页",required=false)
	private int page=0;
	
	private static final double PERIOD_DAY = 24 * 60 * 60 * 1000;
	@Override
	public Object exec() throws Exception {
		PassportNew ppt = PassportNew.fromString(this.getCookieValue(Constants.PASSPORT_COOKIE_NAME));
		Result rlt=new Result();
		DataService dao = new DataService();
		try {
			
			
		} catch (Exception e) {
			// TODO: handle exception
			this.logger.error("操作失败！",e);
		}finally{
			dao.close();
		}
		return rlt;
	}
	public static void main(String[] args) {
		String activity_id=String.valueOf(new Date().getTime());
	}
	@Override
	public Object onInputError(String errorMsg) {
		return AlertResult.buildFail(errorMsg);
	}
	public class Result  implements FlipResult{

		@Override
		public void setTotalPage(int page) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getTotalPage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setTotalRecord(int total) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getTotalRecord() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setData(List data) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List getData() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setCurPage(int page) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getCurPage() {
			// TODO Auto-generated method stub
			return 0;
		}}
	@Override
	public Object onTransactionException(Exception e) {
		// TODO Auto-generated method stub
		return null;
	}
}
