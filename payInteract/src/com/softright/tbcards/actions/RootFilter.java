package com.softright.tbcards.actions;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.softright.tbcards.Constants;
import com.softright.utils.properties.ReadProperties;

public class RootFilter implements Filter  {
	private static Logger logger = Logger.getLogger(RootFilter.class);
//	static final String hthost="admin.wowlg.com";
//	static final String wxhost="m.wowlg.com";
	private static ReadProperties property=ReadProperties.getInit(); 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getRequestURI();
		if(StringUtils.contains(request.getServerName(), property.getProperty("hthost"))){//后台
			if(url != null && !url.equals("") && !url.equals("/")){
				chain.doFilter(request, response);
			}else{
				response.sendRedirect(Constants.getAppCallUrl(request)+"?"+request.getQueryString());
			}
		}else if(StringUtils.contains(request.getServerName(), property.getProperty("wxhost"))){//无线
			if(url != null && !url.equals("") && !url.equals("/")){
				chain.doFilter(request, response);
			}else{
				StringBuffer url1 = request.getRequestURL();
				String host = url1.substring(0, url1.indexOf("/",8));
				response.sendRedirect(host+"/wap/Index.wap2?"+request.getQueryString());
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
