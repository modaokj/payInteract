package com.softright.tbcards.actions;


import com.handwin.web.json.TransactionAction;
import com.softright.tbcards.Constants;
/**
 * 认证登录流程
 * https://oauth.taobao.com/authorize?response_type=code&client_id=23077748&redirect_uri=http://hp.360crm.cn/2/&state=1212&view=web
 * 
 * @author conan
 *
 */
public class ToOauthAction extends TransactionAction {

	@SuppressWarnings("static-access")
	@Override
	public Object exec() {
		StringBuffer url = this.getRequest().getRequestURL();
		String host = url.substring(0, url.indexOf("/",8));
		this.setRedirect("https://oauth.taobao.com/authorize?response_type=code&client_id="+Constants.APP_KEY+"&redirect_uri="+host+"/token");
		return null;
	}

	@Override
	public Object onTransactionException(Exception e) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
