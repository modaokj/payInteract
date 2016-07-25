package com.softright.tbcards.actions;

import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;

import com.handwin.db.DataService;
import com.handwin.web.json.FormField;
import com.handwin.web.json.JsonAction;
import com.handwin.web.json.TransactionAction;
import com.softright.tbcards.Constants;
import com.softright.tbcards.PassportNew;
import com.softright.tbcards.actions.admin.IndexAction;
import com.softright.tbcards.po.User;

public class TestLoginAction extends TransactionAction {
	private static Logger logger = Logger.getLogger(IndexAction.class);
	@FormField(name="ID",required=true)
	private String userId;
	
	@Override
	public Object exec() throws Exception {
		DataService dao= null;
		try {
			this.logger.info("进入到testlogin");
			dao = new DataService();
			User user = (User) dao.locate(User.class,userId);
			PassportNew passport=new PassportNew(userId, user.getId(), "1","cardid");
			Cookie cookie=new Cookie(Constants.PASSPORT_COOKIE_NAME,passport.toString());
			//cookie.setDomain("card.cd");
			cookie.setPath("/");
			JsonAction.addCookie(cookie);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(null!=dao){
				dao.close();
			}
		}
		
		return "ok"+userId;
	}

	@Override
	public Object onTransactionException(Exception arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
